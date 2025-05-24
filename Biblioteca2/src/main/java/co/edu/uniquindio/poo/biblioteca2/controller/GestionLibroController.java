package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;

public class GestionLibroController {
    private App app;

    public void regresarAlBibliotecario() {
        app.openCrudBibliotecario();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
