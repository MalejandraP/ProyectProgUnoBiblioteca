package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class VisitanteViewController {

    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }
}
