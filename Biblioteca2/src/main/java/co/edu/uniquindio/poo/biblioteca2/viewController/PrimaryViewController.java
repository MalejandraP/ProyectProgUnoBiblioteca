package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.PrimaryController;
import co.edu.uniquindio.poo.biblioteca2.model.Cargo;
import co.edu.uniquindio.poo.biblioteca2.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static co.edu.uniquindio.poo.biblioteca2.App.biblioteca;

public class PrimaryViewController {
    PrimaryController primaryController;

    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    @FXML
    private Button btnVisualizarListaDeLibros,btnIngresarId;

    @FXML
    private TextField txtIngresarId;

    @FXML
    void onIngresarId (){
        String id = txtIngresarId.getText();
        boolean redireccionado = primaryController.redireccionarSegunId(id);
    }


    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    void initialize() {

    }
}
