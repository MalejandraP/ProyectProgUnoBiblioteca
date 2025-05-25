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
import java.time.LocalDate;

public class App extends Application {

    private Stage primaryStage;
    public static Biblioteca biblioteca = new Biblioteca("UQ", "Ca 6 La Patria");

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


    public void openCrudAdministrador(Administrador administrador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudAdministrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AdministradorViewController administradorViewController = loader.getController();
            AdministradorController administradorController = new AdministradorController();
            administradorController.setApp(this);
            administradorController.setAdministrador(administrador);
            administradorViewController.setAdministradorController(administradorController);
            administradorViewController.setAdministrador(administrador);
            administradorViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudBibliotecario(Bibliotecario bibliotecario) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudBibliotecario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            BibliotecarioViewController bibliotecarioViewController = loader.getController();
            BibliotecarioController bibliotecarioController = new BibliotecarioController();
            bibliotecarioController.setApp(this);
            bibliotecarioViewController.setBibliotecarioController(bibliotecarioController);
            bibliotecarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudEstudiante(Estudiante estudiante) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudEstudiante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            EstudianteViewController estudianteViewController = loader.getController();
            EstudianteController estudianteController = new EstudianteController();
            estudianteController.setApp(this);
            estudianteViewController.setEstudianteController(estudianteController);
            estudianteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudDocente(Docente docente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudDocente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DocenteViewController docenteViewController = loader.getController();
            DocenteController docenteController = new DocenteController();
            docenteController.setApp(this);
            docenteViewController.setDocenteController(docenteController);
            docenteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudVisitante(Visitante visitante) {
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

    public void openCrudGestionEmpleado(Administrador administrador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudGestionEmpleado.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionEmpleadoViewController gestionEmpleadoViewController = loader.getController();
            GestionEmpleadoController gestionEmpleadoController = new GestionEmpleadoController(biblioteca);
            gestionEmpleadoController.setAdministrador(administrador);
            gestionEmpleadoController.setApp(this);
            gestionEmpleadoViewController.setGestionEmpleadoController(gestionEmpleadoController);
            gestionEmpleadoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudGestionLibro() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudGestioLibro.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionLibroViewController gestionLibroViewController = loader.getController();
            GestionLibroController gestionLibroController = new GestionLibroController();
            gestionLibroController.setApp(this);
            gestionLibroViewController.setGestionLibroController(gestionLibroController);
            gestionLibroViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudGestionUsuario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudGestionUsuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionUsuarioViewController gestionUsuarioViewController = loader.getController();
            GestionUsuarioController gestionUsuarioController = new GestionUsuarioController();
            gestionUsuarioController.setApp(this);
            gestionUsuarioViewController.setGestionUsuarioController(gestionUsuarioController);
            gestionUsuarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudReportePorcentajeSinDeuda() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudReportePorcentajeSinDeuda.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionUsuarioViewController gestionUsuarioViewController = loader.getController();
            GestionUsuarioController gestionUsuarioController = new GestionUsuarioController();
            gestionUsuarioController.setApp(this);
            gestionUsuarioViewController.setGestionUsuarioController(gestionUsuarioController);
            gestionUsuarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void inicializarData(){
        Usuario visitante1 = new Visitante("Ramon", "12345678", "Masculino", "<EMAIL>", "666666666", 20, Tipo.VISITANTE);
        Bibliotecario bibliotecario1 = new Bibliotecario("Shaw", "63697", "masculino", "sahw@2", "2571", 25, 60000.0, Cargo.BIBLIOTECARIO);
        Administrador administrador1 = new Administrador("Miguel", "5634", "masculino", "miguel@2", "25631", 42, 600.0, Cargo.ADMINISTRADOR);
        Estudiante estudiante1 = new Estudiante("Samuelito", "1209", "Masc", "@miguelito123", "311", 20, Tipo.ESTUDIANTE, "7580");
        Docente docente1 = new Docente("Jose", "1235", "Masculino", "<EMAIL>", "666666666", 20, Tipo.DOCENTE, "1234");
        LibroDigital libroDig1 = new LibroDigital("El principito", "Antoine de Saint Exupéry", "Masc", "1943", false , EstadoLibro.DISPONIBLE, "omg");
        Bibliotecario bibliotecario5= new Bibliotecario("Miguel", "5634", "masculino", "miguel@2", "25631", 42, 600.0, Cargo.BIBLIOTECARIO);
        LibroDigital libro3= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false,  EstadoLibro.DISPONIBLE,"https.hamlet.com");
        Estudiante estudiante2= new Estudiante("Estefanny","458","femenina", "@estef","314269", 19, Tipo.ESTUDIANTE, "849");
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        Prestamo prestamo4= new Prestamo(LocalDate.of(2025,5,15), LocalDate.of(2025,6,2),"458", libro1, estudiante2);
        Estudiante estudiante3= new Estudiante("Britanny","5843","femenina", "@kre","31789",21, Tipo.ESTUDIANTE, "2823");
        LibroFisico libro5= new LibroFisico("Piel Desnuda", "Paty", "reflexion", "2010",  true ,EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 9", 300);
        Estudiante estudiante7= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        LibroDigital libro7= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false,EstadoLibro.DISPONIBLE,"https.com" );
        Bibliotecario bibliotecario6= new Bibliotecario("Shaw", "63697", "masculino", "sahw@2", "2571", 25, 60000.0, Cargo.BIBLIOTECARIO);
        Docente docente2=new Docente("Carlos", "524", "masculino","carlos@", "314", 35, Tipo.DOCENTE, "547");
        LibroDigital libro9= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false,EstadoLibro.DISPONIBLE,"https.hamlet.com");
        Prestamo prestamo3= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,6,2), "854", libro3, docente2);
        Prestamo prestamo2= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,6,2), "253", libro1, estudiante1);
        biblioteca.agregarUsuario(visitante1);
        biblioteca.agregarEmpleado(bibliotecario1);
        biblioteca.agregarEmpleado(administrador1);
        biblioteca.agregarUsuario(estudiante1);
        biblioteca.agregarUsuario(docente1);
        biblioteca.agregarLibro(libroDig1);
        biblioteca.agregarPrestamo(prestamo4);
        biblioteca.agregarEmpleado(bibliotecario5);
        biblioteca.agregarUsuario(estudiante2);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarUsuario(docente2);
        biblioteca.agregarLibro(libro9);
        biblioteca.agregarUsuario(estudiante7);
        biblioteca.agregarLibro(libro7);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarPrestamo(prestamo3);
        biblioteca.agregarPrestamo(prestamo2);
        biblioteca.agregarUsuario(estudiante3);
        biblioteca.agregarEmpleado(bibliotecario6);

    }
}