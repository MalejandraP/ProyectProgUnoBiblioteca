package co.edu.uniquindio.poo.biblioteca2.model;

import co.edu.uniquindio.poo.biblioteca2.App;

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
    private List<Usuario> listUsuarios;
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
     */
    public Bibliotecario(String nombre, String identificacion, String genero, String correo, String telefono, int edad, double sueldo, Cargo cargo) {
        super(nombre, identificacion, genero, correo, telefono, edad, sueldo,cargo);
        this.prestamo = prestamo;
        this.biblioteca = biblioteca;
        this.listLibros = listLibros;
    }

    /**
     * Metodo para devolver un libro
     * BOTON DEVOLVER LIBRO
     * @param id
     * @param fechaDevolucion
     * @return
     */
    public boolean devolverLibro(String identificacion,String id, LocalDate fechaDevolucion){
        boolean devolucion = false;
        if (pagarDeuda(identificacion,id,fechaDevolucion)){
            Prestamo prestamo = App.biblioteca.buscarPrestamo(id);
            prestamo.devolverLibro();
            devolucion = true;

        }
        return devolucion;
    }
    /**
     * Metodo para pagar la deuda del préstamo, dejarla en 0
     * BOTON PAGAR
     * @param id
     * @param fechaDevolucion
     * @return
     */
    public boolean pagarDeuda(String identificacion,String id, LocalDate fechaDevolucion){
        boolean centinela = false;
        int deuda = 0;
        Prestamo prestamo = App.biblioteca.buscarPrestamo(id);
        if(calcularDeuda(identificacion,id, fechaDevolucion) > 0){
            prestamo.setDeuda(deuda);
           centinela = true;
        }
        return centinela;
    }
    /**
     * Metodo para calcular la deuda contando los días desde que se vencio el plazo de devolucion hasta la fecha de devolucion
     * BOTON CARGAR
     * @param fechaDevolucion
     * @return
     */
    public double calcularDeuda(String identificacion,String id, LocalDate fechaDevolucion){
        double deudaDiaria = 2000;
        double deudaFinal = 0;
        Prestamo p = App.biblioteca.buscarPrestamo(id);
        Usuario usuario = App.biblioteca.buscarUsuario(identificacion);
        System.out.println("Prestamo encontrado: " + p);
        System.out.println("Usuario encontrado: " + usuario);
        System.out.println("Fecha devolución ingresada: " + fechaDevolucion);
        if(usuario instanceof Estudiante){
            Estudiante e = (Estudiante) usuario;
            if(e.verificarPrestamo(id)){
                if (p.calcularFechaMaximaDevolucion(usuario).isBefore(fechaDevolucion)) {
                    deudaFinal = deudaDiaria * ChronoUnit.DAYS.between(p.calcularFechaMaximaDevolucion(usuario), fechaDevolucion);
                    p.setDeuda(deudaFinal);
                }
                else{
                    System.out.println("No hay deuda: la fecha de devolución no supera la fecha máxima.");
                }
            }
        }
        if(usuario instanceof Docente){
            Docente d = (Docente) usuario;
            if(d.verificarPrestamo(id)){
                if (p.calcularFechaMaximaDevolucion(usuario).isBefore(fechaDevolucion)) {
                    deudaFinal = deudaDiaria * ChronoUnit.DAYS.between(p.calcularFechaMaximaDevolucion(usuario), fechaDevolucion);
                    p.setDeuda(deudaFinal);
                }
                else{
                    System.out.println("No hay deuda: la fecha de devolución no supera la fecha máxima.");
                }
            }
        }
        return deudaFinal;
    }

    /**
     * Metodo para saber si al usuario se le puede realizar el prestamo teniendo en cuenta su deuda y la cantidad de libros que le faltan por entregar
     * @param identificacion
     * @param fechaDevolucion
     * @return
     */
    public boolean puedePrestarDeuda(String identificacion, LocalDate fechaDevolucion){
        boolean centinela= true;
        Usuario usuario= App.biblioteca.buscarUsuario(identificacion);;
        if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            for(Prestamo p : estudiante.getListPrestamos()){
                if (!estudiante.puedePrestarCantidadLibros(p) || calcularDeudaTotal(identificacion, fechaDevolucion) > 0) {
                    centinela = false;
                }
            }
        } else if (usuario instanceof Docente) {
            Docente docente = (Docente) usuario;
            for (Prestamo p : docente.getListPrestamos()) {
                if (!docente.puedePrestarCantidadLibros(p) || calcularDeudaTotal(identificacion, fechaDevolucion) > 0) {
                    centinela = false;
                }
            }
        }
        return centinela;
    }

    /**
     * Metodo para hallar el o los libros más solicitados (que tengan mayot cantidad de solicitudes)
     * @return
     */
    public List<Libro> reporteLibroMasSolicitado(){
        List<Libro> librosMasSolicitados = new ArrayList<>();
        int maxCantidadVecesPrestado=0;
        for (int i=0; i<App.biblioteca.getListLibros().size();i++){
           if(App.biblioteca.getListLibros().get(i).getSolicitudes()>maxCantidadVecesPrestado){
               maxCantidadVecesPrestado=App.biblioteca.getListLibros().get(i).getSolicitudes();
           }
        }
        for(int i=0;i<App.biblioteca.getListLibros().size();i++){
            if(App.biblioteca.getListLibros().get(i).getSolicitudes()==maxCantidadVecesPrestado){
                librosMasSolicitados.add(App.biblioteca.getListLibros().get(i));
            }
        }
        return librosMasSolicitados;
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
     *  Metodo para calcular la deuda en total de la lista de prestamos que tiene cada usuario
     */
    public double calcularDeudaTotal(String identificacion, LocalDate fechaDevolucion){
        double deudaTotal = 0;
        Usuario u = App.biblioteca.buscarUsuario(identificacion);
        if(u instanceof Estudiante){
            Estudiante e = (Estudiante) u;
            List<Prestamo> prestamosDeU = e.getListPrestamos();
            for (Prestamo p : prestamosDeU){
                if (calcularDeuda(identificacion, p.getId(), fechaDevolucion) >0){
                    deudaTotal += calcularDeuda(identificacion, p.getId(), fechaDevolucion);
                }
            }
        }
        if(u instanceof Docente){
            Docente d = (Docente) u;
            List<Prestamo> prestamosDeU = d.getListPrestamos();
            for (Prestamo p : prestamosDeU){
                if (calcularDeuda(identificacion,p .getId(), fechaDevolucion) >0){
                    deudaTotal += calcularDeuda(identificacion, p.getId(), fechaDevolucion);
                }
            }
        }
        return deudaTotal;
    }

    /**
     * Metodo para generar reporte de la lista de usuarios con una deuda mayor a 0
     * @return
     */
    public List<Usuario> reporteUsuariosDeudores(LocalDate fechaDevolucion) {
        List<Usuario> listUsuariosDeudores = new ArrayList<>();
        for (Usuario u : listUsuarios){
            String identificacion = u.getIdentificacion();
            if(calcularDeudaTotal(identificacion, fechaDevolucion) > 0){
                listUsuariosDeudores.add(u);
            }
        }
        return listUsuariosDeudores;
    }


    /**
     * Metodo para agregar un usuario a la lista, registrarlo
     * BOTON REGISTRAR USUARIO
     */
    public void agregarUsuario(Usuario usuario) {
        App.biblioteca.agregarUsuario(usuario);
    }

    /**
     * Metodo para eliminar un usuario de la lista
     * BOTON ELIMINAR USUARIO
     * @param identificacion
     */
    public void eliminarUsuario(String identificacion) {
        App.biblioteca.eliminarUsuario(identificacion);
    }

    /**
     * Metodo para actualizar la informacion de un usuario ya existente
     * BOTON ACTUALIZAR USUARIO
     * @param identificacion
     * @param actualizado
     */
    public void actualizarUsuario(String identificacion, Usuario actualizado) {
        App.biblioteca.actualizarUsuario(identificacion, actualizado);
    }

    /**
     * Metodo para agregar un libro a la lista
     * BOTON REGISTRAR LIBRO
     */
    public void agregarLibro(Libro libro) {
        App.biblioteca.agregarLibro(libro);
    }


    /**
     * Metodo para actualizar la informacion de un libro ya existente
     * BOTON ACTUALIZAR LIBRO
     * @param titulo
     * @param actualizado
     */
    public void actualizarLibro(String titulo, Libro actualizado) {
        App.biblioteca.actualizarLibro(titulo, actualizado);
    }
    /**
     * Metodo para eliminar un libro de la lista
     * BOTON ELIMINAR LIBRO
     * @param titulo
     */
    public void eliminarLibro(String titulo){
        App.biblioteca.eliminarLibro(titulo);
    }
    /**
     * Metodo para eliminar un prestamo de la lista
     * BOTON ELIMINAR PRESTAMO
     * @param id
     */
    public void eliminarPrestamo(String id){
        App.biblioteca.eliminarPrestamo(id);
    }
    /**
     * Metodo para actualizar la informacion de un prestamo ya existente
     * BOTON ACTUALIZAR LIBRO
     * @param id
     * @param prestamo
     */
    public void actualizarPrestamo(String id, Prestamo prestamo){
        App.biblioteca.actualizarPrestamo(id, prestamo);
    }

    /**
     * Metodo para registrar un prestamo con su libro asignado y usuario, se llama desde biblioteca
     * @param titulo
     * @param identificacion
     * @param fecha
     * @param id
     */
    public Prestamo prestarLibro(String titulo, String identificacion, LocalDate fecha, String id) {
        if(!puedePrestarDeuda(identificacion, fecha)){
            System.out.println("No se puede realizar el prestamo, ya que tiene deuda o no tiene suficientes libros para entregar");
            return null;
        }
        else{
            return App.biblioteca.prestarLibro(titulo, identificacion, fecha, id);
        }
    }

    public List<Prestamo> getListPrestamos() {
        return App.biblioteca.getListPrestamos();
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

    public List<Libro> getListLibros() {
        return App.biblioteca.getListLibros();
    }

    public void setListLibros(List<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
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
