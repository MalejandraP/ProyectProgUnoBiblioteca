package co.edu.uniquindio.poo.biblioteca2.model;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario implements GestionPrestamo {

    private String credencial;
    private List<Prestamo> listPrestamos;

    /**
     * Constructor de la clase Estudiante.
     *
     * @param nombre        Nombre del estudiante.
     * @param identificacion Identificación del estudiante.
     * @param genero        Género del estudiante.
     * @param correo        Correo electrónico del estudiante.
     * @param telefono      Teléfono del estudiante.
     * @param edad          Edad del estudiante.
     * @param tipo          Tipo de usuario.
     * @param credencial    Credencial asignada al estudiante.
     */
    public Estudiante(String nombre, String identificacion, String genero, String correo, String telefono, int edad, Tipo tipo, String credencial) {
        super(nombre, identificacion, genero, correo, telefono, edad, tipo);
        this.credencial = credencial;
        this.listPrestamos = new ArrayList<>();
        assert credencial != null;
    }

    /**
     * Verifica si el estudiante puede prestar más libros teniendo en cuenta la cantidad de préstamos pendientes por devolver.
     *
     * @param prestamo Objeto de tipo Prestamo que se desea realizar.
     * @return {@code true} si el estudiante puede realizar más préstamos, o {@code false} si ya ha superado el límite permitido.
     */
    @Override
    public boolean puedePrestarCantidadLibros(Prestamo prestamo) {
        boolean centinela = true;
        int prestamosSinDevolver = 0;
        for (Prestamo p : listPrestamos) {
            if (p.isDevuelto()) {
                prestamosSinDevolver++;
            }
        }
        if (prestamosSinDevolver > 5) {
            centinela = false;
        }
        return centinela;
    }

    /**
     * Verifica si existe un préstamo con el ID especificado en la lista de préstamos del estudiante.
     *
     * @param id ID del préstamo a verificar.
     * @return {@code true} si existe un préstamo con el ID especificado, de lo contrario {@code false}.
     */
    @Override
    public boolean verificarPrestamo(String id) {
        for (Prestamo p : listPrestamos) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega un préstamo a la lista de préstamos del estudiante.
     *
     * @param prestamo Objeto de tipo Prestamo que se desea agregar.
     */
    @Override
    public void agregarPrestamo(Prestamo prestamo) {
        listPrestamos.add(prestamo);
    }

    /**
     * Obtiene la lista de préstamos del estudiante.
     *
     * @return Lista de préstamos del estudiante.
     */
    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    /**
     * Establece la lista de préstamos del estudiante.
     *
     * @param listPrestamos Lista de préstamos a asignar al estudiante.
     */
    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }

    /**
     * Obtiene la credencial asignada al estudiante.
     *
     * @return Credencial del estudiante.
     */
    public String getCredencial() {
        return credencial;
    }

    /**
     * Establece la credencial asignada al estudiante.
     *
     * @param credencial Credencial a asignar al estudiante.
     */
    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }
}