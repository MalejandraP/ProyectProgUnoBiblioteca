package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.RealizarPrestamoController;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;
import co.edu.uniquindio.poo.biblioteca2.model.Libro;
import co.edu.uniquindio.poo.biblioteca2.model.Prestamo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RealizarPrestamoViewController {
    private App app;
    private RealizarPrestamoController realizarPrestamoController;
    private Bibliotecario bibliotecario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btnRegresar, btnCargar;
    @FXML
    private Label lblFechaCambio;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private TextField txtIdPrestamo, txtIdUsuario;
    @FXML
    private ComboBox<Libro> chbTituloLibro;

    @FXML
    public void initialize() {

    }

    private void cargarLibros() {
        chbTituloLibro.getItems().clear();
        chbTituloLibro.getItems().addAll(realizarPrestamoController.obtenerLibrosDisponibles());

        chbTituloLibro.setConverter(new StringConverter<Libro>() {
            @Override
            public String toString(Libro libro) {
                return libro != null ? libro.getTitulo() : "";
            }

            @Override
            public Libro fromString(String string) {
                return null;
            }
        });
    }
    @FXML
    void onRegistrar(){
        registrar();
    }
    @FXML
    void onCargar(){
        cargarFechaMax();
    }
    @FXML
    void onRegresar(){
        regresarPrincipal();
    }

    @FXML
    private void regresarPrincipal(){
        realizarPrestamoController.regresar();
    }
    @FXML
    private void registrar() {
        String idPrestamo = txtIdPrestamo.getText();
        String idUsuario = txtIdUsuario.getText();
        LocalDate fecha = dpFecha.getValue();
        Libro libroSeleccionado = chbTituloLibro.getValue();
        if (libroSeleccionado == null) {
            System.out.println("Ningún libro seleccionado.");
            return;
        }
        String titulo = libroSeleccionado.getTitulo();
        Prestamo nuevo = realizarPrestamoController.registroPrestamo(titulo, idUsuario, fecha, idPrestamo);

    }
    @FXML
    private void cargarFechaMax() {
        String idPrestamo = txtIdPrestamo.getText();
        String idUsuario = txtIdUsuario.getText();
        LocalDate fecha = dpFecha.getValue();
        Libro libroSeleccionado = chbTituloLibro.getValue();

        if (libroSeleccionado == null || fecha == null || idPrestamo.isEmpty() || idUsuario.isEmpty()) {
            mostrarAlerta("Error", "Datos incompletos ,Por favor complete todos los campos.");
            return;
        }

        String titulo = libroSeleccionado.getTitulo();
        LocalDate fechaMax = realizarPrestamoController.obtenerFechaMax(titulo, idUsuario, fecha, idPrestamo);

        if (fechaMax != null) {
            lblFechaCambio.setText(fechaMax.toString());
        } else {
            mostrarAlerta("Error", "No se pudo calcular la fecha máxima ,Verifique los datos. El usuario podría tener deuda o no puede prestar.");
        }
    }


    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }


    @FXML
    private URL location;

    public void setRealizarPrestamoController(RealizarPrestamoController realizarPrestamoController) {
        this.realizarPrestamoController = realizarPrestamoController;
        cargarLibros();

    }

    public void setApp(App app) {
        this.app = app;
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
}
