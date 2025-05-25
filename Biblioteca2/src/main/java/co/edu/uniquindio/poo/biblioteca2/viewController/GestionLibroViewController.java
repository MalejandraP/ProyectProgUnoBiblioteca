package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.GestionLibroController;
import co.edu.uniquindio.poo.biblioteca2.model.EstadoLibro;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    @FXML
    private Button btnRegresar, btnActualizar, btnEliminar, btnAgregar;
    @FXML
    private TextField txtTitulo, txtAutor, txtGenero, txtAnioPublicacion, txtCantPaginas, txtEditorial, txtEnlaceDescarga, txtUbicacion;
    @FXML
    private ComboBox<EstadoLibro> cbxEstado;
    @FXML
    private CheckBox chbEsFisico;
    @FXML
    private Label lblEditorial, lblCantPaginas, lblEnlaceDescarga, lblUbicacion;

    @FXML
    void onRegresar(){
        regresarABibliotecario();
    }
    @FXML
    void onActualizar(){}
    @FXML
    void onEliminar(){}
    @FXML
    void onAgregar(){}

    @FXML
    public void regresarABibliotecario(){
        gestionLibroController.regresarAlBibliotecario();
    }

    @FXML
    public void initialize() {
        // Ocultar todos al inicio
        mostrarCampos(false);

        // Añadir listener al checkbox
        chbEsFisico.setOnAction(event -> {
            if (chbEsFisico.isSelected()) {
                // Mostrar campos de libro físico
                mostrarCamposFisico();
            } else {
                // Mostrar campos de libro digital
                mostrarCamposDigital();
            }
        });
    }

    private void mostrarCamposFisico() {
        lblEditorial.setVisible(true);
        lblCantPaginas.setVisible(true);
        lblUbicacion.setVisible(true);
        txtEditorial.setVisible(true);
        txtCantPaginas.setVisible(true);
        txtUbicacion.setVisible(true);

        lblEnlaceDescarga.setVisible(false);
        txtEnlaceDescarga.setVisible(false);
    }

    private void mostrarCamposDigital() {
        lblEditorial.setVisible(false);
        lblCantPaginas.setVisible(false);
        lblUbicacion.setVisible(false);
        txtEditorial.setVisible(false);
        txtCantPaginas.setVisible(false);
        txtUbicacion.setVisible(false);

        lblEnlaceDescarga.setVisible(true);
        txtEnlaceDescarga.setVisible(true);
    }

    private void mostrarCampos(boolean visible) {
        lblEditorial.setVisible(visible);
        lblCantPaginas.setVisible(visible);
        lblUbicacion.setVisible(visible);
        txtEditorial.setVisible(visible);
        txtCantPaginas.setVisible(visible);
        txtUbicacion.setVisible(visible);
        lblEnlaceDescarga.setVisible(visible);
        txtEnlaceDescarga.setVisible(visible);
    }
}
