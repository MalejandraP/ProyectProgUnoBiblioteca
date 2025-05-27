package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.DocenteController;
import co.edu.uniquindio.poo.biblioteca2.model.Docente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DocenteViewController {
    private App app;
    private DocenteController docenteController;
    private Docente docente;

    @FXML
    private Button btnRegresar, btnVerLibros, btnCalcularDeudaTotal;
    @FXML
    private Label lblNombreCambio;

    @FXML
    void onVerListaLibros(){}

    @FXML
    void onCalcularDeudaTotal(){}

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }

    public void setDocenteController(DocenteController docenteController) {
        this.docenteController = docenteController;
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private void regresarPrincipal(){
        docenteController.regresarPaginaPrincipal();
    }
    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }
    public void setDocente(Docente docente) {
        this.docente = docente;
        lblNombreCambio.setText(docente.getNombre());
    }

}
