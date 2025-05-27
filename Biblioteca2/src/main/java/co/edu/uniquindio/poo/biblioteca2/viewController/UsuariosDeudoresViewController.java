package co.edu.uniquindio.poo.biblioteca2.viewController;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.controller.UsuariosDeudoresController;
import javafx.fxml.FXML;

public class UsuariosDeudoresViewController {
    private App app;
    private UsuariosDeudoresController usuariosDeudoresController;

    @FXML
    void onRegresar() {
        regresarAlBibliotecario();
    }

    public void regresarAlBibliotecario() {
        usuariosDeudoresController.regresar();
    }

    public void setUsuariosDeudoresController(UsuariosDeudoresController usuariosDeudoresController) {
        this.usuariosDeudoresController = usuariosDeudoresController;
    }
    public void setApp(App app) {
        this.app = app;
    }
}
