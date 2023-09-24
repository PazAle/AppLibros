package com.tallerwebi.dominio.libro;
import java.util.List;
import java.util.Set;

public interface ServicioLibro {

    public Set<Libro> getLibros();

    public Libro obtenerLibroPorId(Long id);

    public List<Libro> obtenerLibroPorNombre(String nombre);

    public boolean borrarLibro (Long id);




}
