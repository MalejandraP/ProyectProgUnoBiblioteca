package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.LibroDigitalController;
import co.edu.uniquindio.poo.biblioteca2.model.LibroDigital;
import co.edu.uniquindio.poo.biblioteca2.model.LibroFisico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LibroDigitalViewController {
    LibroDigitalController libroDigitalController;

    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    void initialize() {
    }

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblTitulo, lblAutor, lblGenero, lblAnioPubli, lblSolicitudes,lblEstado, lblEnlaceDescarga;

    @FXML
    void onRegresar(){
        libroDigitalController.regresarPaginaPrincipal();
    }

    public void setLibro(LibroDigital libro) {
        lblTitulo.setText(libro.getTitulo());
        lblAutor.setText(libro.getAutor());
        lblGenero.setText(libro.getGenero());
        lblAnioPubli.setText(String.valueOf(libro.getAnioPublicacion()));
        lblSolicitudes.setText(String.valueOf(libro.getSolicitudes()));
        lblEstado.setText(String.valueOf(libro.getEstado()));
        lblEnlaceDescarga.setText(libro.getEnlaceDescarga());
    }



}
