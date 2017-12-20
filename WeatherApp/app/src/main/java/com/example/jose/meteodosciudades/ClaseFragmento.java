package com.example.jose.meteodosciudades;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;

/**
 * Created by jose on 31/03/17.
 */

public class ClaseFragmento extends Fragment {

    SharedPreferences pref;
    JSONTask jsonTask;
    //Context context;
    ImageView ivTiempo;
    TextView tvTiempo1, tvTiempo2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        tvTiempo1 = (TextView) view.findViewById(R.id.textViewTiempo);
        tvTiempo2 = (TextView) view.findViewById(R.id.textViewTiempo2);
        final Spinner spCiudades = (Spinner) view.findViewById(R.id.sp_ciudades);
        ivTiempo = (ImageView) view.findViewById(R.id.imageViewTiempo);

            //int defaultPosition = pref.getInt("posicion", 0);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCiudades.setAdapter(adapter);

        spCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //SharedPreferences.Editor editor = pref.edit();
                //editor.putInt("posicion", position);
                //editor.apply();  // Equivale al "commit" de otras clases.
                String selectedCity = parent.getItemAtPosition(position).toString();
                launchTask(selectedCity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    String buildURL(String selectedCity) {

        final String webAddressPart1 = "http://api.openweathermap.org/data/2.5/weather?q=";
        final String webAddressPart2 = "&appid=db87faa1ae2eb9f5b56d2d2bd6e11ff2&units=metric&lang=es";
        String completeUrl = "";
        completeUrl = webAddressPart1 + selectedCity + webAddressPart2;
        return completeUrl;
    }


    void launchTask(String city) {
        if ((jsonTask == null) || (jsonTask.getStatus() == AsyncTask.Status.FINISHED)) {  // Cambiando el orden, da un NPE
            jsonTask = new JSONTask();
            String requestedURL = buildURL(city);
            jsonTask.execute(requestedURL);
            try {
                jsonTask.get();  // Espera hasta que la tarea termine
            } catch (Exception e) {
                Log.e("Excepción", e.getMessage());
            }

        }
    }

    private class JSONTask extends AsyncTask<String, Long, Weather> {

        @Override
        protected Weather doInBackground(String... urls) {
            Weather weather = new Weather();

            String data = Utilities.sendPostRequest(urls[0]);

            if (data != null) {   // Solo se hace algo si hay conectividad
                try {
                    weather = JSONWeatherParser.getWeather(data);
                    String iconUrl = "http://openweathermap.org/img/w/" + weather.currentCondition.getIcon() + ".png";
                    //context = getActivity().getApplicationContext();
                    // IMPORTANTE ---> El contexto es una actividad, ya que Context hereda de Activity.
                    weather.iconData = Utilities.getInternetBitmap(getActivity(), iconUrl);
                } catch(JSONException e){
                e.printStackTrace();
            }

        }
            return weather;

        }

        @Override
        protected void onPostExecute(Weather weather)
        {
            if (weather != null) {   // Solo se hace algo si hay conectividad
                updateControls(weather);
            }

        }

        private void updateControls(Weather weather) {
            String ciudad = weather.location.getCity();
            String description = weather.currentCondition.getDescr();
            StringBuilder descriptionUC = new StringBuilder(description);
            descriptionUC.setCharAt(0, Character.toUpperCase(descriptionUC.charAt(0)));  // Pone en mayúsculas la primera letra
            String temperature = String.valueOf(Math.round(weather.temperature.getTemp())) + " grados";
            Log.i("M E N S A J E S :     ", temperature);
            tvTiempo1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            tvTiempo1.setText(descriptionUC.toString());
            tvTiempo2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
            tvTiempo2.setText(temperature);

            Bitmap bitmap = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
            ivTiempo.setImageBitmap(bitmap);

        }

    }    // Final de la clase privada que hereda de AsyncTask

}


























