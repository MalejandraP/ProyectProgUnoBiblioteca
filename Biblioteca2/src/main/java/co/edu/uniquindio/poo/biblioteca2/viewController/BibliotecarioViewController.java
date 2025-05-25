package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.BibliotecarioController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class BibliotecarioViewController {
    private BibliotecarioController bibliotecarioController;
    private App app;

    @FXML
    private Button btnRegresar, btnGestionarUsuario, btnGestionarLibro, btnRealizarPrestamo, btnDevolverLibro, btnUsuariosDeudores, btnLibrosMasSolicitados;

    @FXML
    void onGestionarUsuario(){
        irAGestionUsuario();
    }
    @FXML
    void onGestionarLibro(){
        irAGestionLibro();
    }
    @FXML
    void onRealizarPrestamo(){}
    @FXML
    void onDevolverLibro(){}
    @FXML
    void onUsuariosDeudores(){}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

    public void setBibliotecarioController(BibliotecarioController bibliotecarioController) {
        this.bibliotecarioController = bibliotecarioController;
    }

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }

    @FXML
    private void regresarPrincipal(){
        bibliotecarioController.regresarPaginaPrincipal();
    }
    @FXML
    private void irAGestionLibro(){
        bibliotecarioController.abrirGestionLibro();
    }
    @FXML
    private void irAGestionUsuario(){
        bibliotecarioController.abrirGestionUsuario();
    }
}
