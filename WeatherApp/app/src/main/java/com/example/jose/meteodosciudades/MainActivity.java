package com.example.jose.meteodosciudades;

import android.app.FragmentTransaction;
import android.content.Context;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    ClaseFragmento fragmentoPrincipal;
    ClaseFragmento fragmentoSecundario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.findFragmentById(R.id.frameLayoutVertical) == null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            fragmentoPrincipal = new ClaseFragmento();
            transaction.add(R.id.frameLayoutVertical, fragmentoPrincipal);
            transaction.commit();
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            FragmentManager fragmentManager2 = getFragmentManager();
            if (fragmentManager2.findFragmentById(R.id.frameLayoutHorizontalDcha) == null) {
                FragmentTransaction transaction2 = fragmentManager2.beginTransaction();
                fragmentoSecundario = new ClaseFragmento();
                transaction2.add(R.id.frameLayoutHorizontalDcha, fragmentoSecundario);
                transaction2.commit();
            }

        }
    }

}

    /*
      No hay que sobreescribir los métodos onSaveInstanceState y onRestoreInstanceState, porque
      los fragmentos nunca se destruyen, aunque se gire la pantalla.
     */
