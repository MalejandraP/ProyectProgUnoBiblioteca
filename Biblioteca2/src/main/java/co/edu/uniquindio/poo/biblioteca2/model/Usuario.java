package co.edu.uniquindio.poo.biblioteca2.model;

import java.util.List;

public  class Usuario extends Persona{
    private Tipo tipo;

    public Usuario(String nombre, String identificacion, String genero, String correo, String telefono, int edad, Tipo tipo) {
        super(nombre, identificacion, genero, correo, telefono, edad);
        this.tipo = tipo;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
