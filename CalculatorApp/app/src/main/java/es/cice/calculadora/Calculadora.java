package es.cice.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity implements View.OnClickListener {

    Operaciones operacion;
    private boolean esPrimerOperando = true;
    private int primerOperando = 0;
    private int segundoOperando = 0;
    private int resultado = 0;
    private TextView cajaDeResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operacion = new Operaciones();
        cajaDeResultado = (TextView) findViewById(R.id.textViewResultado);

        Button botonUno = (Button) findViewById(R.id.cifra1);
        botonUno.setOnClickListener(this); // calling onClick() method
        Button botonDos = (Button) findViewById(R.id.cifra2);
        botonDos.setOnClickListener(this);
        Button botonTres = (Button) findViewById(R.id.cifra3);
        botonTres.setOnClickListener(this);
        Button botonCuatro = (Button) findViewById(R.id.cifra4);
        botonCuatro.setOnClickListener(this);
        Button botonCinco = (Button) findViewById(R.id.cifra5);
        botonCinco.setOnClickListener(this);
        Button botonSeis = (Button) findViewById(R.id.cifra6);
        botonSeis.setOnClickListener(this);
        Button botonSiete = (Button) findViewById(R.id.cifra7);
        botonSiete.setOnClickListener(this);
        Button botonOcho = (Button) findViewById(R.id.cifra8);
        botonOcho.setOnClickListener(this);
        Button botonNueve = (Button) findViewById(R.id.cifra9);
        botonNueve.setOnClickListener(this);

        Button botonSuma = (Button) findViewById(R.id.operadorSuma);
        botonSuma.setOnClickListener(this);
        Button botonResta = (Button) findViewById(R.id.operadorResta);
        botonResta.setOnClickListener(this);
        Button botonMultiplicacion = (Button) findViewById(R.id.operadorMultiplicacion);
        botonMultiplicacion.setOnClickListener(this);
        Button botonDivision = (Button) findViewById(R.id.operadorDivision);
        botonDivision.setOnClickListener(this);
        Button botonIgualA = (Button) findViewById(R.id.operadorIgualA);
        botonIgualA.setOnClickListener(this);
        Button botonBorrar = (Button) findViewById(R.id.buttonBorrar);
        botonBorrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        String idBoton = getResources().getResourceName(id);
        if (idBoton.startsWith("operador")) {

            if (idBoton.endsWith("Suma")) {
                cajaDeResultado.setText("+");
                operacion.simbolo = "+";
                esPrimerOperando = false;
            }
            else if (idBoton.endsWith("Resta")) {
                cajaDeResultado.setText("-");
                operacion.simbolo = "-";
                esPrimerOperando = false;
            }
            else if (idBoton.endsWith("Division")) {
                cajaDeResultado.setText("/");
                operacion.simbolo = "/";
                esPrimerOperando = false;

            }
            else if (idBoton.endsWith("Multiplicacion")) {
                cajaDeResultado.setText("*");
                operacion.simbolo = "*";
                esPrimerOperando = false;
            }

            else if (idBoton.endsWith("IgualA")) {

                resultado = operacion.operar(primerOperando, segundoOperando);
                cajaDeResultado.setText(resultado);
                primerOperando = 0;
                segundoOperando = 0;
                esPrimerOperando = true;
            }


        }
        else if (idBoton.startsWith("cifra")) {
            int digito = Integer.parseInt(idBoton.substring(idBoton.length() - 1) );   //(idBoton.length() - 1);
            componerOperando(digito);
        }
        else if (idBoton.endsWith("Borrar")) {
            primerOperando = 0;
            segundoOperando = 0;
            resultado =  0;
            cajaDeResultado.setText("");
            esPrimerOperando = true;
        }

    }

    private void componerOperando(int cifra) {

        int operando = segundoOperando;
        if (esPrimerOperando == true)
            operando = primerOperando;
        else
            operando = segundoOperando;

        if (operando == 0) {
            operando = cifra;
        }

        else {
            operando = operando * 10 + cifra;
        }

        cajaDeResultado.setText(operando);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("Primer operando", primerOperando);
        savedInstanceState.putInt("Segundo operando", segundoOperando);
        savedInstanceState.putInt("Resultado", resultado);
        savedInstanceState.putBoolean("Es el primer operando", esPrimerOperando);
        savedInstanceState.putString("Operacion", operacion.simbolo);
        savedInstanceState.putString("Lo que se ve", cajaDeResultado.getText().toString());
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        cajaDeResultado.setText(savedInstanceState.getString("Lo que se ve"));
        primerOperando = savedInstanceState.getInt("Primer operando");
        segundoOperando = savedInstanceState.getInt("Segundo operando");
        resultado = savedInstanceState.getInt("Resultado");
        esPrimerOperando = savedInstanceState.getBoolean("Es el primer operando");
        operacion.simbolo = savedInstanceState.getString("Operacion");
    }


}


/*
Método setTypeFace
Crear una carpeta "assets" en src
 */

