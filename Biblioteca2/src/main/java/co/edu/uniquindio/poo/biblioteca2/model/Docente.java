package co.edu.uniquindio.poo.biblioteca2.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa un Docente, el cual hereda de {@link Usuario} y
 * también implementa la interfaz {@link GestionPrestamo}.
 * Los docentes tienen la capacidad de gestionar préstamos de libros.
 */

public class Docente extends Usuario implements GestionPrestamo{

    private String credencial;
    private List<Prestamo> listPrestamos;
    /**
     * Constructor de la clase Docente.
     *
     * @param nombre          Nombre del docente.
     * @param identificacion  Identificación única del docente.
     * @param genero          Género del docente.
     * @param correo          Correo electrónico del docente.
     * @param telefono        Teléfono de contacto del docente.
     * @param edad            Edad del docente.
     * @param tipo            Tipo de usuario (probablemente relacionado con {@link Tipo}).
     * @param credencial      Credencial que identifica al docente dentro del sistema.
     * @throws AssertionError Si la credencial es nula.
     */

    public Docente(String nombre, String identificacion, String genero, String correo, String telefono, int edad,Tipo tipo, String credencial) {
        super(nombre, identificacion, genero, correo, telefono, edad, tipo);
        this.credencial = credencial;
        this.listPrestamos = new ArrayList<>();
        assert credencial != null;
    }

    /**
     * Agrega un nuevo préstamo a la lista de préstamos del docente.
     *
     * @param prestamo Objeto de tipo {@link Prestamo} que se desea agregar.
     */

    @Override
    public void agregarPrestamo(Prestamo prestamo) {
        listPrestamos.add(prestamo);
    }
    /**
     * Verifica si el docente puede realizar otro préstamo, teniendo en cuenta la cantidad
     * de libros que aún no ha devuelto.
     *
     * @param prestamo Objeto de tipo {@link Prestamo} relacionado con la solicitud.
     * @return {@code true} si puede realizar el préstamo; {@code false} en caso contrario.
     */

    @Override
    public boolean puedePrestarCantidadLibros(Prestamo prestamo){
        boolean centinela = true;
        int prestamosSinDevolver=0;
        for(Prestamo p: listPrestamos){
            if(!p.isDevuelto()){
                prestamosSinDevolver++;
            }
        }
        if (prestamosSinDevolver>10){
            centinela=false;
        }
        return centinela;

    }
    /**
     * Busca un préstamo en la lista de préstamos del docente según su ID.
     *
     * @param id ID del préstamo que se desea verificar.
     * @return {@code true} si el préstamo existe; {@code false} en caso contrario.
     */

    @Override
    public boolean verificarPrestamo(String id){
        for(Prestamo p: listPrestamos){
            if(p.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    /**
     * Obtiene la lista de préstamos asociados al docente.
     *
     * @return Lista de objetos de tipo {@link Prestamo}.
     */

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }
    /**
     * Establece una nueva lista de préstamos para el docente.
     *
     * @param listPrestamos Lista de objetos de tipo {@link Prestamo} a asignar.
     */

    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }
    /**
     * Obtiene la credencial asignada al docente.
     *
     * @return Cadena que representa la credencial del docente.
     */

    public String getCredencial() {
        return credencial;
    }
    /**
     * Establece una nueva credencial para el docente.
     *
     * @param credencial Cadena que representa la nueva credencial.
     */

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }
}
