package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Visitante;

public class VisitanteController {
    private App app;
    private Visitante visitante;

    public void regresar(){
        app.openViewPrincipal();
    }

    public void setApp(App app) {
        this.app = app;
    }
    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }
}
