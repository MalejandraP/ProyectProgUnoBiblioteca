package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.DocenteController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DocenteViewController {
    private App app;
    private DocenteController docenteController;

    @FXML
    private Button btnRegresar, btnVerLibros, btnCalcularDeudaTotal;

    @FXML
    void onVerListaLibros(){}

    @FXML
    void onCalcularDeudaTotal(){}

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }

    public void setDocenteController(DocenteController docenteController) {
        this.docenteController = docenteController;
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private void regresarPrincipal(){
        docenteController.regresarPaginaPrincipal();
    }
    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

}
