package co.edu.uniquindio.poo.biblioteca2.model;

public interface GestionPrestamo {

    public boolean puedePrestar(Prestamo prestamo);

    public void agregarPrestamo(Prestamo prestamo);

    public boolean puedePrestarCantidadlibros(Prestamo prestamo);
}
