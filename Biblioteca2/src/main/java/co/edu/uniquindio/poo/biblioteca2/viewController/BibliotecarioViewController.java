package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.BibliotecarioController;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BibliotecarioViewController {
    private BibliotecarioController bibliotecarioController;
    private App app;
    private Bibliotecario bibliotecario;

    @FXML
    private Button btnRegresar, btnGestionarUsuario, btnGestionarLibro, btnRealizarPrestamo, btnDevolverLibro, btnUsuariosDeudores, btnLibrosMasSolicitados;
    @FXML
    private Label lblNombreCambio;

    @FXML
    void onGestionarUsuario(){
        irAGestionUsuario();
    }
    @FXML
    void onGestionarLibro(){
        irAGestionLibro();
    }
    @FXML
    void onRealizarPrestamo(){
        irARealizarPrestamo();
    }
    @FXML
    void onDevolverLibro(){
        irADevolucion();
    }
    @FXML
    void onUsuariosDeudores(){
        irAlReporteUsuarios();
    }
    @FXML
    void onLibrosSolicitados(){
        irAlReporteLibros();
    }
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
    @FXML
    private void irARealizarPrestamo(){
        bibliotecarioController.abrirRealizarPrestamo();
    }
    @FXML
    private void irADevolucion(){
        bibliotecarioController.abrirDevolucion();
    }
    @FXML
    private void irAlReporteLibros(){
        bibliotecarioController.abrirReporteLibros();
    }
    @FXML
    private void irAlReporteUsuarios(){
        bibliotecarioController.abrirReporteUsuarios();
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
        lblNombreCambio.setText(bibliotecario.getNombre());
    }
}
