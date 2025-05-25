package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Docente;

public class DocenteController {

    private App app;
    private Docente docente;

    public void regresarPaginaPrincipal() {
        app.openViewPrincipal();
    }
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
