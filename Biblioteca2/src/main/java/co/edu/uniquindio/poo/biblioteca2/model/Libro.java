package co.edu.uniquindio.poo.biblioteca2.model;

public class Libro {
    private String titulo, autor, genero, anioPublicacion;
    private EstadoLibro estado;

    public Libro(String titulo, String autor, String genero, String anioPublicacion, EstadoLibro estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.estado = estado;
        assert titulo != null;
        assert autor != null;
        assert genero != null;
        assert anioPublicacion != null;
        assert estado != null;
    }

    /**
     * Metodo booleano para saber si el estado de el libro es disponible
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
        estado.equals(EstadoLibro.PRESTADO);
    }

    /**
     * Metodo que convierte el estado de libro en disponible
     */
    public void devolver() {
        estado.equals(EstadoLibro.DISPONIBLE);
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
}
