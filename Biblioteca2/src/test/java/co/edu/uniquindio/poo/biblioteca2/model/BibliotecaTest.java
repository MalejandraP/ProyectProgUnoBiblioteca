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
        aasertTrue(True,biblioteca.agregarEmpleado(bibliotecario1));
        

    }

    @Test
    void agregarUsuario() {
    }

    @Test
    void agregarLibro() {
    }

    @Test
    void buscarLibro() {
        Biblioteca biblioteca= new Biblioteca("UQ","bARRIO ALTO")
        Libro libro1= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", 5, EstadoLibro.DISPONIBLE,"https.com" );
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
        assertNotNull(bibliotecario4.buscarEmpleado(bibliotecario4.getIdentificacion()));
    }

    @Test
    void buscarPrestamo() {
        Biblioteca biblioteca= new Biblioteca("La Gran Colombia","Rocio");
        Prestamo prestamo
        biblioteca.agregarEmpleado(biblitecario4.getIdentificacion);
        assertNotNull(bibliotecario4.buscarEmpleado(bibliotecario4.getIdentificacion()));
    }

    @Test
    void eliminarLibro() {
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
