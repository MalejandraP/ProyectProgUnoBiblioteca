package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Empleado;

import static co.edu.uniquindio.poo.biblioteca2.App.biblioteca;

public class GestionEmpleadoController {
    private App app;

    public void regresar(){
        app.openCrudAdministrador();
    }

    public boolean agregarEmpleado(Empleado empleado){
        biblioteca.agregarEmpleado(empleado);
        return true;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
