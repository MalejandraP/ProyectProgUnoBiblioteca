package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;

public class VisitanteController {
    private App app;

    public void regresar(){
        app.openViewPrincipal();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
