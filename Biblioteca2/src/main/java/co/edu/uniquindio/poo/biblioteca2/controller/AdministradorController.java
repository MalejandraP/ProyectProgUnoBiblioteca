package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;

public class AdministradorController{
    private App app;

    public void regresarPaginaPrincipal() {
        app.openViewPrincipal();
    }

    public void abrirGestion(){
        app.openCrudGestionEmpleado();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
