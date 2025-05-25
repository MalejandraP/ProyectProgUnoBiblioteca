package co.edu.uniquindio.poo.biblioteca2.model;

public interface GestionPrestamo {

    public boolean puedePrestarCantidadLibros(Prestamo prestamo);

    public void agregarPrestamo(Prestamo prestamo);

    public boolean puedePrestarCantidadlibros(Prestamo prestamo);

    public boolean puedePrestarDeuda(Prestamo prestamo);
}
