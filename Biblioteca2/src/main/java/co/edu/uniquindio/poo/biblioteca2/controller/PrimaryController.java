package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.*;


import static co.edu.uniquindio.poo.biblioteca2.App.biblioteca;

public class PrimaryController {
    private Biblioteca biblioteca;
    private App app;

    public PrimaryController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public void setApp(App app) {
        this.app = app;
    }



    public boolean redireccionarSegunId(String id){
        Empleado empleado = biblioteca.buscarEmpleado(id);
        if(empleado != null){
            Cargo cargo = empleado.getCargo();
            if(cargo == Cargo.ADMINISTRADOR){
                app.openCrudAdministrador();
                return true;
            }
            if(cargo == Cargo.BIBLIOTECARIO){
                app.openCrudBibliotecario();
                return true;
            }
        }
        Usuario usuario = biblioteca.buscarUsuario(id);
        if(usuario != null){
            Tipo tipo = usuario.getTipo();
            if (tipo == Tipo.ESTUDIANTE){
                app.openCrudEstudiante();
                return true;
            }
            if(tipo == Tipo.DOCENTE){
                app.openCrudDocente();
                return true;
            }
            if (tipo == Tipo.VISITANTE){
                app.openCrudVisitante();
                return true;
            }
        }
        return false;
    }

    public boolean redireccionarListaLibros(){
        app.openCrudListaLibros();
        return true;
    }

}
