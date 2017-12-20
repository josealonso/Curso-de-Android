package es.cice.calculadora;

//import Operador;

/**
 * Created by jose on 24/03/17.
 */

public class Operaciones extends Operador {

    @Override
    public int operar(int a, int b) {
        if (simbolo.equals("+")) {
            return a + b;
        }
        else if (simbolo.equals("-")) {
            return a - b;
        }
        else if (simbolo.equals("*")) {
            return a * b;
        }
        else if (simbolo.equals("/")) {
            return a / b;
        }
        return -1;
    }
}
