package co.edu.uniquindio.poo.biblioteca2.controller;

import co.edu.uniquindio.poo.biblioteca2.App;
import co.edu.uniquindio.poo.biblioteca2.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static co.edu.uniquindio.poo.biblioteca2.App.biblioteca;

public class RealizarPrestamoController {
    private App app;
    private Bibliotecario bibliotecario;

    public List<Libro> obtenerLibrosDisponibles() {
        List<Libro> librosDisponibles = new ArrayList<>();
        for(Libro l : bibliotecario.getListLibros()){
            if(l.getEstado() == EstadoLibro.DISPONIBLE){
                librosDisponibles.add(l);
            }
        }
        return librosDisponibles;
    }

    /**
     * Metodo para registrar prestamo y me devuelva ese prestamo
     * SIN HACER
     * @param titulo
     * @param identificacion
     * @param fecha
     * @param id
     * @return
     */
    public Prestamo registroPrestamo(String titulo, String identificacion, LocalDate fecha, String id) {
        try {
            Prestamo prestamo = bibliotecario.prestarLibro(titulo, identificacion, fecha, id);
            System.out.println("Préstamo creado correctamente: " + prestamo);
            return prestamo;
        } catch (Exception e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
            return null;
        }
    }

    /**
     * Metodo después de registrar, me devuelve su fecha max
     * @param titulo
     * @param identificacion
     * @param fecha
     * @param id
     * @return
     */
    public LocalDate obtenerFechaMax(String titulo, String identificacion, LocalDate fecha, String id){
        Usuario u = App.biblioteca.buscarUsuario(identificacion);
        Prestamo prestamo = registroPrestamo(titulo, identificacion, fecha, id);

        if (prestamo == null) {
            System.out.println("No se pudo realizar el préstamo, retornando null.");
            return null;
        }

        return prestamo.calcularFechaMaximaDevolucion(u);
    }



    public void regresar() {
        app.openCrudBibliotecario(bibliotecario);
    }

    public void setApp(App app) {
        this.app = app;
    }
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

}
