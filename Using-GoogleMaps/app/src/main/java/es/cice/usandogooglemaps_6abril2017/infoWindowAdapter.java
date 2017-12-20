package es.cice.usandogooglemaps_6abril2017;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

//import InfoWindowAdapter;

/**
 * Created by cice on 6/4/17.
 */

public class infoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    Activity activity;

    public infoWindowAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public View getInfoContents(Marker marker) {

        View view = activity.getLayoutInflater().inflate(R.layout.marker_window, null);
        ImageView imageViewFoto = (ImageView) view.findViewById(R.id.imageView);
        TextView textViewPosicion = (TextView) view.findViewById(R.id.textView1);
        TextView textViewTitulo = (TextView) view.findViewById(R.id.textView2);

        imageViewFoto.setImageResource(R.drawable.bmp);
        textViewTitulo.setText(marker.getTitle());
        textViewPosicion.setText(marker.getPosition().toString());
        return view;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

}
