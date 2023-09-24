package com.tallerwebi.dominio.libro;
import com.tallerwebi.dominio.excepcion.LibroExistente;

import java.util.List;
import java.util.Set;

public interface ServicioLibro {

    public List<Libro> getLibros();

    public Libro getLibro(Long id);

    void registrarLibro(Libro libro) throws LibroExistente;
}
