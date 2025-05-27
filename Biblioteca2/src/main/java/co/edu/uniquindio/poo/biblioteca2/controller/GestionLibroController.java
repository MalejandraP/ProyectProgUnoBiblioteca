package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca2.model.Libro;
import co.edu.uniquindio.poo.biblioteca2.model.Usuario;

import java.util.List;

public class GestionLibroController {
    private App app;
    private Bibliotecario bibliotecario;
    private Biblioteca biblioteca;

    public GestionLibroController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public void regresarAlBibliotecario() {
        app.openCrudBibliotecario(bibliotecario);
    }

    public void regresarABibliotecario() {
        app.openCrudBibliotecario(bibliotecario);
    }
    public boolean agregarLibro(Libro libro){
        bibliotecario.agregarLibro(libro);
        return true;
    }
    public List<Libro> obtenerListaLibros() {
        return biblioteca.getListLibros();
    }

    public boolean eliminarLibro(String titulo) {
        boolean centinela = false;
        if (bibliotecario != null){
            bibliotecario.eliminarLibro(titulo);
            centinela = true;
        }
        return centinela;
    }

    public boolean actualizarLibro(String titulo, Libro actualizado) {
        boolean centinela = false;
        if(bibliotecario != null){
            bibliotecario.actualizarLibro(titulo, actualizado);
            centinela = true;
        }
        return centinela;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
