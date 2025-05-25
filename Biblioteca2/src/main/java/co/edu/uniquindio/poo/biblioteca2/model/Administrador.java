package co.edu.uniquindio.poo.biblioteca2.model;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Empleado{
    private Empleado empleado;
    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario;
    private List<Usuario> listUsuarios;

    public Administrador(String nombre, String identificacion, String genero, String correo, String telefono, int edad, double sueldo, Cargo cargo ) {
        super(nombre, identificacion, genero, correo, telefono, edad, sueldo, cargo);
        this.bibliotecario = bibliotecario;
        this.listUsuarios = listUsuarios;
    }

    /**
     * Metodo para generar reporte del porcentaje de usuarios que no tienen deudas en la biblioteca
     * @return
     */
    public double reportePorcentajeDeUsuariosNoDeudores(LocalDate fecha) {
        int cantUsuariosNoDeudores = listUsuarios.size() - bibliotecario.reporteUsuariosDeudores(fecha).size();
        double porcentajeDeUsuariosNoDeudores = (cantUsuariosNoDeudores*100)/listUsuarios.size();
        JOptionPane.showMessageDialog(null, porcentajeDeUsuariosNoDeudores + "%");
        return porcentajeDeUsuariosNoDeudores;
    }

    public boolean registrarEmpleado(Empleado empleado) {
        boolean centinela = true;
        if(!biblioteca.agregarEmpleado(empleado)){
            JOptionPane.showMessageDialog(null, "Hey, ya hay un empleado con ese identificacion");
            centinela = false;
        }
        else{
            biblioteca.agregarEmpleado(empleado);
        }
        return centinela;
    }

    public boolean eliminarEmpleado(String identificacion) {
        return biblioteca.eliminarEmpleado(identificacion);
    }

    public boolean modificarEmpleado(String identificacion, Empleado actual) {
        return biblioteca.actualizarEmpleado(identificacion, actual);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }
}
