package co.edu.uniquindio.poo.biblioteca2.model;

public class Empleado extends Persona {
    private double sueldo;
    private Cargo cargo;


    public Empleado(String nombre, String identificacion, String genero, String correo, String telefono, int edad, double sueldo, Cargo cargo) {
        super(nombre, identificacion, genero, correo, telefono, edad);
        this.sueldo = sueldo;
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
