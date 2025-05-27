package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca2.model.Empleado;
import co.edu.uniquindio.poo.biblioteca2.model.Usuario;

import java.util.List;

public class GestionUsuarioController {
    private App app;
    private Bibliotecario bibliotecario;
    private Biblioteca biblioteca;

    public GestionUsuarioController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public void regresarAlBibliotecario() {
        app.openCrudBibliotecario(bibliotecario);
    }
    public boolean agregarUsuario(Usuario usuario){
        bibliotecario.agregarUsuario(usuario);
        return true;
    }
    public List<Usuario> obtenerListaUsuarios() {
        return biblioteca.getListUsuarios();
    }

    public boolean eliminarUsuario(String identificacion) {
        boolean centinela = false;
        if (bibliotecario != null){
            bibliotecario.eliminarUsuario(identificacion);
            centinela = true;
        }
        return centinela;
    }

    public boolean actualizarUsuario(String identificacion, Usuario actualizado) {
        boolean centinela = false;
        if(bibliotecario != null){
            bibliotecario.actualizarUsuario(identificacion, actualizado);
            centinela = true;
        }
        return centinela;
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
