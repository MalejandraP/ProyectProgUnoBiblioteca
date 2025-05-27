package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.ListaLibrosMasSolicitadosController;
import co.edu.uniquindio.poo.biblioteca2.model.EstadoLibro;
import co.edu.uniquindio.poo.biblioteca2.model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaLibrosMasSolicitadosViewController {
    private App app;
    private ListaLibrosMasSolicitadosController listaController;

    @FXML
    private Button btnRegresar;
    @FXML
    void onRegresar(){
        regresarPaginaPrincipal();
    }
    @FXML
    private TableView<Libro> tbvListaLibrosMasSolicitados;
    @FXML
    private TableColumn<Libro, String> tbcTitulo, tbcAutor, tbcGenero;
    @FXML
    private TableColumn<Libro, EstadoLibro> tbcEstado;

    public void regresarPaginaPrincipal() {
        listaController.regresar();
    }
    public void setApp(App app) {
        this.app = app;
    }
    public void setListaController(ListaLibrosMasSolicitadosController listaController) {
        this.listaController = listaController;
    }
}
