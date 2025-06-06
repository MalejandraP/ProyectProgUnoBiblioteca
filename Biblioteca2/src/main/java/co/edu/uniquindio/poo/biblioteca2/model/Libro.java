package co.edu.uniquindio.poo.biblioteca2.model;

public class Libro {
    private String titulo, autor, genero, anioPublicacion;
    private int solicitudes;
    private boolean esFisico;
    private EstadoLibro estado;

    public Libro(String titulo, String autor, String genero, String anioPublicacion,boolean esFisico, EstadoLibro estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.solicitudes = solicitudes;
        this.esFisico = esFisico;
        this.estado = estado;
        assert titulo != null;
        assert autor != null;
        assert genero != null;
        assert anioPublicacion != null;
        assert estado != null;
    }

    /**
     * Metodo booleano para saber si el estado del libro es disponible
     * @return
     */
    public boolean isDisponible() {
        if(estado.equals(EstadoLibro.DISPONIBLE)){
            return true;
        }
        return false;
    }

    /**
     * Metodo que convierte el estado del libro a prestado
     */
    public void prestar() {
        estado = EstadoLibro.PRESTADO;
        solicitudes++;
    }

    /**
     * Metodo que convierte el estado de libro en disponible
     */
    public void devolver() {
        estado = EstadoLibro.DISPONIBLE;
    }

    public EstadoLibro getEstado() {
        return estado;
    }
    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(int solicitudes) {
        this.solicitudes = solicitudes;
    }
    public boolean isEsFisico() {
        return esFisico;
    }
    public void setEsFisico(boolean esFisico) {
        this.esFisico = esFisico;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                ", solicitudes=" + solicitudes +
                ", esFisico=" + esFisico +
                ", estado=" + estado +
                '}';
    }
}
