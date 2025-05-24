package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.GestionEmpleadoController;
import co.edu.uniquindio.poo.biblioteca2.model.Cargo;
import co.edu.uniquindio.poo.biblioteca2.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionEmpleadoViewController {
    private GestionEmpleadoController gestionEmpleadoController;
    private App app;
    ObservableList<Empleado> listEmpleados = FXCollections.observableArrayList();
    Empleado selectedEmpleado;

    @FXML
    private Button btnRegresar, btnAgregar, btnEliminar, btnActualizar;
    @FXML
    private TextField txtNombre, txtIdentificacion, txtGenero, txtTelefono, txtCorreo, txtEdad, txtSueldo;
    @FXML
    private ComboBox<Cargo> cbCargo;

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }
    @FXML
    void onAgregar(){}
    @FXML
    void onEliminar(){}
    @FXML
    void onActualizar(){}

    @FXML
    private void regresarPrincipal(){
        gestionEmpleadoController.regresar();
    }

    private void agregarEmpleado() {
        Empleado empleado = buildEmpleado();
        if (gestionEmpleadoController.agregarEmpleado(empleado)) {
            listEmpleados.add(empleado);
        }
    }

    private Empleado buildEmpleado() {
        String nombre = txtNombre.getText();
        String identificacion = txtIdentificacion.getText();
        String genero = txtGenero.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        double sueldo = Double.parseDouble(txtSueldo.getText());
        Cargo cargo = cbCargo.getValue();

        Empleado empleado = new Empleado(nombre, identificacion, genero, correo, telefono, edad, sueldo, cargo);
        return empleado;
    }
    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    public void initialize(){
        cbCargo.getItems().addAll(Cargo.values());
    }

    public void setGestionEmpleadoController(GestionEmpleadoController gestionEmpleadoController) {
        this.gestionEmpleadoController = gestionEmpleadoController;
    }
}
