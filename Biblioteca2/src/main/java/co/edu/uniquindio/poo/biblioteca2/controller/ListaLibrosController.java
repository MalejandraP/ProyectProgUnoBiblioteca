package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Libro;
import co.edu.uniquindio.poo.biblioteca2.model.LibroDigital;
import co.edu.uniquindio.poo.biblioteca2.model.LibroFisico;

import static co.edu.uniquindio.poo.biblioteca2.App.biblioteca;

public class ListaLibrosController {
    private App app;

    public boolean visualizarLibro(Libro libro){
        if(biblioteca.verificarLibro(libro.getTitulo())){
            if (biblioteca.buscarLibro(libro.getTitulo()) instanceof LibroFisico){
                app.openCrudLibroFisico((LibroFisico) libro);
                return true;
            }
            if (biblioteca.buscarLibro(libro.getTitulo()) instanceof LibroDigital){
                app.openCrudLibroDigital((LibroDigital) libro);
                return true;
            }
        }
        return false;
    }

    public void regresar(){
        app.openViewPrincipal();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
