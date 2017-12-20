package es.cice.fragmntos_29_32017;

//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Clientes> listaClientes;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Intent intent;
        rellenaLista();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TipoFragmento1 miFragmento = new TipoFragmento1();
        transaction.add(R.id.fragment1, miFragmento);
        transaction.commit();

        //ListView listView = (ListView) findViewById(R.id.fragment1); // Estas 2 líneas cerraban la aplicación
        //Button boton = (Button) findViewById(R.id.buttonPrueba);

        /*    boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                //MainActivity.dismiss();
                startActivity(intent);
            }
        }); */
    }

    void rellenaLista() {
        listaClientes = new ArrayList<>();
        listaClientes.add(new Clientes("Jose", "Lopez", "Alcala", 666745892));
        listaClientes.add(new Clientes("Emilio", "Tovar", "Sevilla", 634741256));
    }

}
