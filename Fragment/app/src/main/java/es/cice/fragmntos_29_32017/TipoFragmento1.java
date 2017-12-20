package es.cice.fragmntos_29_32017;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by cice on 29/3/17.
 */

public class TipoFragmento1 extends Fragment implements View.OnClickListener {

    //Context context = this;
    public Button boton;
    int displayMode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento1, container, false);
        boton = (Button) view.findViewById(R.id.buttonPrueba);
        boton.setOnClickListener(this);

        displayMode = getResources().getConfiguration().orientation;

        return view;
    }

    // Button boton = (Button) findViewById(R.id.buttonPrueba);

    /* boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                MainActivity.dismiss();
                startActivity(intent);
            }
        });  */

    public void verDetalleCliente() {

    }

    @Override
    public void onClick(View v) {
        // se lo comunico a la actividad correspondiente
        // getContext()
        if (displayMode == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            startActivity(intent);
        }

    }
}
