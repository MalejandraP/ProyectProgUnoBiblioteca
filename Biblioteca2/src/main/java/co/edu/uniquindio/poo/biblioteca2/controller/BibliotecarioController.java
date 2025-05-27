package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;

public class BibliotecarioController {
    private App app;
    private Bibliotecario bibliotecario;
    private Biblioteca biblioteca ;


    public void regresarPaginaPrincipal() {
        app.openViewPrincipal();
    }
    public void abrirGestionLibro(){
        app.openCrudGestionLibro(bibliotecario);
    }
    public void abrirGestionUsuario(){
        app.openCrudGestionUsuario(bibliotecario);
    }
    public void abrirRealizarPrestamo(){
        app.openCrudRealizarPrestamo(bibliotecario);
    }
    public void abrirDevolucion(){
        app.openCrudDevolverLibro(bibliotecario);
    }
    public void abrirReporteLibros(){
        app.openCrudLibrosMasSolicitados(bibliotecario);
    }
    public void abrirReporteUsuarios(){
        app.openCrudListaUsuariosDeudores(bibliotecario);
    }
    public void setBibliotecario(Bibliotecario bibliotecario){
        this.bibliotecario = bibliotecario;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
