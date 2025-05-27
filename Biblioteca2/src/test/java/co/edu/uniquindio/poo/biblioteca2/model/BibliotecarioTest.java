package co.edu.uniquindio.poo.biblioteca2.model;

import co.edu.uniquindio.poo.biblioteca2.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class BibliotecarioTest {

    @Test
    void reporteLibroMasSolicitado() {
        Biblioteca biblioteca= new Biblioteca("Rafael Pombo", "Los pinos");
        LibroDigital libro7= new LibroDigital("La Odisea", "Homero", "Épico", "400", false, EstadoLibro.DISPONIBLE, "https.homero.com");
        Bibliotecario bibliotecario= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        LibroFisico libro8= new LibroFisico("Orgullo y prejuicio", "Jane Austen","Romance", "1989", true, EstadoLibro.PRESTADO, "Los tres editores", "2548", 350);
        biblioteca.agregarEmpleado(bibliotecario);
        biblioteca.agregarLibro(libro7);
        biblioteca.agregarLibro(libro8);
        libro7.prestar();
        libro8.prestar();
        libro7.devolver();
        libro8.devolver();
        libro8.prestar();
        libro8.devolver();
        libro8.prestar();
        App.biblioteca = biblioteca;
        List<Libro> listEsperados = List.of(libro8);
        assertIterableEquals(listEsperados, bibliotecario.reporteLibroMasSolicitado());
    }

    @Test
    void devolverLibro() {
        Biblioteca biblioteca= new Biblioteca("Bookstore", "Londres");
        LibroDigital libro6= new LibroDigital("La Divina Comedia", "Dante Aliegheri", "Ficción","1350", false, EstadoLibro.DISPONIBLE,"LINK");
        Estudiante estudiante1= new Estudiante("Emanuel", "1024830","masculino", "emanuel@","314526",17, Tipo.ESTUDIANTE,"2401");
        Bibliotecario bibliotecario= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario);
        biblioteca.agregarUsuario(estudiante1);
        biblioteca.agregarLibro(libro6);
        Prestamo prestamo1= new Prestamo(LocalDate.of(2025,5,11), LocalDate.of(2025,5,21),"693", libro6, estudiante1);
        biblioteca.agregarPrestamo(prestamo1);
        App.biblioteca = biblioteca;
        assertTrue(bibliotecario.devolverLibro(estudiante1.getIdentificacion(), prestamo1.getId(),LocalDate.of(2025,5,20)));
    }

    @Test
    void pagarDeuda() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro6= new LibroDigital("La Divina Comedia", "Dante Aliegheri", "Ficción","1350", false, EstadoLibro.DISPONIBLE,"LINK");
        Estudiante estudiante1= new Estudiante("Emanuel", "1024830","masculino", "emanuel@","314526",17, Tipo.ESTUDIANTE,"2401");
        Bibliotecario bibliotecario= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario);
        biblioteca.agregarUsuario(estudiante1);
        biblioteca.agregarLibro(libro6);
        Prestamo prestamo6= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,5,25),"4758", libro6, estudiante1);
        biblioteca.agregarPrestamo(prestamo6);
        App.biblioteca = biblioteca;
        assertTrue(bibliotecario.pagarDeuda("1024830","4758", LocalDate.of(2025,5,30)));

    }

    @Test
    void calcularDeuda() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro6= new LibroDigital("La Divina Comedia", "Dante Aliegheri", "Ficción","1350", false, EstadoLibro.DISPONIBLE,"LINK");
        Docente docente1= new Docente("Victor", "24830","masculino", "emanuel@","314926",47, Tipo.DOCENTE,"27301");
        Bibliotecario bibliotecario= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario);
        biblioteca.agregarUsuario(docente1);
        biblioteca.agregarLibro(libro6);
        Prestamo prestamo7= new Prestamo(LocalDate.of(2025,4,10), LocalDate.of(2025, 4,30),"9785", libro6, docente1);
        biblioteca.agregarPrestamo(prestamo7);
        App.biblioteca = biblioteca;
        assertEquals(6000.0, bibliotecario.calcularDeuda("24830","9785", LocalDate.of(2025,5,3)));
    }


    @Test
    void reporteLibrosPrestados() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro9= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false,  EstadoLibro.DISPONIBLE,"https.hamlet.com");
        LibroDigital libro10= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        LibroFisico libro11 = new LibroFisico("Rey Lear", "William Shakeapeare", "drama", "1580",true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 4", 120);
        Estudiante estudiante1= new Estudiante("Emanuel", "1024830","masculino", "emanuel@","314526",17, Tipo.ESTUDIANTE,"2401");
        Docente docente1= new Docente("Victor", "24830","masculino", "emanuel@","314926",47, Tipo.DOCENTE,"27301");
        Bibliotecario bibliotecario= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario);
        biblioteca.agregarLibro(libro9);
        biblioteca.agregarLibro(libro10);
        biblioteca.agregarLibro(libro11);
        biblioteca.agregarUsuario(estudiante1);
        biblioteca.agregarUsuario(docente1);
        Prestamo prestamo1= new Prestamo(LocalDate.of(2025,2,8), LocalDate.of(2025, 2,18),"96375", libro9, estudiante1);
        Prestamo prestamo2= new Prestamo(LocalDate.of(2025,5,4),LocalDate.of(2025, 5,24), "9025", libro10, docente1);
        biblioteca.agregarPrestamo(prestamo1);
        biblioteca.agregarPrestamo(prestamo2);
        List<Libro> listEsperados= List.of(libro9, libro10);
        assertIterableEquals(listEsperados, bibliotecario.reporteLibrosPrestados());

    }

    @Test
    void calculaDeudaTotal() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro10= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        LibroFisico libro11 = new LibroFisico("Rey Lear", "William Shakeapeare", "drama", "1580",true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 4", 120);
        Docente docente4= new Docente("Cayetano", "7540","masculino", "cayetano@","32037",59, Tipo.DOCENTE,"381");
        Bibliotecario bibliotecario= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario);
        biblioteca.agregarLibro(libro10);
        biblioteca.agregarLibro(libro11);
        biblioteca.agregarUsuario(docente4);
        Prestamo prestamo1 = new Prestamo(LocalDate.of(2025,4,9),LocalDate.of(2025,4,29), "02149", libro10, docente4);
        Prestamo prestamo2 = new Prestamo(LocalDate.of(2025,4,11), LocalDate.of(2025,5,1),"03349", libro11, docente4);
        biblioteca.agregarPrestamo(prestamo1);
        biblioteca.agregarPrestamo(prestamo2);

        assertEquals(14000.0, bibliotecario.calcularDeudaTotal("7540", LocalDate.of(2025,5,3)) );


    }

    @Test
    void reporteUsuariosDeudores() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro10= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        LibroFisico libro11 = new LibroFisico("Rey Lear", "William Shakeapeare", "drama", "1580",true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 4", 120);
        Estudiante estudiante4= new Estudiante("Santiago", "029145", "masculino", "santi@", "31647", 19, Tipo.ESTUDIANTE, "097");
        Docente docente5= new Docente("Cayetano", "7540","masculino", "cayetano@","32037",59, Tipo.DOCENTE,"381");
        Docente docente6= new Docente("Victor", "24830","masculino", "emanuel@","314926",47, Tipo.DOCENTE,"27301");
        Bibliotecario bibliotecario= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario);
        biblioteca.agregarLibro(libro10);
        biblioteca.agregarLibro(libro11);
        biblioteca.agregarUsuario(estudiante4);
        biblioteca.agregarUsuario(docente5);
        biblioteca.agregarUsuario(docente6);
        Prestamo prestamo1 = new Prestamo(LocalDate.of(2025,4,9),LocalDate.of(2025,4,19), "02149", libro10, estudiante4);
        Prestamo prestamo2 = new Prestamo(LocalDate.of(2025,4,11),LocalDate.of(2025,5,1), "03349", libro11, docente5);
        biblioteca.agregarPrestamo(prestamo1);
        biblioteca.agregarPrestamo(prestamo2);
        List<Usuario> listEsperados = List.of(estudiante4, docente5);
        assertIterableEquals(listEsperados, bibliotecario.reporteUsuariosDeudores(LocalDate.of(2025,5,3)));

    }
}