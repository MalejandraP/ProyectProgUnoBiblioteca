package co.edu.uniquindio.poo.biblioteca2.model;

public class Empleado extends Persona {
    private double sueldo;
    private Cargo cargo;


    /**
     * Contructor de la clase empleado
     * @param nombre
     * @param identificacion
     * @param genero
     * @param correo
     * @param telefono
     * @param edad
     * @param sueldo
     * @param cargo
     */
    public Empleado(String nombre, String identificacion, String genero, String correo, String telefono, int edad, double sueldo, Cargo cargo) {
        super(nombre, identificacion, genero, correo, telefono, edad);
        this.sueldo = sueldo;
        this.cargo = cargo;
    }


    /**
     * Obtener cargo
     * @return
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * Modifica cargo
     * @param cargo
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * Obtener sueldo
     * @return
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Modificar sueldo
     * @param sueldo
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
