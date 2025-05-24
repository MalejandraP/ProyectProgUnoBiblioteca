package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.AdministradorController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministradorViewController {
    private App app;
    private AdministradorController administradorController;

    public void setAdministradorController(AdministradorController administradorController) {
        this.administradorController = administradorController;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private Button btnRegresar, btnGestionarEmpleado, btnCantidadEmpleadosEliminados;

    @FXML
    void onGestionarEmpleado(){
        abrirGestionEmpleado();
    }
    @FXML
    void onCantidadEmpleadosEliminados(){}

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }

    @FXML
    private void regresarPrincipal(){
        administradorController.regresarPaginaPrincipal();
    }
    @FXML
    private void abrirGestionEmpleado(){
        administradorController.abrirGestion();
    }


}
