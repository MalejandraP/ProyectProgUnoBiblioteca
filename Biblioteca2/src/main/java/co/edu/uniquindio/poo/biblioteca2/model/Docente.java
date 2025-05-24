package co.edu.uniquindio.poo.biblioteca2.model;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Usuario implements GestionPrestamo{

    private String credencial;
    private List<Prestamo> listPrestamos;

    public Docente(String nombre, String identificacion, String genero, String correo, String telefono, int edad,Tipo tipo, String credencial) {
        super(nombre, identificacion, genero, correo, telefono, edad, tipo);
        this.credencial = credencial;
        this.listPrestamos = new ArrayList<>();
        assert credencial != null;
    }
   
    @Override
    public void agregarPrestamo(Prestamo prestamo) {
        listPrestamos.add(prestamo);
    }
     
    @Override 
    public boolean puedePrestarCantidadlibros(Prestamo prestamo){
        boolean centinela = true; 
        int prestamosSinDevolver=0
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

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }
    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }
    public String getCredencial() {
        return credencial;
    }
    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }
}
