package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.GestionLibroController;
import co.edu.uniquindio.poo.biblioteca2.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GestionLibroViewController {
    private App app;
    private GestionLibroController gestionLibroController;
    ObservableList<Libro> listLibros = FXCollections.observableArrayList();
    Libro selectedLibro;

    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    public void setGestionLibroController(GestionLibroController gestionLibroController) {
        this.gestionLibroController = gestionLibroController;
        obtenerLibros();
    }
    @FXML
    private TableView<Libro> tblGestionLibro;
    @FXML
    private TableColumn<Libro, String> tbcTitulo, tbcAutor, tbcGenero, tbcAnioPubli;
    @FXML
    private TableColumn<Libro, EstadoLibro> tbcEstado;
    @FXML
    private TableColumn<Libro, Boolean> tbcEsFisico;
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
    void onAgregar(){
        agregarLibro();
    }
    @FXML
    void onActualizar(){
        if (selectedLibro != null) {
            try {
                Libro nuevoLibro = buildLibro();
                if (nuevoLibro == null) {
                    mostrarAlerta("Error", "Por favor completa todos los campos.");
                    return;
                }
                boolean actualizado = gestionLibroController.actualizarLibro(selectedLibro.getTitulo(), nuevoLibro);
                if (actualizado) {
                    int index = listLibros.indexOf(selectedLibro);
                    listLibros.set(index, nuevoLibro);
                    limpiarCamposLibros();
                    mostrarAlerta("Éxito", "Libro actualizado correctamente.");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar el libro.");
                }
            } catch (Exception e) {
                mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Atención", "Selecciona un libro para actualizar.");
        }
    }
    @FXML
    void onEliminar(){
        if (selectedLibro != null) {
            boolean eliminado = gestionLibroController.eliminarLibro(selectedLibro.getTitulo());

            if (eliminado) {
                listLibros.remove(selectedLibro);
                limpiarCamposLibros();
                mostrarAlerta("Éxito", "Libro eliminado correctamente.");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar el libro.");
            }
        } else {
            mostrarAlerta("Atención", "Selecciona un libro para eliminar.");
        }
    }

    @FXML
    public void regresarABibliotecario(){
        gestionLibroController.regresarABibliotecario();
    }
    private void agregarLibro() {
        try {
            Libro libro = buildLibro();
            if (libro == null) {
                mostrarAlerta("Error", "Por favor completa todos los campos.");
                return;
            }
            if (gestionLibroController.agregarLibro(libro)) {
                listLibros.add(libro);
                limpiarCamposLibros();
            } else {
                mostrarAlerta("Error", "No se pudo agregar el libro.");
            }
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    @FXML
    public void initialize() {
        mostrarCampos(false);
        listenerSelection();

        chbEsFisico.setOnAction(event -> {
            if (chbEsFisico.isSelected()) {
                mostrarCamposFisico();
            } else {
                mostrarCamposDigital();
            }
        });
        tbcTitulo.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTitulo()));
        tbcAutor.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAutor()));
        tbcGenero.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getGenero()));
        tbcAnioPubli.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAnioPublicacion()));
        tbcEsFisico.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().isEsFisico()));
        tbcEstado.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getEstado()));

        cbxEstado.getItems().setAll(EstadoLibro.values());

    }
    public Libro buildLibro() {
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String genero = txtGenero.getText().trim();
        String anioPublicacion = txtAnioPublicacion.getText().trim();
        boolean esFisico = chbEsFisico.isSelected();
        EstadoLibro estado = cbxEstado.getValue();

        Libro libro;
        if(esFisico){
            String editorial = txtEditorial.getText().trim();
            String ubicacion = txtUbicacion.getText().trim();
            int cantPaginas = Integer.parseInt(txtCantPaginas.getText().trim());
            libro = new LibroFisico(titulo, autor, genero, anioPublicacion, esFisico, estado, editorial, ubicacion, cantPaginas);
            return libro;
        }
        else if(!esFisico){
            String enlaceDescarga = txtEnlaceDescarga.getText().trim();
            libro = new LibroDigital(autor, titulo, genero, anioPublicacion, esFisico, estado, enlaceDescarga);
            return libro;
        }
        else{
            return null;
        }
    }
    public void obtenerLibros() {
        List<Libro> libros = gestionLibroController.obtenerListaLibros();
        listLibros.setAll(libros);
        tblGestionLibro.setItems(listLibros);
    }
    private void listenerSelection() {
        tblGestionLibro.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedLibro = newSelection;
            mostrarInformacionLibro(selectedLibro);
        });
    }
    private void mostrarInformacionLibro(Libro libro) {
        if (libro != null) {
            txtTitulo.setText(libro.getTitulo());
            txtAutor.setText(libro.getAutor());
            txtGenero.setText(libro.getGenero());
            txtAnioPublicacion.setText(libro.getAnioPublicacion());
            chbEsFisico.setSelected(libro.isEsFisico());
            cbxEstado.setValue(libro.getEstado());
            if (libro.isEsFisico()) {
                mostrarCamposFisico();
                if(libro instanceof LibroFisico ){
                    LibroFisico libroFisico = (LibroFisico) libro;
                    txtEditorial.setText(libroFisico.getEditorial());
                    txtUbicacion.setText(libroFisico.getUbicacionBiblioteca());
                    txtCantPaginas.setText(String.valueOf(libroFisico.getNumeroPaginas()));
                }
            }
            if (!libro.isEsFisico()) {
                mostrarCamposDigital();
                if(libro instanceof LibroDigital ){
                    LibroDigital libroDigital = (LibroDigital) libro;
                    txtEnlaceDescarga.setText(libroDigital.getEnlaceDescarga());
                }
            }
        }
    }
    private void limpiarCamposLibros() {
        txtTitulo.clear();
        txtAutor.clear();
        txtGenero.clear();
        txtAnioPublicacion.clear();
        chbEsFisico.setSelected(false);
        cbxEstado.setValue(EstadoLibro.DISPONIBLE);
        mostrarCampos(false);
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
