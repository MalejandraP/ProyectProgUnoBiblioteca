package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.VisitanteController;
import co.edu.uniquindio.poo.biblioteca2.model.Visitante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class VisitanteViewController {
    private VisitanteController visitanteController;
    private App app;
    private Visitante visitante;

    public void setVisitanteController(VisitanteController visitanteController) {
        this.visitanteController = visitanteController;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btnRegresar;
    @FXML
    private Label lblNombreCambio;

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }

    @FXML
    private void regresarPrincipal(){
        visitanteController.regresar();
    }
    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }
    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
        lblNombreCambio.setText(visitante.getNombre());
    }
}
