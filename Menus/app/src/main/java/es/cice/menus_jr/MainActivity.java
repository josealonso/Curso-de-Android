package es.cice.menus_jr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    FragmentoUno fragmentoUno = null;
    FragmentoDos fragmentoDos = null;
    FragmentoTres fragmentoTres = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se crean tres fragmentos
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragmentoUno = new FragmentoUno();
        //fragmentoDos = new FragmentoDos();
        //fragmentoTres = new FragmentoTres();
        transaction.commit();
    }

    void mostrarFragmento(int cual) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.frag1Item:
                mostrarFragmento(1);
                return true;
            case R.id.frag2Item:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                fragmentoDos = new FragmentoDos();
                transaction.add(R.id.frag2Layout, fragmentoDos);
                transaction.commit();
                mostrarFragmento(2);
                return true;
            case R.id.frag3Item:
                mostrarFragmento(3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
