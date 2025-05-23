package co.edu.uniquindio.poo.biblioteca2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BibliotecaTest {
    @Test
    void actualizarListaLibrosDigitales() {
    }

    @Test
    void prestarLibro() {
    }

    @Test
    void agregarEmpleado() {
        Biblioteca biblioteca= new Biblioteca("La Nacional","kenedy");
        Empleado bibliotecario1= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300, Cargo.BIBLIOTECARIO);
        aasertTrue(biblioteca.agregarEmpleado(bibliotecario1));
        

    }

    @Test
    void agregarUsuario() {
        Biblioteca biblioteca= new Biblioteca("Howard","Clementina");
        Docente docente2=new Docente("Carlos", "524", "masculino","carlos@", "314", 35, tipo.DOCENTE, "547");
        assertTrue(biblioteca.agregarUsuario(docente2.getIdentificacion);
    }

    @Test
    void agregarLibro() {
        Biblioteca biblioteca= new Biblioteca("Harvard","La Gran Manzana");
        LibroFisico libro2= new LibroFisico("Cien años de soledad", "Gabo", "historia", "1980", 4, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 8", "350");
        biblioteca.agregarLibro(libro2.getTitulo);
        assertFalse(biblioteca.agregarLibro(libro2.getTitulo));
        
    }

    @Test
    void buscarLibro() {
        Biblioteca biblioteca= new Biblioteca("UQ","bARRIO ALTO")
        LibroDigital libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", 5, EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarLibro(libro1.getIdentificacion);
        assertNotNull(libro1, biblioteca.buscarLibro(libro1.getTitulo));
    }

    @Test
    void buscarUsuario() {
        Biblioteca biblioteca= new Biblioteca("UQ","bARRIO ALTO,");
        Estudiante estudiante1= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        biblioteca.agregarUsuario(estudiante1.getIdentificacion);
        assertEquals(estudiante1,biblioteca.buscarUsuario(estudiante1.getIdentificacion()));
    }

    @Test
    void buscarEmpleado() {
        Biblioteca biblioteca= new Biblioteca("universidad de los andes","Laureles");
        Empleado bibliotecario4= new Bibliotecario("Alejo", "167", "masculino", "alejo@2", "3125", 18, 2.5, Cargo.BIBLIOTECARIO);
        biblioteca.agregarEmpleado(biblitecario4.getIdentificacion);
        assertNotNull(bibliotecario4, biblioteca.buscarEmpleado(bibliotecario4.getIdentificacion()));
    }

    @Test
    void buscarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("La Gran Colombia","Rocio");
        Estudiante estudiante1= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        Libro libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", 5, EstadoLibro.DISPONIBLE,"https.com" );
        Prestamo prestamo1= new Prestamo(22/05/2025,02/06/2025,28/05/2025,0.0, True, 123, libro1, estudiante1);
        biblioteca.agregarPrestamo(prestamo1.getId);
        assertEquals(prestamo1, biblioteca.buscarPrestamo(prestamo1.getId));
    }

    @Test
    void eliminarLibro() {
        Biblioteca biblioteca= new Biblioteca("Jorge Isaacs","Quimbaya")
        LibroDigital libro3= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", 10, EstadoLibro.DISPONIBLE,"https.hamlet.com");
        biblioteca.agregarLibro(libro3.getIdentificacion);
        assertTrue(biblioteca.eliminarLibro(libro3.getIdentificacion));
    }

    @Test
    void eliminarEmpleado() {
    }

    @Test
    void eliminarUsuario() {
    }

    @Test
    void actualizarUsuario() {
    }

    @Test
    void actualizarEmpleado() {
    }

    @Test
    void actualizarLibro() {
    }

    @Test
    void actualizarPrestamo() {
    }

    @Test
    void eliminarPrestamo() {
    }

    @Test
    void agregarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("Sueños", "La rue morgue");
        Estudiante estudiante1= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        Libro libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", 5, EstadoLibro.DISPONIBLE,"https.com" );
        Prestamo prestamo2= new Prestamo(15/05/2025,02/06/2025,28/05/2025,0.0, True, 123, libro1, estudiante1);
        biblioteca.agregarPrestamo(prestamo2.getId);
        assertFalse(biblioteca.agregarPrestamo(prestamo2.getId))
        
    }

    @Test
    void verificarPrestamo() {
    }

    @Test
    void verificarUsuario() {
    }

    @Test
    void verificarEmpleado() {
    }

    @Test
    void verificarLibro() {
    }
}
