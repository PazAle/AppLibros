package com.tallerwebi.dominio.libro;

import com.tallerwebi.dominio.excepcion.LibroExistente;
import com.tallerwebi.dominio.excepcion.UsuarioExistente;
import com.tallerwebi.dominio.usuario.Usuario;
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
    public List<Libro> getLibros() {
        return repositorioLibro.getLibros();
    }

    @Override
    public Libro getLibro(Long id) {
        return repositorioLibro.buscarLibroPorId(id);
    }

    @Override
    public void registrarLibro(Libro libro) throws LibroExistente {
        Libro libroEncontrado = repositorioLibro.buscarLibroPorNombre(libro.getNombre());
        if(libroEncontrado != null){
            throw new LibroExistente();
        }

        repositorioLibro.guardar(libro);
    }


}
