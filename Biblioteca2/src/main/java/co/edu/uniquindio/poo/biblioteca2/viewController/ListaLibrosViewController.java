package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.ListaLibrosController;
import co.edu.uniquindio.poo.biblioteca2.model.EstadoLibro;
import co.edu.uniquindio.poo.biblioteca2.model.Libro;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import static co.edu.uniquindio.poo.biblioteca2.App.biblioteca;


public class ListaLibrosViewController {
    private ListaLibrosController listaLibrosController;
    private ObservableList<Libro> listLibros = FXCollections.observableArrayList();

    public void setListaLibrosController(ListaLibrosController listaLibrosController) {
        this.listaLibrosController = listaLibrosController;
    }

    @FXML
    private ResourceBundle resources;

    App app;
    @FXML
    private URL location;

    @FXML
    private Button btnVerInfo, btnRegresar;
    @FXML
    private TableView tbvTablaListaLibros;
    @FXML
    private TableColumn<Libro, String> tbcTitulo, tbcAutor, tbcGenero, tbcAnioPublicacion;
    @FXML
    private TableColumn<Libro, EstadoLibro> tbcEstado;

    @FXML
    void onVerInfo(){
        verInformacion();
    }
    @FXML
    void onRegresar(){
        regresarPrincipal();
    }

    @FXML
    private void verInformacion(){
        Libro libroSeleccionado = (Libro) tbvTablaListaLibros.getSelectionModel().getSelectedItem();
        if (libroSeleccionado != null) {
            boolean redireccionar = listaLibrosController.visualizarLibro(libroSeleccionado);
        }
        else {
            System.out.println("No hay ningun libro seleccionado");
        }


    }

    @FXML
    private void regresarPrincipal(){
        listaLibrosController.regresar();
    }

    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    void initialize() {
        tbcTitulo.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTitulo()));

        tbcAutor.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAutor()));

        tbcGenero.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getGenero()));

        tbcAnioPublicacion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAnioPublicacion()));

        tbcEstado.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getEstado()));

        listLibros.addAll(biblioteca.getListLibros());

        tbvTablaListaLibros.setItems(FXCollections.observableArrayList(listLibros));

    }


}
