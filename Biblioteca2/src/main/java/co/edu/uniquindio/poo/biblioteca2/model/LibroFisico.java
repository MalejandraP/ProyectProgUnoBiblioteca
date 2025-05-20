package co.edu.uniquindio.poo.biblioteca2.model;

public class LibroFisico extends Libro{
     private String editorial, ubicacionBiblioteca;
     private int numeroPaginas;

    public LibroFisico(String titulo, String autor, String genero, String anioPublicacion,int solicitudes, EstadoLibro estado, String editorial, String ubicacionBiblioteca, int numeroPaginas) {
        super(titulo, autor, genero, anioPublicacion, solicitudes, estado);
        this.editorial = editorial;
        this.ubicacionBiblioteca = ubicacionBiblioteca;
        this.numeroPaginas = numeroPaginas;
        assert editorial != null;
        assert ubicacionBiblioteca != null;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getUbicacionBiblioteca() {
        return ubicacionBiblioteca;
    }

    public void setUbicacionBiblioteca(String ubicacionBiblioteca) {
        this.ubicacionBiblioteca = ubicacionBiblioteca;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
