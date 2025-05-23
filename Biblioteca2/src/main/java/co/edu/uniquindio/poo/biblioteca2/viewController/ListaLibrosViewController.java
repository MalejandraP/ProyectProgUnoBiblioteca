package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.ListaLibrosController;
import co.edu.uniquindio.poo.biblioteca2.model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;


public class ListaLibrosViewController {
    private ListaLibrosController listaLibrosController;

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

    }
}
