package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.DevolverLibroController;
import co.edu.uniquindio.poo.biblioteca2.model.Bibliotecario;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class DevolverLibroViewController {
    private App app;
    private Bibliotecario bibliotecario;
    private DevolverLibroController devolverLibroController;

    @FXML
    private Button btnRegresar, btnCargar, btnPagar, btnDevolver;
    @FXML
    private TextField txtIdUsuario, txtIdPrestamo;
    @FXML
    private Label lblDeudaCambio;
    @FXML
    private DatePicker dpFecha;

    @FXML
    void onRegresar(){
        regresar();
    }
    @FXML
    void onCargar(){
        cargarDeuda();
    }
    @FXML
    void onPagar(){}
    @FXML
    void onDevolver(){}
    public void regresar(){
        devolverLibroController.regresarAlBibliotecario();
    }
    public void cargarDeuda(){
        String idUsuario = txtIdUsuario.getText();
        String idPrestamo = txtIdPrestamo.getText();
        LocalDate fecha = dpFecha.getValue();
        Double deuda = devolverLibroController.calcularDeuda(idUsuario, idPrestamo, fecha);
        if(deuda != null){
            lblDeudaCambio.setText(deuda.toString());
        } else {
            mostrarAlerta("Error", "No se pudo calcular la deuda ,Verifique los datos. El usuario podría tener deuda o no puede prestar.");;
        }
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }


    public void setApp(App app) {
        this.app = app;
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public void setDevolverLibroController(DevolverLibroController devolverLibroController) {
        this.devolverLibroController = devolverLibroController;
    }
}
