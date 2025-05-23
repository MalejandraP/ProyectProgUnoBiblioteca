package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.LibroFisicoController;
import co.edu.uniquindio.poo.biblioteca2.model.Libro;
import co.edu.uniquindio.poo.biblioteca2.model.LibroFisico;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LibroFisicoViewController {
    LibroFisicoController libroFisicoController;

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
    private Label lblTituloCambio, lblAutorCambio, lblGeneroCambio, lblAnioPubliCambio, lblSolicitudesCambio, lblEstadoCambio, lblUbicacionCambio, lblEditorialCambio, lblNumPaginasCambio;

    public void setLibro(LibroFisico libro){
        lblTituloCambio.setText(libro.getTitulo());
        lblAutorCambio.setText(libro.getAutor());
        lblGeneroCambio.setText(libro.getGenero());
        lblAnioPubliCambio.setText(String.valueOf(libro.getAnioPublicacion()));
        lblSolicitudesCambio.setText(String.valueOf(libro.getSolicitudes()));
        lblEstadoCambio.setText(String.valueOf(libro.getEstado()));
        lblUbicacionCambio.setText(libro.getUbicacionBiblioteca());
        lblEditorialCambio.setText(libro.getEditorial());
        lblNumPaginasCambio.setText(String.valueOf(libro.getNumeroPaginas()));


    }
    @FXML
    void onRegresar(){
        libroFisicoController.regresarPaginaPrincipal();
    }

    public void setLibroFisicoController(LibroFisicoController libroFisicoController) {
        this.libroFisicoController = libroFisicoController;
    }
}
