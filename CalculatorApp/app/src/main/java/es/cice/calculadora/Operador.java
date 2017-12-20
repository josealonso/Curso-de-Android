package es.cice.calculadora;

/**
 * Created by jose on 24/03/17.
 */

public abstract class Operador {

    protected String simbolo;

    public abstract int operar(int a, int b);
}
