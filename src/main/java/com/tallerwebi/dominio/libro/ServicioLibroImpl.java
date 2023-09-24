package com.tallerwebi.dominio.libro;

import com.tallerwebi.dominio.excepcion.LibroExistente;
import com.tallerwebi.infraestructura.RepositorioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("servicioLibro")
public class ServicioLibroImpl implements ServicioLibro {

    private RepositorioLibro repositorioLibro;

    @Autowired
    public ServicioLibroImpl(RepositorioLibro repositorioLibro){
        this.repositorioLibro = repositorioLibro;
    }
    @Override
    public Set<Libro> getLibros() {
        return repositorioLibro.getLibros();
    }

    @Override
    public Libro obtenerLibroPorId(Long id) {
        return repositorioLibro.obtenerLibroPorId(id);
    }

    public List <Libro> obtenerLibroPorNombre(String nombre){
        return repositorioLibro.obtenerLibroPorNombre(nombre);
    }

    public boolean borrarLibro(Long id){
        return repositorioLibro.borrarLibro(id);
    }

    @Override
    public void registrarLibro(Libro libro) throws LibroExistente {
        List <Libro> libroEncontrado = repositorioLibro.obtenerLibroPorNombre(libro.getNombre());
        if(libroEncontrado != null){
            throw new LibroExistente();
        }

        repositorioLibro.guardar(libro);
    }


}
