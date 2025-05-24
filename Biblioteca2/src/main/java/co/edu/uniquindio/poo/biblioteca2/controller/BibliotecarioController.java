package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;

public class BibliotecarioController {
    private App app;

    public void regresarPaginaPrincipal() {
        app.openViewPrincipal();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
