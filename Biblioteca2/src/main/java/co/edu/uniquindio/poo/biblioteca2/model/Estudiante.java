package co.edu.uniquindio.poo.biblioteca2.model;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Usuario implements GestionPrestamo{

    private String credencial;
    private List<Prestamo> listPrestamos;

    public Estudiante(String nombre, String identificacion, String genero, String correo, String telefono, int edad,Tipo tipo, String credencial) {
        super(nombre, identificacion, genero, correo, telefono, edad, tipo);
        this.credencial = credencial;
        this.listPrestamos = new ArrayList<>();
        assert credencial != null;
    }

    /**
     * PUEDE SER METODO ABSTRACTO DE USUARIO Y EN VISITANTE PONER DIRECTAMENTE NO, PARA PODER LLAMAR EL PUEDE PRESTAR DESDE USUARIO EN BIBLIOTECA
     * @return
     */
    @Override
    public boolean puedePrestar(Prestamo prestamo) {
        boolean centinela = true;
        for (Prestamo p : listPrestamos) {
            if (p.isDevuelto()) {
                centinela = false;
                break;
            }
        }
        return centinela;
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
        if (prestamosSinDevolver>5){
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
