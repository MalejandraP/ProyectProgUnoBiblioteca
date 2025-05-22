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
        assertEquals(123,biblioteca.buscarUsuario(estudiante1.getIdentificacion()));
    }

    @Test
    void buscarEmpleado() {
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
