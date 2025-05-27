package co.edu.uniquindio.poo.biblioteca2.model;

import co.edu.uniquindio.poo.biblioteca2.App;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Administrador extiende de Empleado y gestiona las operaciones relacionadas con la administración
 * de la biblioteca, incluyendo la gestión de empleados, usuarios y reportes.
 */
public class Administrador extends Empleado {

    private Empleado empleado;
    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario;
    private List<Usuario> listUsuarios;

    /**
     * Constructor de la clase Administrador.
     *
     * @param nombre         Nombre del administrador.
     * @param identificacion Identificación del administrador.
     * @param genero         Género del administrador.
     * @param correo         Correo electrónico del administrador.
     * @param telefono       Teléfono del administrador.
     * @param edad           Edad del administrador.
     * @param sueldo         Sueldo del administrador.
     * @param cargo          Cargo del administrador.
     */
    public Administrador(String nombre, String identificacion, String genero, String correo, String telefono, int edad, double sueldo, Cargo cargo) {
        super(nombre, identificacion, genero, correo, telefono, edad, sueldo, cargo);
        this.listUsuarios = new ArrayList<>();
        this.biblioteca = App.biblioteca;
        this.empleado = this;
    }

    /**
     * Genera un reporte del porcentaje de usuarios que no son deudores.
     *
     * @param fechaActual Fecha actual a tener en cuenta para calcular los usuarios no deudores.
     * @return Porcentaje de usuarios no deudores como un valor decimal.
     */
    public double reportePorcentajeDeUsuariosNoDeudores(LocalDate fechaActual) {
        int cantUsuariosNoDeudores = listUsuarios.size() - bibliotecario.reporteUsuariosDeudores(fechaActual).size();
        double porcentajeDeUsuariosNoDeudores = (cantUsuariosNoDeudores * 100) / listUsuarios.size();
        return porcentajeDeUsuariosNoDeudores;
    }

    /**
     * Genera un reporte sobre la cantidad de empleados eliminados de la biblioteca.
     *
     * @return Número de empleados eliminados.
     */
    public int reporteEmpleadosEliminados() {
        int eliminados = App.biblioteca.getEmpleadoEliminados();
        return eliminados;
    }

    /**
     * Genera un reporte sobre la cantidad total de usuarios registrados en la biblioteca.
     *
     * @return Número total de usuarios.
     */
    public int reporteCantidadUsuarios() {
        return App.biblioteca.getListUsuarios().size();
    }

    /**
     * Registra un nuevo empleado en la biblioteca.
     *
     * @param empleado Empleado a registrar.
     * @return {@code true} si el empleado fue registrado con éxito; {@code false} en caso contrario.
     */
    public boolean registrarEmpleado(Empleado empleado) {
        return App.biblioteca.agregarEmpleado(empleado);
    }

    /**
     * Elimina un empleado de la biblioteca basado en su identificación.
     *
     * @param identificacion Identificación del empleado a eliminar.
     * @return {@code true} si el empleado fue eliminado con éxito; {@code false} en caso contrario.
     */
    public boolean eliminarEmpleado(String identificacion) {
        return App.biblioteca.eliminarEmpleado(identificacion);
    }

    /**
     * Modifica un empleado en la biblioteca, actualizando su información con una nueva instancia de Empleado.
     *
     * @param identificacion Identificación del empleado a modificar.
     * @param actual         Objeto Empleado con la nueva información.
     * @return {@code true} si el empleado fue modificado con éxito; {@code false} en caso contrario.
     */
    public boolean modificarEmpleado(String identificacion, Empleado actual) {
        return App.biblioteca.actualizarEmpleado(identificacion, actual);
    }

    /**
     * Obtiene el empleado asociado al administrador.
     *
     * @return El empleado asociado.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Establece un empleado asociado al administrador.
     *
     * @param empleado El empleado a asociar.
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene la biblioteca asociada al administrador.
     *
     * @return La biblioteca asociada.
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * Establece la biblioteca asociada al administrador.
     *
     * @param biblioteca La biblioteca a asociar.
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * Obtiene el bibliotecario asociado al administrador.
     *
     * @return El bibliotecario asociado.
     */
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    /**
     * Establece el bibliotecario asociado al administrador.
     *
     * @param bibliotecario El bibliotecario a asociar.
     */
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    /**
     * Obtiene la lista de usuarios asociados al administrador.
     *
     * @return Lista de usuarios.
     */
    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    /**
     * Establece la lista de usuarios asociados al administrador.
     *
     * @param listUsuarios Lista de usuarios a asociar.
     */
    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }
}
