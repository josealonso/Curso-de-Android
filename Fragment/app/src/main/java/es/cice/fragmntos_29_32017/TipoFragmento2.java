package es.cice.fragmntos_29_32017;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by cice on 29/3/17.
 */

public class TipoFragmento2 extends Fragment {

    public TextView TVNombre;
    public TextView TVApellidos;
    public TextView TVDireccion;
    public TextView TVTelefono;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmento2, container, false);
        TVNombre = (TextView) view.findViewById(R.id.textViewNombre);
        TVApellidos = (TextView) view.findViewById(R.id.textViewApellidos);
        TVNombre.setText();
        return view;
    }
}
