package es.cice.fragmntos_29_32017;

/**
 * Created by cice on 29/3/17.
 */

public class Clientes {

        private String nombre;
        private String apelidos;
        private String direccion;
        private int telefono;

        public Clientes(String nombre, String apelidos, String direccion, int telefono) {
            this.nombre = nombre;
            this.apelidos = apelidos;
            this.direccion = direccion;
            this.telefono = telefono;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApelidos() {
            return apelidos;
        }

        public void setApelidos(String apelidos) {
            this.apelidos = apelidos;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

}


