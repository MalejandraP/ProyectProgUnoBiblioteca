package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.Estudiante;

public class EstudianteController {
    private App app;
    private Estudiante estudiante;

    public void regresarPaginaPrincipal() {
        app.openViewPrincipal();
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
