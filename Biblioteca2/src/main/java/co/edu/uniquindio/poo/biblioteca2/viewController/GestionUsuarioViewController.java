package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.GestionUsuarioController;
import co.edu.uniquindio.poo.biblioteca2.model.Tipo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionUsuarioViewController {
    private GestionUsuarioController gestionUsuarioController;
    private App app;

    public void setApp(App app) {
        this.app = app;
    }
    public void setGestionUsuarioController(GestionUsuarioController gestionUsuarioController) {
        this.gestionUsuarioController = gestionUsuarioController;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btnRegresar, btnActualizar, btnAgregar, btnEliminar;

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }
    @FXML
    void onActualizar(){}
    @FXML
    void onAgregar(){}
    @FXML
    void onEliminar(){}

    @FXML
    private void regresarPrincipal(){
        gestionUsuarioController.regresarAlBibliotecario();
    }
    @FXML
    private URL location;

    @FXML
    private ComboBox<Tipo> cbxTipo;

    @FXML
    private Label lblCredencial;

    @FXML
    private TextField txtCredencial, txtNombre, txtIdentificacion, txtGenero, txtEdad, txtCorreo, txtTelefono;

    @FXML
    public void initialize() {
        cbxTipo.getItems().setAll(Tipo.values());
        lblCredencial.setVisible(false);
        txtCredencial.setVisible(false);

        cbxTipo.setOnAction(event -> {
            Tipo seleccionado = cbxTipo.getValue();
            if (seleccionado == Tipo.ESTUDIANTE || seleccionado == Tipo.DOCENTE) {
                lblCredencial.setVisible(true);
                txtCredencial.setVisible(true);
            } else {
                lblCredencial.setVisible(false);
                txtCredencial.setVisible(false);
            }
        });
    }
}
