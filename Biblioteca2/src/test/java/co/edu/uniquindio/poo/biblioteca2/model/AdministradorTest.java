package co.edu.uniquindio.poo.biblioteca2.model;

import co.edu.uniquindio.poo.biblioteca2.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    void reportePorcentajeDeUsuariosNoDeudores() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        LibroDigital libro10= new LibroDigital("Narraciones extraordinarias", "Edgar Allan Poe", "Suspenso", "1800", false, EstadoLibro.DISPONIBLE,"https.com" );
        LibroFisico libro11 = new LibroFisico("Rey Lear", "William Shakeapeare", "drama", "1580",true, EstadoLibro.DISPONIBLE, "librosSuperPro", "carrera 4", 120);
        Estudiante estudiante4= new Estudiante("Santiago", "029145", "masculino", "santi@", "31647", 19, Tipo.ESTUDIANTE, "097");
        Docente docente5= new Docente("Cayetano", "7540","masculino", "cayetano@","32037",59, Tipo.DOCENTE,"381");
        Docente docente6= new Docente("Victor", "24830","masculino", "emanuel@","314926",47, Tipo.DOCENTE,"27301");
        Docente docente7= new Docente("María", "03245", "femenino", "maria@", "320169", 35, Tipo.DOCENTE, "9647");
        Administrador administrador= new Administrador("Rafael", "2658", "masculino", "rafael@2", "3488", 24, 300.0, Cargo.ADMINISTRADOR);
        biblioteca.agregarEmpleado(administrador);
        biblioteca.agregarLibro(libro10);
        biblioteca.agregarLibro(libro11);
        biblioteca.agregarUsuario(estudiante4);
        biblioteca.agregarUsuario(docente5);
        biblioteca.agregarUsuario(docente6);
        biblioteca.agregarUsuario(docente7);
        Prestamo prestamo1 = biblioteca.prestarLibro(libro10.getTitulo(), estudiante4.getIdentificacion(),LocalDate.of(2025,4,9), "02149");
        Prestamo prestamo2 = biblioteca.prestarLibro(libro11.getTitulo(), docente5.getIdentificacion(), LocalDate.of(2025,4,11), "03349");
        App.biblioteca = biblioteca;
        assertEquals(50, administrador.reportePorcentajeDeUsuariosNoDeudores(LocalDate.of(2025,5,3)));

    }@Test
    void reporteEmpleadosEliminados() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        Empleado bibliotecario1= new Bibliotecario("Rafael", "875", "masculino", "rafael@2", "3198", 24, 300.0, Cargo.BIBLIOTECARIO);
        Empleado bibliotecario2= new Bibliotecario("Alejo", "167", "masculino", "alejo@2", "3125", 18, 2.5, Cargo.BIBLIOTECARIO);
        Administrador administrador= new Administrador("Rafael", "2658", "masculino", "rafael@2", "3488", 24, 300.0, Cargo.ADMINISTRADOR);
        biblioteca.agregarEmpleado(administrador);
        biblioteca.agregarEmpleado(bibliotecario1);
        biblioteca.agregarEmpleado(bibliotecario2);
        biblioteca.eliminarEmpleado(bibliotecario1.getIdentificacion());
        biblioteca.eliminarEmpleado(bibliotecario2.getIdentificacion());
        App.biblioteca = biblioteca;
        assertEquals(2, administrador.reporteEmpleadosEliminados());
    }
    @Test
    void reporteCantidadUsuarios() {
        Biblioteca biblioteca= new Biblioteca("Le petit prince", "Francia");
        Estudiante estudiante4= new Estudiante("Santiago", "029145", "masculino", "santi@", "31647", 19, Tipo.ESTUDIANTE, "097");
        Docente docente5= new Docente("Cayetano", "7540","masculino", "cayetano@","32037",59, Tipo.DOCENTE,"381");
        Docente docente6= new Docente("Victor", "24830","masculino", "emanuel@","314926",47, Tipo.DOCENTE,"27301");
        Administrador administrador= new Administrador("Rafael", "2658", "masculino", "rafael@2", "3488", 24, 300.0, Cargo.ADMINISTRADOR);
        biblioteca.agregarEmpleado(administrador);
        biblioteca.agregarUsuario(estudiante4);
        biblioteca.agregarUsuario(docente5);
        biblioteca.agregarUsuario(docente6);
        App.biblioteca = biblioteca;
        assertEquals(3, administrador.reporteCantidadUsuarios());
    }


}