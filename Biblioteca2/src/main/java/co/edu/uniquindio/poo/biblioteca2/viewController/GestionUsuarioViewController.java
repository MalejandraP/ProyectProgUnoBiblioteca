package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.GestionUsuarioController;
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

public class GestionUsuarioViewController {
    private GestionUsuarioController gestionUsuarioController;
    private App app;
    ObservableList<Usuario> listUsuarios = FXCollections.observableArrayList();
    Usuario selectedUsuario;

    @FXML
    private Button btnRegresar, btnActualizar, btnAgregar, btnEliminar;
    @FXML
    private ComboBox<Tipo> cbxTipo;
    @FXML
    private Label lblCredencial;
    @FXML
    private TextField txtCredencial, txtNombre, txtIdentificacion, txtGenero, txtEdad, txtCorreo, txtTelefono;
    @FXML
    private TableView<Usuario> tbvUsuarios;
    @FXML
    private TableColumn<Usuario, String> tbcNombre, tbcId, tbcGenero, tbcCorreo, tbcTelefono;
    @FXML
    private TableColumn<Usuario, Integer> tbcEdad;
    @FXML
    private TableColumn<Usuario, Tipo> tbcTipo;

    @FXML
    void onRegresar(){
        regresarPrincipal();
    }
    @FXML
    void onAgregar(){
        agregarUsuario();
    }
    @FXML
    void onActualizar(){
        if (selectedUsuario != null) {
            try {
                Usuario nuevoUsuario = buildUsuario();
                if (nuevoUsuario == null) {
                    mostrarAlerta("Error", "Por favor completa todos los campos.");
                    return;
                }
                boolean actualizado = gestionUsuarioController.actualizarUsuario(selectedUsuario.getIdentificacion(), nuevoUsuario);
                if (actualizado) {
                    int index = listUsuarios.indexOf(selectedUsuario);
                    listUsuarios.set(index, nuevoUsuario);
                    limpiarCamposUsuarios();
                    mostrarAlerta("Éxito", "Usuario actualizado correctamente.");
                } else {
                    mostrarAlerta("Error", "No se pudo actualizar el usuario.");
                }
            } catch (Exception e) {
                mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
            }
        } else {
            mostrarAlerta("Atención", "Selecciona un usuario para actualizar.");
        }
    }
    @FXML
    void onEliminar(){
        if (selectedUsuario != null) {
            boolean eliminado = gestionUsuarioController.eliminarUsuario(selectedUsuario.getIdentificacion());

            if (eliminado) {
                listUsuarios.remove(selectedUsuario);
                limpiarCamposUsuarios();
                mostrarAlerta("Éxito", "Usuario eliminado correctamente.");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar el usuario.");
            }
        } else {
            mostrarAlerta("Atención", "Selecciona un usuario para eliminar.");
        }
    }
    @FXML
    private void regresarPrincipal(){
        gestionUsuarioController.regresarAlBibliotecario();
    }

    private void agregarUsuario() {
        try {
            Usuario usuario = buildUsuario();
            if (usuario == null) {
                mostrarAlerta("Error", "Por favor completa todos los campos.");
                return;
            }
            if (gestionUsuarioController.agregarUsuario(usuario)) {
                listUsuarios.add(usuario);
                limpiarCamposUsuarios();
            } else {
                mostrarAlerta("Error", "No se pudo agregar el usuario.");
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

        lblCredencial.setVisible(false);
        txtCredencial.setVisible(false);
        listenerSelection();

        cbxTipo.setOnAction(event -> {
            Tipo seleccionado = cbxTipo.getValue();
            if (seleccionado == Tipo.ESTUDIANTE || seleccionado == Tipo.DOCENTE) {
                lblCredencial.setVisible(true);
                txtCredencial.setVisible(true);
            } else {
                lblCredencial.setVisible(false);
                txtCredencial.setVisible(false);
            }
        });
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
        tbcTipo.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getTipo()));

        cbxTipo.getItems().setAll(Tipo.values());
    }

    public Usuario buildUsuario() {
        String nombre = txtNombre.getText();
        String identificacion = txtIdentificacion.getText().trim();
        String genero = txtGenero.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();
        int edad = Integer.parseInt(txtEdad.getText().trim());
        Tipo tipo = cbxTipo.getValue();

        Usuario usuario;
        switch (tipo) {
            case DOCENTE:
                String credencialD = txtCredencial.getText().trim();
                usuario = new Docente(nombre, identificacion, genero, correo, telefono, edad, tipo, credencialD);
                break;
            case ESTUDIANTE:
                String credencialE = txtCredencial.getText().trim();
                usuario = new Estudiante(nombre, identificacion, genero, correo, telefono, edad, tipo, credencialE);
                break;
            case VISITANTE:
                usuario = new Visitante(nombre, identificacion, genero, correo, telefono, edad, tipo);
                break;
            default:
                usuario = null;
                break;
        }
        return usuario;
    }

    public void setGestionUsuarioController(GestionUsuarioController gestionUsuarioController) {
        this.gestionUsuarioController = gestionUsuarioController;
        obtenerUsuarios();
    }
    public void obtenerUsuarios() {
        List<Usuario> usuarios = gestionUsuarioController.obtenerListaUsuarios();
        listUsuarios.setAll(usuarios);
        tbvUsuarios.setItems(listUsuarios);
    }
    private void listenerSelection() {
        tbvUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedUsuario = newSelection;
            mostrarInformacionUsuario(selectedUsuario);
        });
    }
    private void mostrarInformacionUsuario(Usuario usuario) {
        if (usuario != null) {
            txtIdentificacion.setText(usuario.getIdentificacion());
            txtNombre.setText(usuario.getNombre());
            txtGenero.setText(usuario.getGenero());
            txtCorreo.setText(usuario.getCorreo());
            txtTelefono.setText(usuario.getTelefono());
            txtEdad.setText(String.valueOf(usuario.getEdad()));
            cbxTipo.setValue(usuario.getTipo());

            if (usuario instanceof Docente) {
                String credencial = ((Docente) usuario).getCredencial();
                lblCredencial.setVisible(true);
                txtCredencial.setVisible(true);
                txtCredencial.setText(credencial);

            } else if (usuario instanceof Estudiante) {
                String credencial = ((Estudiante) usuario).getCredencial();
                lblCredencial.setVisible(true);
                txtCredencial.setVisible(true);
                txtCredencial.setText(credencial);
            }
            else {
                lblCredencial.setVisible(false);
                txtCredencial.setVisible(false);
            }
        }
    }

    private void limpiarCamposUsuarios() {
        txtIdentificacion.clear();
        txtNombre.clear();
        txtGenero.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtEdad.clear();
        cbxTipo.setValue(null);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public void setApp(App app) {
        this.app = app;
    }

}
