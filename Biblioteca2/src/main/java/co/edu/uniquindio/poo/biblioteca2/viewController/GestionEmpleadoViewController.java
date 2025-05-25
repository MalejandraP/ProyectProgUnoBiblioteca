package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.GestionEmpleadoController;
import co.edu.uniquindio.poo.biblioteca2.model.Cargo;
import co.edu.uniquindio.poo.biblioteca2.model.Empleado;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GestionEmpleadoViewController {
    private GestionEmpleadoController gestionEmpleadoController;
    private App app;
    ObservableList<Empleado> listEmpleados = FXCollections.observableArrayList();
    Empleado selectedEmpleado;

    @FXML
    private TableView<Empleado> tbvGestionEmpleados;
    @FXML
    private Button btnRegresar, btnAgregar, btnEliminar, btnActualizar;
    @FXML
    private TextField txtNombre, txtIdentificacion, txtGenero, txtTelefono, txtCorreo, txtEdad, txtSueldo;
    @FXML
    private ComboBox<Cargo> cbCargo;
    @FXML
    private TableColumn<Empleado, String> tbcNombre, tbcId, tbcGenero, tbcCorreo, tbcTelefono;
    @FXML
    private TableColumn<Empleado, Integer> tbcEdad;
    @FXML
    private TableColumn<Empleado, Double> tbcSueldo;
    @FXML
    private TableColumn<Empleado, Cargo>  tbcCargo;

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }
    @FXML
    void onAgregar(){
        agregarEmpleado();
    }
    @FXML
    void onEliminar() {
        if (selectedEmpleado != null) {
            boolean eliminado = gestionEmpleadoController.eliminarEmpleado(selectedEmpleado.getIdentificacion());

            if (eliminado) {
                listEmpleados.remove(selectedEmpleado);
                limpiarCamposEmpleados();
                mostrarAlerta("Éxito", "Empleado eliminado correctamente.");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar el empleado.");
            }
        } else {
            mostrarAlerta("Atención", "Selecciona un empleado para eliminar.");
        }
    }

    @FXML
    void onActualizar() {
        if (selectedEmpleado != null) {
            try {
                Empleado nuevoEmpleado = buildEmpleado();
                if (nuevoEmpleado == null) {
                    mostrarAlerta("Error", "Por favor completa todos los campos.");
                    return;
                }
                boolean actualizado = gestionEmpleadoController.actualizarEmpleado(selectedEmpleado.getIdentificacion(), nuevoEmpleado);
                if (actualizado) {
                    int index = listEmpleados.indexOf(selectedEmpleado);
                    listEmpleados.set(index, nuevoEmpleado);
                    limpiarCamposEmpleados();
                    mostrarAlerta("Éxito", "Empleado actualizado correctamente.");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar el empleado.");
                }
            } catch (Exception e) {
                mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Atención", "Selecciona un empleado para actualizar.");
        }
    }


    @FXML
    private void regresarPrincipal(){
        gestionEmpleadoController.regresar();
    }

    private void agregarEmpleado() {
        try {
            Empleado empleado = buildEmpleado();

            if (empleado == null) {
                mostrarAlerta("Error", "Por favor completa todos los campos.");
                return;
            }

            if (gestionEmpleadoController.agregarEmpleado(empleado)) {
                listEmpleados.add(empleado); // se agrega a la lista visible en la tabla
                limpiarCamposEmpleados();
            } else {
                mostrarAlerta("Error", "No se pudo agregar el empleado.");
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
        tbcNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));

        tbcId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getIdentificacion()));

        tbcGenero.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getGenero()));

        tbcCorreo.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCorreo()));

        tbcTelefono.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefono()));

        tbcEdad.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getEdad()));

        tbcSueldo.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getSueldo()));

        tbcCargo.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getCargo()));

        cbCargo.getItems().addAll(Cargo.values());


        // Escuchar selección
        listenerSelection();


    }



    public void setGestionEmpleadoController(GestionEmpleadoController controller) {
        this.gestionEmpleadoController = controller;
        obtenerEmpleados();
    }

    public void obtenerEmpleados() {
        List<Empleado> empleados = gestionEmpleadoController.obtenerListaEmpleados();
        listEmpleados.setAll(empleados); // llena la ObservableList con los datos reales
        tbvGestionEmpleados.setItems(listEmpleados); // usa esa lista en la tabla
    }

    private void listenerSelection() {
        tbvGestionEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEmpleado = newSelection;
            mostrarInformacionCliente(selectedEmpleado);
        });
    }

    private void mostrarInformacionCliente(Empleado empleado) {
        if (empleado != null) {
            txtIdentificacion.setText(empleado.getIdentificacion());
            txtNombre.setText(empleado.getNombre());
            txtGenero.setText(empleado.getGenero());
            txtCorreo.setText(empleado.getCorreo());
            txtTelefono.setText(empleado.getTelefono());
            txtEdad.setText(String.valueOf(empleado.getEdad()));
            txtSueldo.setText(String.valueOf(empleado.getSueldo()));
            cbCargo.setValue(empleado.getCargo());
        }
    }


    private void initDataBinding() {

    }

    private void limpiarCamposEmpleados() {
        txtIdentificacion.clear();
        txtNombre.clear();
        txtGenero.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtEdad.clear();
        txtSueldo.clear();
        cbCargo.setValue(null);
    }
}
