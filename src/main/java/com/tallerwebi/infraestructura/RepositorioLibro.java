package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.libro.Libro;

import java.util.List;
import java.util.Set;

public interface RepositorioLibro {
    public Set<Libro> getLibros();

    public Libro obtenerLibroPorId(Long id);

    public void guardar(Libro libro);

    public List<Libro> obtenerLibroPorNombre(String nombre);

    public boolean borrarLibro (Long id);
}
