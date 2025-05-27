package co.edu.uniquindio.poo.biblioteca2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void isDisponible() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro10= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.PRESTADO,"https.com" );
        biblioteca.agregarLibro(libro10);
        assertFalse(libro10.isDisponible());
    }
    @Test
    void prestar() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro10= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarLibro(libro10);
        libro10.prestar();
        assertEquals(EstadoLibro.PRESTADO,libro10.getEstado());
    }
    @Test
    void devolver() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro10= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        biblioteca.agregarLibro(libro10);
        libro10.prestar();
        libro10.devolver();
        assertEquals(EstadoLibro.DISPONIBLE,libro10.getEstado());

    }

}