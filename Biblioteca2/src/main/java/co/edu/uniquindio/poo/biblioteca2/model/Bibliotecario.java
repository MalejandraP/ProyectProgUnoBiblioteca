package co.edu.uniquindio.poo.biblioteca2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado{
    private List<Estudiante> listEstudiantes;
    private List<Docente> listDocentes;
    private List<Visitante> listVisitantes;
    private List<Prestamo> listPrestamos;
    private List<Libro> listLibros;
    private Prestamo prestamo;
    private Biblioteca biblioteca;

    /**
     * Metodo constructor de la clase Bibliotecario
     * @param nombre
     * @param identificacion
     * @param genero
     * @param correo
     * @param telefono
     * @param edad
     * @param sueldo
     * @param cargo
     * @param prestamo
     */
    public Bibliotecario(String nombre, String identificacion, String genero, String correo, String telefono, int edad, double sueldo, Cargo cargo, Prestamo prestamo, Biblioteca biblioteca) {
        super(nombre, identificacion, genero, correo, telefono, edad, sueldo,cargo);
        this.prestamo = prestamo;
        this.biblioteca = biblioteca;
    }



    /**
     * Metodo para devolver un libro
     * HECHO
     * BOTON DEVOLVER LIBRO
     * @param id
     * @param fechaDevolucion
     * @return
     */
    public boolean devolverLibro(String id, LocalDate fechaDevolucion){
        boolean devolucion = false;
        if (pagarDeuda(id,fechaDevolucion)){
            prestamo.devolverLibro();// ESTE SI O SI VA, CAMBIA EL BOOLEANO DE PRESTAMO DEVUELTO = TRU Y DE LIBRO LLAMA DEVOLVER CAMCIA ESTADO A DISPONIBLE
            devolucion = true;

        }
        return devolucion;
    }

    /**
     * Metodo para pagar la deuda del préstamo, dejarla en 0
     * HECHO
     * BOTON PAGAR
     * @param id
     * @param fechaDevolucion
     * @return
     */
    public boolean pagarDeuda(String id, LocalDate fechaDevolucion){
        boolean centinela = false;
        int deuda = 0;
        if(calcularDeuda(id, fechaDevolucion) > 0){
            prestamo.setDeuda(deuda);
           centinela = true;
        }
        return centinela;
    }
    /**
     * Metodo para calcular la deuda contando los días desde que se vencio el plazo de devolucion hasta la fecha de devolucion
     * HECHO
     * BOTON CARGAR
     * @param fechaDevolucion
     * @return
     */
    public double calcularDeuda(String id, LocalDate fechaDevolucion){
        double deudaDiaria = 2000;
        double deudaFinal = 0;
        LocalDate fechaMaximaDev = prestamo.getFechaMaximaDevolucion();
        if(biblioteca.verificarPrestamo(id)){
            prestamo.setFechaDevolucion(fechaDevolucion);
            if (fechaMaximaDev.isBefore(fechaDevolucion)) {
                deudaFinal = deudaDiaria * ChronoUnit.DAYS.between(fechaMaximaDev, fechaDevolucion);
                prestamo.setDeuda(deudaFinal);
            }
        }
        return deudaFinal;
    }

    /**
     * METODO PARA GENERAR LA LISTA DE LIBROS QUE ESTAN PRESTADOS
     */
    public List<Libro> reporteLibrosPrestados(){
        List<Libro> listLibrosPrestados = new ArrayList<>();
        for(Libro libro : listLibros ){
            if (libro.getEstado().equals(EstadoLibro.PRESTADO)){
                listLibrosPrestados.add(libro);
            }
        }
        return listLibrosPrestados;
    }

    /**
     * METODO PARA GENERAR REPORTE DE LOS USUARIOS QUE TIENEN DEUDAS, NECESITO LA FECHA DE DEVOLUCION O FECHA EN SI
     * NO SE
     */
    public List<Usuario> reporteUsuariosDeuddores(){
        List<Usuario> listUsuariosDeudores = new ArrayList<>();
        return listUsuariosDeudores;
    }
    /**
     * Metodo para agregar un usuario a la lista, registrarlo
     * BOTON REGISTRAR USUARIO
     * @param identificacion
     */
    public void agregarUsuario(String identificacion) {
        biblioteca.agregarUsuario(identificacion);
    }

    /**
     * Metodo para eliminar un usuario de la lista
     * BOTON ELIMINAR USUARIO
     * @param identificacion
     */
    public void eliminarUsuario(String identificacion) {
        biblioteca.eliminarUsuario(identificacion);
    }

    /**
     * Metodo para actualizar la informacion de un usuario ya existente
     * BOTON ACTUALIZAR USUARIO
     * @param identificacion
     * @param actualizado
     */
    public void actualizarUsuario(String identificacion, Usuario actualizado) {
        biblioteca.actualizarUsuario(identificacion, actualizado);
    }

    /**
     * Metodo para agregar un libro a la lista
     * BOTON REGISTRAR LIBRO
     * @param titulo
     */
    public void agregarLibro(String titulo) {
        biblioteca.agregarLibro(titulo);
    }

    /**
     * Metodo para actualizar la informacion de un libro ya existente
     * BOTON ACTUALIZAR LIBRO
     * @param titulo
     * @param actualizado
     */
    public void actualizarLibro(String titulo, Libro actualizado) {
        biblioteca.actualizarLibro(titulo, actualizado);
    }
    /**
     * Metodo para eliminar un libro de la lista
     * BOTON ELIMINAR LIBRO
     * @param titulo
     */
    public void eliminarLibro(String titulo){
        biblioteca.eliminarLibro(titulo);
    }
    /**
     * Metodo para eliminar un prestamo de la lista
     * BOTON ELIMINAR PRESTAMO
     * @param id
     * @param prestamo
     */
    public void eliminarPrestamo(String id,Prestamo prestamo){
        biblioteca.eliminarPrestamo(id, prestamo);
    }
    /**
     * Metodo para actualizar la informacion de un prestamo ya existente
     * BOTON ACTUALIZAR LIBRO
     * @param id
     * @param prestamo
     */
    public void actualizarPrestamo(String id, Prestamo prestamo){
        biblioteca.eliminarPrestamo(id, prestamo);
    }

    /**
     * Metodo para registrar un prestamo con su libro asignado y usuario, se llama desde biblioteca
     * @param titulo
     * @param identificacion
     * @param fecha
     * @param fechaMaximaDevolucion
     * @param fechaDevolucion
     * @param deuda
     * @param devuelto
     * @param id
     */
    public void prestarLibro(String titulo, String identificacion, LocalDate fecha, LocalDate fechaMaximaDevolucion, LocalDate fechaDevolucion, double deuda, boolean devuelto, String id) {
        biblioteca.prestarLibro(titulo, identificacion, fecha, fechaMaximaDevolucion, fechaDevolucion, deuda, devuelto, id);
    }

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public List<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(List<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    public List<Docente> getListDocentes() {
        return listDocentes;
    }

    public void setListDocentes(List<Docente> listDocentes) {
        this.listDocentes = listDocentes;
    }

    public List<Visitante> getListVisitantes() {
        return listVisitantes;
    }

    public void setListVisitantes(List<Visitante> listVisitantes) {
        this.listVisitantes = listVisitantes;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "listEstudiantes=" + listEstudiantes +
                ", listDocentes=" + listDocentes +
                ", listVisitantes=" + listVisitantes +
                ", listPrestamos=" + listPrestamos +
                ", prestamo=" + prestamo +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
