package co.edu.uniquindio.poo.biblioteca2.model;

import java.time.LocalDate;
import java.util.List;

public class Administrador extends Empleado{
    private Empleado empleado;
    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario;
    private List<Usuario> listUsuarios;

    public Administrador(String nombre, String identificacion, String genero, String correo, String telefono, int edad, double sueldo, Cargo cargo, Bibliotecario bibliotecario ) {
        super(nombre, identificacion, genero, correo, telefono, edad, sueldo, cargo);
        this.bibliotecario = bibliotecario;
    }

    public double reportePorcentajeDeUsuariosNoDeudores(){
        int cantUsuariosNoDeudores = listUsuarios.size() - bibliotecario.reporteUsuariosDeudores().size();
        double porcentajeDeUsuariosNoDeudores = (cantUsuariosNoDeudores*100)/listUsuarios.size();
        return porcentajeDeUsuariosNoDeudores;
    }
    public boolean registrarEmpleado(String identificacion) {
        return biblioteca.agregarEmpleado(identificacion);
    }

    public boolean eliminarEmpleado(String identificacion) {
        return biblioteca.eliminarEmpleado(identificacion);
    }

    public boolean modificarEmpleado(String identificacion, Empleado actual) {
        return biblioteca.actualizarEmpleado(identificacion, actual);
    }

    public List<Prestamo> reportePrestamosSemana(LocalDate fecha, ){

    }

}
