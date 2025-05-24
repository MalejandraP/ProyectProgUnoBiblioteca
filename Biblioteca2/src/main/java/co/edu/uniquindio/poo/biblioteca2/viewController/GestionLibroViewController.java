package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.GestionLibroController;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionLibroViewController {
    private App app;
    private GestionLibroController gestionLibroController;

    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    public void setGestionLibroController(GestionLibroController gestionLibroController) {
        this.gestionLibroController = gestionLibroController;
    }
}
