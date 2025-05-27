package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Administrador;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca2.model.Empleado;

import java.util.Collection;
import java.util.List;

import static co.edu.uniquindio.poo.biblioteca2.App.biblioteca;

public class GestionEmpleadoController {
    private App app;
    Administrador administrador;
    Biblioteca biblioteca;

    public GestionEmpleadoController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void regresar(){
        app.openCrudAdministrador(administrador);
    }

    public boolean agregarEmpleado(Empleado empleado){
        return administrador.registrarEmpleado(empleado);
    }

    public List<Empleado> obtenerListaEmpleados() {
        return biblioteca.getListEmpleados();
    }

    public boolean eliminarEmpleado(String identificacion) {
        boolean centinela = false;
        if (administrador != null){
            administrador.eliminarEmpleado(identificacion);
            centinela = true;
        }
        return centinela;
    }

    public boolean actualizarEmpleado(String identificacion, Empleado actualizado) {
        boolean centinela = false;
        if(administrador != null){
            administrador.modificarEmpleado(identificacion, actualizado);
            centinela = true;
        }
        return centinela;
    }

    public void setApp(App app) {
        this.app = app;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
