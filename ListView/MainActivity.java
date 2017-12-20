package es.cice.clienteslv;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Customer> lista = new ArrayList<>();
        lista.add(new Customer("H", "Manolo", "125498656"));
        lista.add(new Customer("M", "Anita", "125498656"));
        lista.add(new Customer("H", "Manolito", "125498656"));
        lista.add(new Customer("H", "Jaime", "125498656"));
        lista.add(new Customer("M", "Belén", "125498656"));
        lista.add(new Customer("H", "Antonio", "125498656"));
        lista.add(new Customer("M", "Anita", "125498656"));
        lista.add(new Customer("M", "Anita", "125498656"));
        lista.add(new Customer("M", "Anita", "125498656"));
        lista.add(new Customer("M", "Anita", "125498656"));
        lista.add(new Customer("M", "Anita", "125498656"));
        lista.add(new Customer("H", "Anita", "125498656"));
        lista.add(new Customer("H", "Anita", "125498656"));
        lista.add(new Customer("H", "Anita", "125498656"));
        lista.add(new Customer("H", "Anita", "125498656"));

        CustomerAdapter customerAdapter = new CustomerAdapter(context, R.layout.man_customer, lista);
        ListView listView = (ListView) findViewById(R.id.listaClientes);
        listView.setAdapter(customerAdapter);

    }
}






