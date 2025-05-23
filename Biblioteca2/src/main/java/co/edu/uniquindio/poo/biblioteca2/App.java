package co.edu.uniquindio.poo.biblioteca2;

import co.edu.uniquindio.poo.biblioteca2.controller.*;
import co.edu.uniquindio.poo.biblioteca2.model.*;
import co.edu.uniquindio.poo.biblioteca2.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;
    public static Biblioteca biblioteca = new Biblioteca("UQ", "Ca 6 La Patria", 0);

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Clientes");
        openViewPrincipal();
    }


    public void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            PrimaryController primaryController = new PrimaryController(biblioteca);
            primaryViewController.setPrimaryController(primaryController);
            primaryViewController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }


    public void openCrudAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudAdministrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AdministradorViewController administradorViewController = loader.getController();
            administradorViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudBibliotecario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudBibliotecario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            BibliotecarioViewController bibliotecarioViewController = loader.getController();
            bibliotecarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudEstudiante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudEstudiante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            EstudianteViewController estudianteViewController = loader.getController();
            estudianteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudDocente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudDocente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DocenteViewController docenteViewController = loader.getController();
            docenteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudVisitante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudVisitante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            VisitanteViewController visitanteViewController = loader.getController();
            VisitanteController visitanteController = new VisitanteController();
            visitanteController.setApp(this);
            visitanteViewController.setVisitanteController(visitanteController);
            visitanteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudListaLibros() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudListaLibros.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ListaLibrosViewController listaLibrosViewController = loader.getController();
            ListaLibrosController listaLibrosController = new ListaLibrosController();
            listaLibrosController.setApp(this);
            listaLibrosViewController.setListaLibrosController(listaLibrosController);
            listaLibrosViewController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudLibroFisico(LibroFisico libro) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudLibroFisico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LibroFisicoViewController libroFisicoViewController = loader.getController();
            LibroFisicoController libroFisicoController = new LibroFisicoController();
            libroFisicoController.setApp(this);
            libroFisicoViewController.setLibroFisicoController(libroFisicoController);
            libroFisicoViewController.setApp(this);
            libroFisicoViewController.setLibro(libro);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudLibroDigital(LibroDigital libro) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudLibroDigital.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LibroDigitalViewController libroDigitalViewController = loader.getController();
            LibroDigitalController libroDigitalController = new LibroDigitalController();
            libroDigitalController.setApp(this);
            libroDigitalViewController.setLibroDigitalController(libroDigitalController);
            libroDigitalViewController.setApp(this);
            libroDigitalViewController.setLibro(libro);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void inicializarData(){
        Usuario visitante = new Visitante("Ramon", "12345678", "Masculino", "<EMAIL>", "666666666", 20, Tipo.VISITANTE);
        LibroDigital libro = new LibroDigital("El principito", "Antoine de Saint Exupéry", "Masc", "1943", 2,true , EstadoLibro.DISPONIBLE, "omg");
        biblioteca.agregarUsuario(visitante.getNombre(),visitante.getIdentificacion(), visitante.getGenero(), visitante.getCorreo(), visitante.getTelefono(), visitante.getEdad(), visitante.getTipo());
        biblioteca.agregarLibro(libro.getTitulo(), libro.getAutor(), libro.getGenero(), libro.getAnioPublicacion(), libro.getSolicitudes(), libro.isEsFisico(), libro.getEstado(), libro.getEnlaceDescarga());

    }
}