package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;

public class GestionUsuarioController {
    private App app;
    private Bibliotecario bibliotecario;

    public void regresarAlBibliotecario() {
        app.openCrudBibliotecario(bibliotecario);
    }
    public void setApp(App app) {
        this.app = app;
    }
}
