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

    }

    @Test
    void agregarUsuario() {
    }

    @Test
    void agregarLibro() {
    }

    @Test
    void buscarLibro() {
    }

    @Test
    void buscarUsuario() {
        Biblioteca biblioteca= new Biblioteca("UQ","bARRIO ALTO,",2);
        Estudiante estudiante1= new Estudiante("jUAN","123","nobinario", "@wre","312",12, Tipo.ESTUDIANTE, "123");
        biblioteca.agregarUsuario(estudiante1.getIdentificacion);
        assertEquals(estudiante1,biblioteca.buscarUsuario(estudiante1.getIdentificacion()));
    }

    @Test
    void buscarEmpleado() {
        Biblioteca biblioteca= new Biblioteca("universidad de los andes","Laureles",2);
        Empleado bibliotecario4= new Empleado("Alejo", "167", "masculino", "alejo@2", "3125", 18, 2.5, Cargo.BIBLIOTECARIO,)
        biblioteca.agregarEmpleado(estudiante1.getIdentificacion);
    }

    @Test
    void buscarPrestamo() {
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
