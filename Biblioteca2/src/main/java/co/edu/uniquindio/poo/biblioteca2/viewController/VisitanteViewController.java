package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.VisitanteController;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class VisitanteViewController {
    private VisitanteController visitanteController;
    private App app;

    public void setVisitanteController(VisitanteController visitanteController) {
        this.visitanteController = visitanteController;
    }

    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }
}
