package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;

public class BibliotecarioController {
    private App app;
    private Bibliotecario bibliotecario;

    public void regresarPaginaPrincipal() {
        app.openViewPrincipal();
    }
    public void abrirGestionLibro(){
        app.openCrudGestionLibro();
    }
    public void abrirGestionUsuario(){
        app.openCrudGestionUsuario();
    }
    public void setBibliotecario(Bibliotecario bibliotecario){
        this.bibliotecario = bibliotecario;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
