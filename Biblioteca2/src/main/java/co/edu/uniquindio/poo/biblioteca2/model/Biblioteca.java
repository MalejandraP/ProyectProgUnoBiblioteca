package co.edu.uniquindio.poo.biblioteca2.model;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre, direccion;
    private List<LibroDigital> listLibrosDigitales;
    private List<LibroFisico> listLibrosFisicos;
    private List<Prestamo> listPrestamos;
    private List<Estudiante> listEstudiantes;
    private List<Docente> listDocentes;
    private List<Visitante> listVisitantes;
    private List<Bibliotecario> listBibliotecarios;
    private List<Administrador> listAdministradores;
    private int empleadoEliminados;
    private List<Libro>listLibros;
    private List<Usuario> listUsuarios;
    private List<Empleado> listEmpleados;


    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listLibrosDigitales = new ArrayList<>();
        this.listLibrosFisicos = new ArrayList<>();
        this.listPrestamos = new ArrayList<>();
        this.listEstudiantes = new ArrayList<>();
        this.listDocentes = new ArrayList<>();
        this.listVisitantes = new ArrayList<>();
        this.listBibliotecarios = new ArrayList<>();
        this.listAdministradores = new ArrayList<>();
        this.empleadoEliminados= 0;
        this.listLibros = new ArrayList<>();
        this.listUsuarios = new ArrayList<>();
        this.listEmpleados = new ArrayList<>();

    }
    public void actualizarListaLibros(){
        listLibros.clear();
        if(listLibrosDigitales!=null){
            listLibros.addAll(listLibrosDigitales);
        }
        if(listLibrosFisicos!=null){
            listLibros.addAll(listLibrosFisicos);
        }
    }

    /**
     * Metodo para realizar un prestamo y agregarlo a la lista
     * @param titulo
     * @param identificacion
     * @param fecha
     * @param id
     */
    public Prestamo prestarLibro(String titulo, String identificacion, LocalDate fecha,  String id) {
        Usuario usuario = buscarUsuario(identificacion);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
        } else {
            System.out.println("Usuario encontrado: " + usuario.getNombre()); // o cualquier info útil
        }

        System.out.println("Buscando libro con título: [" + titulo + "]");
        Libro libro = buscarLibro(titulo);
        if (libro == null) {
            System.out.println("Libro no encontrado.");
        } else {
            System.out.println("Libro encontrado: " + libro.getTitulo());
        }

        if (usuario == null || libro == null) {
            return null;
        }
        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible.");
            return null;
        }
        LocalDate fechaMaximaDevolucion = null;
        Prestamo prestamo = new Prestamo(fecha, fechaMaximaDevolucion, id, libro, usuario);
        if (usuario instanceof Docente) {
            Docente docente = (Docente) usuario;
            if (!docente.puedePrestarCantidadLibros(prestamo)) {
                System.out.println("El docente tiene libros pendientes de devolver.");
                return null;
            }
            docente.agregarPrestamo(prestamo);
            prestamo.setFechaMaximaDevolucion(prestamo.calcularFechaMaximaDevolucion(docente));
            libro.prestar();
            System.out.println("Préstamo realizado con éxito para docente.");
        } else if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            if (!estudiante.puedePrestarCantidadLibros(prestamo)) {
                System.out.println("El estudiante tiene libros pendientes de devolver.");
                return null;
            }
            estudiante.agregarPrestamo(prestamo);
            prestamo.setFechaMaximaDevolucion(prestamo.calcularFechaMaximaDevolucion(estudiante));
            libro.prestar();
            System.out.println("Préstamo realizado con éxito para estudiante.");
        } else {
            System.out.println("El tipo de usuario no es válido.");
        }
        agregarPrestamo(prestamo);
        return prestamo;
    }

    /**
     * Metodo para agregar un empleado a la lista segun su cargo
     * @param empleado
     * @return
     */
    public boolean agregarEmpleado(Empleado empleado) {
        boolean centinela = false;
        if (!verificarEmpleado(empleado.getIdentificacion())){
            if (empleado instanceof Bibliotecario && empleado.getCargo() == Cargo.BIBLIOTECARIO) {
                listBibliotecarios.add((Bibliotecario)empleado);
                listEmpleados.add(empleado);
                centinela = true;
            }
            if (empleado instanceof Administrador && empleado.getCargo() == Cargo.ADMINISTRADOR) {
                listAdministradores.add((Administrador) empleado);
                listEmpleados.add(empleado);
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar un usuario a la lista segun su tipo
     * @param usuario
     * @return
     */
    public boolean agregarUsuario(Usuario usuario) {
        boolean centinela = false;
        if (!verificarUsuario(usuario.getIdentificacion())) {
            if (usuario.getTipo() == Tipo.ESTUDIANTE) {
                listEstudiantes.add((Estudiante) usuario);
                listUsuarios.add(usuario);
                centinela = true;
            }
            if (usuario.getTipo() == Tipo.DOCENTE) {
                listDocentes.add((Docente) usuario);
                listUsuarios.add(usuario);
                centinela = true;
            }
            if(usuario.getTipo() == Tipo.VISITANTE){
                listVisitantes.add((Visitante) usuario);
                listUsuarios.add(usuario);
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar un libro a la lista segun su tipo
      * @param libro
     * @return
     */
    public boolean agregarLibro(Libro libro){
        boolean centinela = false;
        if (!verificarLibro(libro.getTitulo())) {
            if(libro.isEsFisico()){
                listLibrosFisicos.add((LibroFisico) libro);
                listLibros.add(libro);
                centinela = true;
            }
            else{
                listLibrosDigitales.add((LibroDigital) libro);
                listLibros.add(libro);
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para buscar un libro en la lista mediante su titulo.
     * @param titulo Titulo del libro que se desea buscar.
     * @return El libro encontrado, o null si no existe.
     */

    public Libro buscarLibro(String titulo) {
        for (Libro libro : listLibrosDigitales) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        for (Libro libro : listLibrosFisicos) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Metodo para buscar un usuario en la lista a traves de su identificacion.
     * @param identificacion Identificacion del usuario que se desea buscar.
     * @return El usuario encontrado, o null si no existe.
     */

    public Usuario buscarUsuario(String identificacion) {
        for (Estudiante estudiante : listEstudiantes) {
            if (estudiante.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return estudiante;
            }
        }
        for (Docente docente : listDocentes) {
            if (docente.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return docente;
            }
        }for (Visitante visitante : listVisitantes) {
            if (visitante.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return visitante;
            }
        }
        return null;
    }

    /**
     * Metodo para buscar un empleado en la lista a traves de su identificacion.
     * @param identificacion Identificacion del empleado que se desea buscar.
     * @return El empleado encontrado, o null si no existe.
     */

    public Empleado buscarEmpleado(String identificacion) {
        for (Bibliotecario b : listBibliotecarios) {
            if (b.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return b;
            }
        }
        for (Administrador a : listAdministradores) {
            if (a.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Metodo para buscar un prestamo en la lista utilizando un ID especifico.
     * @param id ID del prestamo que se desea buscar.
     * @return El prestamo encontrado, o null si no existe.
     */

    public Prestamo buscarPrestamo(String id){
        for (Prestamo p : listPrestamos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Metodo para eliminar un libro de la lista mediante su titulo.
     * @param titulo Titulo del libro que se desea eliminar.
     * @return True si el libro fue eliminado exitosamente, false si no se encontro el libro.
     */

    public boolean eliminarLibro(String titulo) {
        boolean libroEliminado = false;
        for (LibroDigital libroDigital : listLibrosDigitales) {
            if (libroDigital.getTitulo().equals(titulo)) {
                listLibrosDigitales.remove(libroDigital);
                listLibros.remove(libroDigital);
                libroEliminado = true;
                break;
            }
        }
        for (LibroFisico libroFisico : listLibrosFisicos) {
            if (libroFisico.getTitulo().equals(titulo)) {
                listLibrosFisicos.remove(libroFisico);
                listLibros.remove(libroFisico);
                libroEliminado = true;
                break;
            }
        }
        return libroEliminado;
    }

    /**
     * Metodo para eliminar un empleado de la lista utilizando su identificacion.
     * @param identificacion Identificacion del empleado que se desea eliminar.
     * @return True si el empleado fue eliminado exitosamente, false si no se encontro el empleado.
     */
    public boolean eliminarEmpleado(String identificacion) {
        boolean centinela = false;
        for (Bibliotecario b : listBibliotecarios) {
            if (b.getIdentificacion().equals(identificacion)) {
                listBibliotecarios.remove(b);
                listEmpleados.remove(b);
                centinela = true;
                empleadoEliminados++;
                break;
            }
        }
        for (Administrador a : listAdministradores) {
            if (a.getIdentificacion().equals(identificacion)) {
                listAdministradores.remove(a);
                listEmpleados.remove(a);
                centinela = true;
                empleadoEliminados++;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano que permite eliminar a un usuario de la lista
     * @param identificacion
     * @return
     */
    public boolean eliminarUsuario(String identificacion) {
        boolean centinela = false;
        for (Estudiante e : listEstudiantes) {
            if (e.getIdentificacion().equals(identificacion)) {
                listEstudiantes.remove(e);
                listUsuarios.remove(e);
                centinela = true;
                break;
            }
        }
        for (Docente d : listDocentes) {
            if (d.getIdentificacion().equals(identificacion)) {
                listDocentes.remove(d);
                listUsuarios.remove(d);
                centinela = true;
                break;
            }
        }
        for (Visitante v : listVisitantes) {
            if (v.getIdentificacion().equals(identificacion)) {
                listVisitantes.remove(v);
                listUsuarios.remove(v);
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano que permite actualizar la informacion de un usuario
     * @param identificacion
     * @param actualizado
     * @return
     */
    public boolean actualizarUsuario(String identificacion, Usuario actualizado) {
        boolean centinela = false;
        for (Estudiante e : listEstudiantes) {
            if (e.getIdentificacion().equals(identificacion)) {
                e.setNombre(actualizado.getNombre());
                e.setIdentificacion(actualizado.getIdentificacion());
                e.setGenero(actualizado.getGenero());
                e.setCorreo(actualizado.getCorreo());
                e.setTelefono(actualizado.getTelefono());
                e.setEdad(actualizado.getEdad());
                e.setTipo(actualizado.getTipo());
                e.setCredencial(((Estudiante) actualizado).getCredencial()); // EXPLICAR QUE ES ESTO
                centinela = true;
                break;
            }
        }
        for (Docente d : listDocentes) {
            if (d.getIdentificacion().equals(identificacion)) {
                d.setNombre(actualizado.getNombre());
                d.setIdentificacion(actualizado.getIdentificacion());
                d.setGenero(actualizado.getGenero());
                d.setCorreo(actualizado.getCorreo());
                d.setTelefono(actualizado.getTelefono());
                d.setEdad(actualizado.getEdad());
                d.setTipo(actualizado.getTipo());
                d.setCredencial(((Docente) actualizado).getCredencial());
                centinela = true;
                break;
            }
        }
        for (Visitante v : listVisitantes) {
            if (v.getIdentificacion().equals(identificacion)) {
                v.setNombre(actualizado.getNombre());
                v.setIdentificacion(actualizado.getIdentificacion());
                v.setGenero(actualizado.getGenero());
                v.setCorreo(actualizado.getCorreo());
                v.setTelefono(actualizado.getTelefono());
                v.setEdad(actualizado.getEdad());
                v.setTipo(actualizado.getTipo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano que permite actualizar la info de un empleado
     * @param identificacion
     * @param actualizado
     * @return
     */
    public boolean actualizarEmpleado(String identificacion, Empleado actualizado) {
        boolean centinela = false;
        for (Bibliotecario b : listBibliotecarios) {
            if (b.getIdentificacion().equals(identificacion)) {
                b.setNombre(actualizado.getNombre());
                b.setIdentificacion(actualizado.getIdentificacion());
                b.setGenero(actualizado.getGenero());
                b.setCorreo(actualizado.getCorreo());
                b.setTelefono(actualizado.getTelefono());
                b.setEdad(actualizado.getEdad());
                b.setSueldo(actualizado.getSueldo());
                b.setCargo(actualizado.getCargo());
                centinela = true;
                break;
            }
        }
        for (Administrador a : listAdministradores) {
            if (a.getIdentificacion().equals(identificacion)) {
                a.setNombre(actualizado.getNombre());
                a.setIdentificacion(actualizado.getIdentificacion());
                a.setGenero(actualizado.getGenero());
                a.setCorreo(actualizado.getCorreo());
                a.setTelefono(actualizado.getTelefono());
                a.setEdad(actualizado.getEdad());
                a.setSueldo(actualizado.getSueldo());
                a.setCargo(actualizado.getCargo());
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano que permite modificar la informacion de un libro
     * @param titulo
     * @param actualizado
     * @return
     */
    public boolean actualizarLibro(String titulo, Libro actualizado){
        boolean centinela= false;
        for (LibroDigital libroDigital : listLibrosDigitales) {
            if(libroDigital.getTitulo().equals(titulo)){
                libroDigital.setTitulo(actualizado.getTitulo());
                libroDigital.setAutor(actualizado.getAutor());
                libroDigital.setGenero(actualizado.getGenero());
                libroDigital.setAnioPublicacion(actualizado.getAnioPublicacion());
                libroDigital.setSolicitudes(actualizado.getSolicitudes());
                libroDigital.setEsFisico(actualizado.isEsFisico());
                libroDigital.setEstado(actualizado.getEstado());
                libroDigital.setEnlaceDescarga(((LibroDigital)actualizado).getEnlaceDescarga());
                centinela = true;
                break;
            }
        }
        for (LibroFisico libroFisico : listLibrosFisicos) {
            if(libroFisico.getTitulo().equals(titulo)){
                libroFisico.setTitulo(actualizado.getTitulo());
                libroFisico.setAutor(actualizado.getAutor());
                libroFisico.setGenero(actualizado.getGenero());
                libroFisico.setAnioPublicacion(actualizado.getAnioPublicacion());
                libroFisico.setSolicitudes(actualizado.getSolicitudes());
                libroFisico.setEsFisico(actualizado.isEsFisico());
                libroFisico.setEstado(actualizado.getEstado());
                libroFisico.setEditorial(((LibroFisico)actualizado).getEditorial());
                libroFisico.setUbicacionBiblioteca(((LibroFisico)actualizado).getUbicacionBiblioteca());
                libroFisico.setNumeroPaginas(((LibroFisico)actualizado).getNumeroPaginas());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano que permite modificar la informacion de un prestamo
     * @param id
     * @param actualizado
     * @return
     */
    public boolean actualizarPrestamo(String id, Prestamo actualizado) {
        boolean centinela = false;
        for (Prestamo prestamo : listPrestamos) {
            if (prestamo.getId().equals(id)) {
                prestamo.setFecha(actualizado.getFecha());
                prestamo.setFechaDevolucion(actualizado.getFechaDevolucion());
                prestamo.setFechaMaximaDevolucion(actualizado.getFechaMaximaDevolucion());
                prestamo.setDevuelto(actualizado.isDevuelto());
                prestamo.setDeuda(actualizado.getDeuda());
                prestamo.setId(actualizado.getId());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano que elimina un prestamo de la lista
     * @param id
     * @return
     */
    public boolean eliminarPrestamo(String id) {
        boolean centinela = false;
        for (Prestamo p: listPrestamos) {
            if (p.getId().equals(id)) {
                listPrestamos.remove(p);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano que agrega un prestamo nuevo a la lista
     * @param prestamo
     * @return
     */
    public boolean agregarPrestamo(Prestamo prestamo) {
        boolean centinela = false;
        for (Prestamo p: listPrestamos) {
            if (!verificarPrestamo(prestamo.getId())) {
                listPrestamos.add(prestamo);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano para verificar si un prestamo ya esta en la lista
     * @param id
     * @return
     */
    public boolean verificarPrestamo(String id) {
        boolean centinela = false;
        for (Prestamo p : listPrestamos) {
            if (p.getId().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano para verificar si un usuario ya esta en la lista
     * @param identificacion
     * @return
     */
    public boolean verificarUsuario(String identificacion) {
        boolean centinela = false;
        for (Estudiante e : listEstudiantes) {
            if (e.getIdentificacion().equals(identificacion)) {
                centinela = true;
                break;
            }
        }
        for (Docente d : listDocentes) {
            if (d.getIdentificacion().equals(identificacion)) {
                centinela = true;
                break;
            }
        }
        for (Visitante v : listVisitantes) {
            if (v.getIdentificacion().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano para saber si un empleado ya está en la lista
     * @param identificacion
     * @return
     */
    public boolean verificarEmpleado(String identificacion) {
        boolean centinela = false;
        for (Bibliotecario b : listBibliotecarios) {
            if (b.getIdentificacion().equals(identificacion)) {
                centinela = true;
                break;
            }
        }
        for (Administrador a : listAdministradores) {
            if (a.getIdentificacion().equals(identificacion)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo booleano para verificar si un libro ya está en la lista
     * @param titulo
     * @return
     */
    public boolean verificarLibro(String titulo) {
        boolean centinela = false;
        for (LibroDigital libroDigital : listLibrosDigitales) {
            if (libroDigital.getTitulo().equals(titulo)) {
                centinela = true;
                break;
            }
        }
        for (LibroFisico libroFisico : listLibrosFisicos) {
            if (libroFisico.getTitulo().equals(titulo)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<LibroDigital> getListLibrosDigitales() {
        return listLibrosDigitales;
    }

    public void setListLibrosDigitales(List<LibroDigital> listLibrosDigitales) {
        this.listLibrosDigitales = listLibrosDigitales;
    }

    public List<LibroFisico> getListLibrosFisicos() {
        return listLibrosFisicos;
    }

    public void setListLibrosFisicos(List<LibroFisico> listLibrosFisicos) {
        this.listLibrosFisicos = listLibrosFisicos;
    }

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
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

    public List<Bibliotecario> getListBibliotecarios() {
        return listBibliotecarios;
    }

    public void setListBibliotecarios(List<Bibliotecario> listBibliotecarios) {
        this.listBibliotecarios = listBibliotecarios;
    }

    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    public List<Libro> getListLibros() {
        return listLibros;
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

    public List<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(List<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }

    public int getEmpleadoEliminados() {
        return empleadoEliminados;
    }

    public void setEmpleadoEliminados(int empleadoEliminados) {
        this.empleadoEliminados = empleadoEliminados;
    }


    /**
     * To String
     * @return
     */
    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listLibrosDigitales=" + listLibrosDigitales +
                ", listLibrosFisicos=" + listLibrosFisicos +
                ", listPrestamos=" + listPrestamos +
                ", listEstudiantes=" + listEstudiantes +
                ", listDocentes=" + listDocentes +
                ", listVisitantes=" + listVisitantes +
                ", listBibliotecarios=" + listBibliotecarios +
                ", listAdministradores=" + listAdministradores +
                '}';
    }
}
