package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.AdministradorController;
import co.edu.uniquindio.poo.biblioteca2.model.Administrador;
import co.edu.uniquindio.poo.biblioteca2.model.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministradorViewController {
    private App app;
    private AdministradorController administradorController;
    private Administrador administrador;

    public void setAdministradorController(AdministradorController administradorController) {
        this.administradorController = administradorController;
    }
    @FXML
    private Label lblNombreCambio;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private Button btnRegresar, btnGestionarEmpleado, btnCantidadEmpleadosEliminados, btnPorcentajeSinDeuda;

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        lblNombreCambio.setText(administrador.getNombre());
    }
    @FXML
    void onGestionarEmpleado(){
        abrirGestionEmpleado();
    }
    @FXML
    void onPorcentajeSinDeuda(){
        abrirPorcentaje();
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
    @FXML
    private void abrirPorcentaje(){
        administradorController.mostrarPorcentajeSinDeuda();
    }


}
