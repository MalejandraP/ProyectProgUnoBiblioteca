package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca2.model.Libro;

import java.util.List;

public class ListaLibrosMasSolicitadosController {
    private App app;
    private Bibliotecario bibliotecario;
    private Biblioteca biblioteca;

    public ListaLibrosMasSolicitadosController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public void regresar(){
        app.openCrudBibliotecario(bibliotecario);
    }
    public void setApp(App app) {
        this.app = app;
    }
    public List<Libro> obtenerLibrosSolicitados(){
        return bibliotecario.reporteLibroMasSolicitado();
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
}
