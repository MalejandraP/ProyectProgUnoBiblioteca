package co.edu.uniquindio.poo.biblioteca2.model;

import co.edu.uniquindio.poo.biblioteca2.model.Libro;
import co.edu.uniquindio.poo.biblioteca2.model.Usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


/**
 * La clase Prestamo representa un préstamo de libro realizado a un usuario,
 * incluyendo información sobre fechas, estado de devolución, deudas y el libro asociado.
 */
public class Prestamo {
    private LocalDate fecha, fechaMaximaDevolucion, fechaDevolucion;
    private double deuda;
    private boolean devuelto;
    private String id;
    private Libro libro;
    private Usuario usuario;

    /**
     * Metodo constructor de la clase préstamo
     * @param fecha
     * @param fechaMaximaDevolucion
     * @param fechaDevolucion
     * @param deuda
     * @param devuelto
     * @param id
     * @param libro
     * @param usuario
     */
    public Prestamo(LocalDate fecha, String id,Libro libro, Usuario usuario) {
        this.fecha = fecha;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
        this.fechaDevolucion = null;
        this.devuelto = false;
        this.deuda = 0;
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
    }


    /**
     * Metodo para calcular la fecha máxima en la que pueden devolver el libro, considerando si el usuario es docente o estudiante
     * @param usuario
     * @return
     */
    public LocalDate calcularFechaMaimaDevolucion(Usuario usuario){
        LocalDate fechaMAX = fechaMaximaDevolucion;
        if(usuario instanceof Docente){
            fechaMAX = fecha.plusDays(20);
        }
        else{
            fechaMAX = fecha.plusDays(10);
        }
        return fechaMAX;
    }

    /**
     * Metodo get de devuelto, por default es false al realizar el préstamo
     * @return
     */
    public boolean isDevuelto() {
        return devuelto;
    }

    /**
     * Metodo NO SÉ
     */
    public void devolverLibro() {
        devuelto = true;
        libro.devolver();
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }


    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }


    @Override
    public String toString() {
        return "Prestamo{" +
                "fecha=" + fecha +
                ", fechaMaximaDevolucion=" + fechaMaximaDevolucion +
                ", fechaDevolucion=" + fechaDevolucion +
                ", deuda=" + deuda +
                ", devuelto=" + devuelto +
                ", id='" + id + '\'' +
                ", libro=" + libro +
                ", usuario=" + usuario +
                '}';
    }
}
