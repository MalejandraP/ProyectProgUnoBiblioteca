package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;

import java.time.LocalDate;

public class DevolverLibroController {
    private App app;
    private Bibliotecario bibliotecario;
    private Biblioteca biblioteca;

    public void regresarAlBibliotecario(){
        app.openCrudBibliotecario(bibliotecario);
    }
    public Double calcularDeuda(String identificacion, String id, LocalDate fecha){
        return bibliotecario.calcularDeuda(identificacion, id, fecha);
    }

    public DevolverLibroController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
}
