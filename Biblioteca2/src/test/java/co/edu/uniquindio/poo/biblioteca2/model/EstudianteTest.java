package co.edu.uniquindio.poo.biblioteca2.model;

import co.edu.uniquindio.poo.biblioteca2.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    @Test
    void puedePrestarCantidadLibros() {
        Biblioteca biblioteca = new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro3= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false,  EstadoLibro.DISPONIBLE,"https.hamlet.com");
        Estudiante estudiante= new Estudiante("Carlos", "524", "masculino","carlos@", "314", 35, Tipo.DOCENTE, "547");
        LibroFisico libro2= new LibroFisico("Cien años de soledad", "Gabo", "historia", "1980", true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 8", 350);
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        LibroFisico libro4 = new LibroFisico("Rey Lear", "William Shakeapeare", "drama", "1580",true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 4", 120);
        LibroFisico libro5= new LibroFisico("Piel Desnuda", "Paty", "reflexion", "2010", true ,EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 9", 300);
        LibroFisico libro8= new LibroFisico("Orgullo y prejuicio", "Romance", "1989", "2010",true, EstadoLibro.PRESTADO, "Los tres editores", "2548", 350);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro8);
        biblioteca.agregarUsuario(estudiante);
        Prestamo prestamo= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,5,25), "4895", libro3, estudiante);
        Prestamo prestamo1= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,5,25), "0213", libro2, estudiante);
        Prestamo prestamo2= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,5,25), "7895", libro1, estudiante);
        Prestamo prestamo3= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,5,25), "3245", libro4, estudiante);
        Prestamo prestamo4= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,5,25), "9756", libro5, estudiante);
        Prestamo prestamo5= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,5,25), "4775", libro8, estudiante);
        biblioteca.agregarPrestamo(prestamo);
        biblioteca.agregarPrestamo(prestamo1);
        biblioteca.agregarPrestamo(prestamo2);
        biblioteca.agregarPrestamo(prestamo3);
        biblioteca.agregarPrestamo(prestamo4);
        App.biblioteca = biblioteca;
        assertFalse(estudiante.puedePrestarCantidadLibros(prestamo5));
    }
    @Test
    void verificarPrestamo() {
        Biblioteca biblioteca = new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro3= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false,  EstadoLibro.DISPONIBLE,"https.hamlet.com");
        Estudiante estudiante= new Estudiante("Carlos", "524", "masculino","carlos@", "314", 35, Tipo.ESTUDIANTE, "547");
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarUsuario(estudiante);
        Prestamo prestamo= new Prestamo(LocalDate.of(2025,5,15),LocalDate.of(2025,5,25), "4895", libro3, estudiante);
        App.biblioteca = biblioteca;
        assertFalse(estudiante.verificarPrestamo(prestamo.getId()));

    }


}