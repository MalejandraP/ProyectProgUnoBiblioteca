package co.edu.uniquindio.poo.biblioteca2.model;

public class LibroDigital extends Libro {

    private String enlaceDescarga;

    public LibroDigital(String titulo, String autor, String genero, String anioPublicacion,int solicitudes,EstadoLibro estado, String enlaceDescarga) {
        super(titulo, autor, genero, anioPublicacion, solicitudes, estado);
        this.enlaceDescarga = enlaceDescarga;
        assert enlaceDescarga != null;
    }

    public String getEnlaceDescarga() {
        return enlaceDescarga;
    }

    public void setEnlaceDescarga(String enlaceDescarga) {
        this.enlaceDescarga = enlaceDescarga;
    }

}
