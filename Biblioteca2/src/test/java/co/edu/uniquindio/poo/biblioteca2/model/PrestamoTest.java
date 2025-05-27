package co.edu.uniquindio.poo.biblioteca2.model;

import co.edu.uniquindio.poo.biblioteca2.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoTest {

    @Test
    void calcularFechaMaximaDevolucion() {
        Biblioteca biblioteca= new Biblioteca("La Alejandría", "Grecia");
        LibroDigital libro1= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false,  EstadoLibro.DISPONIBLE,"https.hamlet.com");
        Docente docente2=new Docente("Carlos", "524", "masculino","carlos@", "314", 35, Tipo.DOCENTE, "547");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarUsuario(docente2);
        Prestamo prestamo= new Prestamo(LocalDate.of(2025,5,25),LocalDate.of(2025,6,14),"5967", libro1, docente2);
        LocalDate fechaEsperada= LocalDate.of(2025,6,14);
        App.biblioteca = biblioteca;
        assertEquals(fechaEsperada, prestamo.calcularFechaMaximaDevolucion(docente2));
    }

    @Test
    void devolverLibro() {
        Biblioteca biblioteca= new Biblioteca("La Alejandría", "Grecia");
        LibroDigital libro1= new LibroDigital("Hamlet", "William Shakespaeare", "Drama", "1560", false,  EstadoLibro.DISPONIBLE,"https.hamlet.com");
        Docente docente2=new Docente("Carlos", "524", "masculino","carlos@", "314", 35, Tipo.DOCENTE, "547");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarUsuario(docente2);
        Prestamo prestamo= new Prestamo(LocalDate.of(2025,5,10),LocalDate.of(2025,5,30),"5967", libro1, docente2);
        biblioteca.agregarPrestamo(prestamo);
        prestamo.devolverLibro();
        App.biblioteca = biblioteca;
        assertTrue(prestamo.isDevuelto());

    }

}