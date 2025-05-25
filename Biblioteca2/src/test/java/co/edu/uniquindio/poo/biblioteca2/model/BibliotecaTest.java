package co.edu.uniquindio.poo.biblioteca2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    @Test
    void prestarLibro() {
        Biblioteca biblioteca=new Biblioteca("La Alejandría", "Grecia");
        Docente docente2=new Docente("Carlos", "524", "masculino","carlos@", "314", 35, Tipo.DOCENTE, "547");
        LibroDigital libro3= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false,  EstadoLibro.DISPONIBLE,"https.hamlet.com");
        biblioteca.agregarUsuario(docente2);
        biblioteca.agregarLibro(libro3);
        Prestamo prestamo1= new Prestamo(LocalDate.of(2025,5,15), "4895", libro3, docente2);
        biblioteca.agregarPrestamo(prestamo1);
        
        
        
    }
    @Test
    void agregarEmpleado() {
        Biblioteca biblioteca= new Biblioteca("La Nacional","kenedy");
        Empleado bibliotecario1= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        assertTrue(biblioteca.agregarEmpleado(bibliotecario1));
        
    }
    @Test
    void agregarUsuario() {
        Biblioteca biblioteca= new Biblioteca("Howard","Clementina");
        Docente docente2=new Docente("Carlos", "524", "masculino","carlos@", "314", 35, tipo.DOCENTE, "547");
        assertTrue(biblioteca.agregarUsuario(docente2);
    }
    @Test
    void agregarLibro() {
        Biblioteca biblioteca= new Biblioteca("Harvard","La Gran Manzana");
        LibroFisico libro2= new LibroFisico("Cien años de soledad", "Gabo", "historia", "1980", true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 8", "350");
        biblioteca.agregarLibro(libro2);
        assertFalse(biblioteca.agregarLibro(libro2));
        
    }
    @Test
    void buscarLibro() {
        Biblioteca biblioteca= new Biblioteca("UQ","bARRIO ALTO")
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarLibro(libro1);
        assertNotNull(libro1, biblioteca.buscarLibro(libro1.getTitulo()));
    }
    
    @Test
    void actualizarUsuario() {
        Biblioteca biblioteca= new Biblioteca("AsombrososLibros","El barrio");
        Estudiante estudiante2= new Estudiante("Estefanny","458","femenina", "@estef","314269", 19, Tipo.ESTUDIANTE, "849");
        assertFalse(biblioteca.actualizarUsuario(estudiante2.getIdentificacion(), estudiante2));
    }
    @Test
    void buscarUsuario() {
        Biblioteca biblioteca= new Biblioteca("UQ","bARRIO ALTO,");
        Estudiante estudiante1= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        biblioteca.agregarUsuario(estudiante1);
        assertEquals(estudiante1,biblioteca.buscarUsuario(estudiante1.getIdentificacion()));
    }

    @Test
    void buscarEmpleado() {
        Biblioteca biblioteca= new Biblioteca("universidad de los andes","Laureles");
        Empleado bibliotecario4= new Bibliotecario("Alejo", "167", "masculino", "alejo@2", "3125", 18, 2.5, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario4);
        assertNotNull(bibliotecario4, biblioteca.buscarEmpleado(bibliotecario4.getIdentificacion()));
    }

    @Test
    void buscarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("La Gran Colombia","Rocio");
        Estudiante estudiante1= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarUsuario(estudiante1);
        biblioteca.agregarLibro(libro1);
        Prestamo prestamo1= new Prestamo(LocalDate.of(2025,5,2), "123", libro1, estudiante1);
        biblioteca.agregarPrestamo(prestamo1);
        assertEquals(prestamo1, biblioteca.buscarPrestamo(prestamo1.getId()));
    }
    @Test
    void eliminarLibro() {
        Biblioteca biblioteca= new Biblioteca("Jorge Isaacs","Quimbaya");
        LibroDigital libro3= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false, EstadoLibro.DISPONIBLE,"https.hamlet.com");
        biblioteca.agregarLibro(libro3);
        assertTrue(biblioteca.eliminarLibro(libro3.getTitulo()));
    }

    @Test
    void eliminarEmpleado() {
        Biblioteca biblioteca= new Biblioteca("Albert Einstien","Coointevi");
        Bibliotecario bibliotecario3= new Bibliotecario("Sara", "157", "femenino", "sara@2", "95400", 50, 500.0, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(bibliotecario3);
        assertTrue(biblioteca.eliminarEmpleado(bibliotecario3.getIdentificacion()));
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
        LibroFisico libro4 = new LibroFisico("Rey Lear", "William Shakeapeare", "drama", "1580",true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 4", 120);
        biblioteca.agregarLibro(libro4);
        assertTrue(biblioteca.actualizarLibro(libro4.getTitulo(), libro4));

    }

    @Test
    void actualizarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Manifesto", "La quinta");
        Estudiante estudiante2= new Estudiante("Estefanny","458","femenina", "@estef","314269", 19, Tipo.ESTUDIANTE, "849");
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarUsuario(estudiante2);
        biblioteca.agregarLibro(libro1);
        Prestamo prestamo4= new Prestamo(LocalDate.of(2025,15,05), "458", libro1, estudiante2);
        assertFalse(biblioteca.actualizarPrestamo(prestamo4.getId(), prestamo4));

    }

    @Test
    void eliminarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Sueños", "La rue morgue");
        Docente docente2=new Docente("Carlos", "524", "masculino","carlos@", "314", 35, Tipo.DOCENTE, "547");
        LibroDigital libro3= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false, EstadoLibro.DISPONIBLE,"https.hamlet.com");
        biblioteca.agregarUsuario(docente2);
        biblioteca.agregarLibro(libro3);
        Prestamo prestamo3= new Prestamo(LocalDate.of(2025,15,05), "854", libro3, docente2);
        assertFalse(biblioteca.eliminarPrestamo(prestamo3.getId()));
    }

    @Test
    void agregarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Sueños", "La rue morgue");
        Estudiante estudiante1= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarUsuario(estudiante1);
        biblioteca.agregarLibro(libro1);
        Prestamo prestamo2= new Prestamo(LocalDate.of(2025,15,05) "253", libro1, estudiante1);
        biblioteca.agregarPrestamo(prestamo2);
        assertFalse(biblioteca.agregarPrestamo(prestamo2));

    }

    @Test
    void verificarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Libros 2*1", "Jose Hilarios");
        Estudiante estudiante3= new Estudiante("Britanny","5843","femenina", "@kre","31789",21, Tipo.ESTUDIANTE, "2823");
        LibroFisico libro5= new LibroFisico("Piel Desnuda", "Paty", "reflexion", "2010", true ,EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 9", 300);
        biblioteca.agregarUsuario(estudiante3);
        biblioteca.agregarLibro(libro5);
        Prestamo prestamo5= new Prestamo(LocalDate.of(2024,5,24) "2569", libro5, estudiante3);
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
        LibroFisico libro5= new LibroFisico("Piel Desnuda", "Paty", "reflexion", "2010", true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 9", 300);
        biblioteca.agregarLibro(libro5);
        assertTrue(biblioteca.verificarLibro(libro5.getTitulo()));

    }
}
