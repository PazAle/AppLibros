package com.tallerwebi.dominio;


import com.tallerwebi.dominio.libro.Libro;
import com.tallerwebi.dominio.libro.ServicioLibro;
import com.tallerwebi.infraestructura.RepositorioLibro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioLibroTest {

    public static final Long ID = 3L;
    private ServicioLibro servicioLibro;
    private RepositorioLibro repositorioLibro;

    @BeforeEach
    public void init(){
        this.servicioLibro = mock(ServicioLibro.class);
        this.repositorioLibro = mock(RepositorioLibro.class);

        Libro libro = new Libro();
        libro.setID(3L);

        when(this.servicioLibro.getLibro(ID)).thenReturn(libro);
    }

    @Test
    public void queSePuedaObtenerUnaListaDeLibrosQueNoEsteVacia(){

        List libros = new ArrayList();
        libros.add(new Libro());
        libros.add(new Libro());
        libros.add(new Libro());
        libros.add(new Libro());
        libros.add(new Libro());

        when(this.servicioLibro.getLibros()).thenReturn(libros);

        List<Libro> librosObtenidos = servicioLibro.getLibros();

        assertThat(librosObtenidos, not(empty()));
    }

    @Test
    public void queSePuedaObtenerUnaListaDeLibrosQueDevuelvaCincoLibros(){

        List libros = new ArrayList<>();
        libros.add(new Libro());
        libros.add(new Libro());
        libros.add(new Libro());
        libros.add(new Libro());
        libros.add(new Libro());

        when(this.servicioLibro.getLibros()).thenReturn(libros);

        List<Libro> librosObtenidos = servicioLibro.getLibros();

        assertThat(librosObtenidos.size(), is(5));
    }

    @Test
    public void queSePuedaObtenerUnLibroPorSuId(){
        Libro libroObtenido = servicioLibro.getLibro(ID);

        assertThat(libroObtenido.getID(), is(ID));
    }

}
