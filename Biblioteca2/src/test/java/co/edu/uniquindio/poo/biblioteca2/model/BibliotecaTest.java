package co.edu.uniquindio.poo.biblioteca2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {
    @Test
    void actualizarUsuario() {
        Biblioteca biblioteca= new Biblioteca("AsombrososLibros","El barrio");
        Estudiante estudiante2= new Estudiante("Estefanny","458","femenina", "@estef","314269", 19, Tipo.ESTUDIANTE, "849");
        assertFalse(biblioteca.actualizarUsuario(estudiante2.getIdentificacion(), estudiante2));
    }

    @Test
    void actualizarEmpleado() {
        Biblioteca biblioteca= new Biblioteca("Un mundo de ensueño","Esmeralda");
        Bibliotecario bibliotecario5= new Bibliotecario("Miguel", "5634", "masculino", "miguel@2", "25631", 42, 600.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario5);
        assertTrue(biblioteca.actualizarEmpleado(bibliotecario5.getIdentificacion(), bibliotecario5));
    }

    @Test
    void actualizarLibro() {
        Biblioteca biblioteca= new Biblioteca("Libros Maravillas","el centro");
        LibroFisico libro4 = new LibroFisico("Rey Lear", "William Shakeapeare", "drama", "1580", 4,true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 4", 120);
        biblioteca.agregarLibro(libro4);
        assertTrue(biblioteca.actualizarLibro(libro4.getTitulo(), libro4));

    }

    @Test
    void actualizarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Manifesto", "La quinta");
        Estudiante estudiante2= new Estudiante("Estefanny","458","femenina", "@estef","314269", 19, Tipo.ESTUDIANTE, "849");
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", 5,false, EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarUsuario(estudiante2);
        biblioteca.agregarLibro(libro1);
        Prestamo prestamo4= new Prestamo(LocalDate.of(15,05,2025),LocalDate.of(02,06,2025),LocalDate.of(28,05,2025),0.0,true, "458", libro1, estudiante2);
        assertFalse(biblioteca.actualizarPrestamo(prestamo4.getId(), prestamo4));

    }

    @Test
    void eliminarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Sueños", "La rue morgue");
        Docente docente2=new Docente("Carlos", "524", "masculino","carlos@", "314", 35, Tipo.DOCENTE, "547");
        LibroDigital libro3= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", 10, false,EstadoLibro.DISPONIBLE,"https.hamlet.com");
        biblioteca.agregarUsuario(docente2);
        biblioteca.agregarLibro(libro3);
        Prestamo prestamo3= new Prestamo(LocalDate.of(15,05,2025),LocalDate.of(02,06,2025), LocalDate.of(2,05,2025),0.0, true, "854", libro3, docente2);
        assertFalse(biblioteca.eliminarPrestamo(prestamo3.getId()));
    }

    @Test
    void agregarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Sueños", "La rue morgue");
        Estudiante estudiante1= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", 5, false,EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarUsuario(estudiante1);
        biblioteca.agregarLibro(libro1);
        Prestamo prestamo2= new Prestamo(LocalDate.of(15,05,2025),LocalDate.of(02,06,2025),LocalDate.of(28,05,2025),0.0, true, "253", libro1, estudiante1);
        biblioteca.agregarPrestamo(prestamo2);
        assertFalse(biblioteca.agregarPrestamo(prestamo2));

    }

    @Test
    void verificarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Libros 2*1", "Jose Hilarios");
        Estudiante estudiante3= new Estudiante("Britanny","5843","femenina", "@kre","31789",21, Tipo.ESTUDIANTE, "2823");
        LibroFisico libro5= new LibroFisico("Piel Desnuda", "Paty", "reflexion", "2010", 5, true ,EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 9", 300);
        biblioteca.agregarUsuario(estudiante3);
        biblioteca.agregarLibro(libro5);
        Prestamo prestamo5= new Prestamo(LocalDate.of(24,05,2025),LocalDate.of(02,06,2025),LocalDate.of(28,05,2025),0.0, true, "2569", libro5, estudiante3);
        assertFalse(biblioteca.verificarPrestamo(prestamo5.getId()));

    }

    @Test
    void verificarUsuario() {
        Biblioteca biblioteca= new Biblioteca("Libros 2*1", "Jose Hilarios");
        Estudiante estudiante3= new Estudiante("Britanny","5843","femenina", "@kre","31789",21, Tipo.ESTUDIANTE, "2823");
        assertFalse(biblioteca.verificarUsuario(estudiante3.getIdentificacion()));
    }

    @Test
    void verificarEmpleado() {
        Biblioteca biblioteca= new Biblioteca("Vidas continuas", "Colanta");
        Bibliotecario bibliotecario6= new Bibliotecario("Shaw", "63697", "masculino", "sahw@2", "2571", 25, 60000.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario6);
        assertTrue(biblioteca.verificarEmpleado(bibliotecario6.getIdentificacion()));

    }

    @Test
    void verificarLibro() {
        Biblioteca biblioteca= new Biblioteca("Miguel de Cervantes", "La ciudadela");
        LibroFisico libro5= new LibroFisico("Piel Desnuda", "Paty", "reflexion", "2010", 5,true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 9", 300);
        biblioteca.agregarLibro(libro5);
        assertTrue(biblioteca.verificarLibro(libro5.getTitulo()));

    }
}
