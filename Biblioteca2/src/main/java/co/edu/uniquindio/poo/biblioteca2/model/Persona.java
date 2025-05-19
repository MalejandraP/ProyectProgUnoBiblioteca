package co.edu.uniquindio.poo.biblioteca2.model;

/**
 * La clase Persona representa a una persona con sus atributos básicos como
 * nombre, identificación, género, correo electrónico, teléfono y edad.
 * Ofrece métodos para acceder y modificar dichos atributos.
 */
public class Persona {
    private String nombre, identificacion, genero, correo, telefono;
    private int edad;

    /**
     * Construye una nueva instancia de Persona con los detalles proporcionados.
     *
     * @param nombre         El nombre de la persona. No puede ser null.
     * @param identificacion El número de identificación de la persona. No puede ser null.
     * @param genero         El género de la persona. No puede ser null.
     * @param correo         El correo electrónico de la persona. No puede ser null.
     * @param telefono       El número de teléfono de la persona. No puede ser null.
     * @param edad           La edad de la persona. Debe ser mayor a 0.
     * @throws AssertionError Si algún parámetro es null o la edad no es positiva.
     */
    public Persona(String nombre, String identificacion, String genero, String correo, String telefono, int edad) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
        assert nombre != null;
        assert identificacion != null;
        assert genero != null;
        assert correo != null;
        assert telefono != null;
        assert edad > 0;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para la persona.
     *
     * @param nombre El nuevo nombre que se desea asignar. No puede ser null.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de identificación de la persona.
     *
     * @return El número de identificación de la persona.
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Establece un nuevo número de identificación para la persona.
     *
     * @param identificacion El nuevo número de identificación. No puede ser null.
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene el género de la persona.
     *
     * @return El género de la persona.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece un nuevo género para la persona.
     *
     * @param genero El nuevo género que se desea asignar. No puede ser null.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return El correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece un nuevo correo electrónico para la persona.
     *
     * @param correo El nuevo correo electrónico. No puede ser null.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de teléfono de la persona.
     *
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece un nuevo número de teléfono para la persona.
     *
     * @param telefono El nuevo número de teléfono. No puede ser null.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece una nueva edad para la persona.
     *
     * @param edad La nueva edad que se desea asignar. Debe ser mayor a 0.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
}