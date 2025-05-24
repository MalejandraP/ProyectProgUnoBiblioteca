package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.EstudianteController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class EstudianteViewController {
    private App app;
    private EstudianteController estudianteController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegresar, btnCalcularDeuda, btnVisualizarLibros;

    public void setEstudianteController(EstudianteController estudianteController) {
        this.estudianteController = estudianteController;
    }
    @FXML
    void onCalcularDeudaTotal(){

    }
    @FXML
    void onVisualizarListaLibros(){

    }


    @FXML
    void onRegresar(){
       regresarPrincipal();
    }

    @FXML
    private void regresarPrincipal(){
        estudianteController.regresarPaginaPrincipal();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
