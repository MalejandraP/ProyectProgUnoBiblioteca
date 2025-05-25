package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Administrador;
import co.edu.uniquindio.poo.biblioteca2.model.Biblioteca;

import java.time.LocalDate;

public class AdministradorController{
    private App app;
    private Administrador administrador;
    private Biblioteca biblioteca;

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public void regresarPaginaPrincipal() {
        app.openViewPrincipal();
    }

    public void abrirGestion(){
        app.openCrudGestionEmpleado(administrador);
    }
    public void mostrarPorcentajeSinDeuda(){
        app.openCrudReportePorcentajeSinDeuda();// ES NULO, HAY QUE HACER QUE DEJE DE SER NULO
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }


    public void inicializarAdministrador(Administrador administrador) {//EXPLICAR ESTO
        this.administrador = administrador;

        administrador.setListUsuarios(biblioteca.getListUsuarios());

        if (!biblioteca.getListBibliotecarios().isEmpty()) {
            administrador.setBibliotecario(biblioteca.getListBibliotecarios().get(0));
        }
    }
}
