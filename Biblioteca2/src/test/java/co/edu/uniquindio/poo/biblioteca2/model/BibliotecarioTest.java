package co.edu.uniquindio.poo.biblioteca2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BibliotecarioTest {

    @Test
    void reporteLibroMasSolicitado() {
        Biblioteca biblioteca= new Biblioteca("Rafael Pombo", "Los pinos");
        LibroDigital libro7= new LibroDigital("La Odisea", "Homero", "Épico", "400", false, EstadoLibro.DISPONIBLE, "https.homero.com");
        LibroFisico libro8= new LibroFisico("Orgullo y prejuicio", "Romance", "1989", true, EstadoLibro.PRESTADO, "Los tres editores", "2548", 350);
        biblioteca.agregarLibro(libro7);
        biblioteca.agregarLibro(libro8);
    }

    @Test
    void devolverLibro() {
    }

    @Test
    void pagarDeuda() {
    }

    @Test
    void calcularDeuda() {
    }

    @Test
    void testReporteLibroMasSolicitado() {
    }

    @Test
    void reporteLibrosPrestados() {
    }

    @Test
    void calculaDeudaTotal() {
    }

    @Test
    void reporteUsuariosDeudores() {
    }
}
