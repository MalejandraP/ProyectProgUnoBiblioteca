package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca2.model.Empleado;
import co.edu.uniquindio.poo.biblioteca2.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class UsuariosDeudoresController {
    private App app;
    private Bibliotecario bibliotecario;
    private Biblioteca biblioteca;

    public UsuariosDeudoresController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void regresar(){
        app.openCrudBibliotecario(bibliotecario);
    }

    public List<Usuario> obtenerListaEmpleados(LocalDate fecha) {//PASARLE LA FECHA INGRESADA
        return bibliotecario.reporteUsuariosDeudores(fecha);
    }

    public void setApp(App app) {
        this.app = app;
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
}
