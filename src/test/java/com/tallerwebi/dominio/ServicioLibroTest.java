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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        libro.setNombre("Rock and Roll");

        Libro libro2 = new Libro();
        libro2.setID(5L);
        libro2.setNombre("Un poco de amor frances");

        Libro libro3 = new Libro();
        libro3.setID(8L);
        libro3.setNombre("Dr. Saturno");

        Set <Libro> listaLibros = new HashSet<>();
        listaLibros.add(libro);
        listaLibros.add(libro2);
        listaLibros.add(libro3);

        List <Libro> librosEncontrados = new ArrayList<>();
        librosEncontrados.add(libro2);

        when(this.servicioLibro.obtenerLibroPorId(ID)).thenReturn(libro);
        when(this.servicioLibro.obtenerLibroPorNombre("Un poco de amor frances")).thenReturn((List<Libro>) librosEncontrados);
        when(this.servicioLibro.getLibros()).thenReturn(listaLibros);
        when(this.servicioLibro.borrarLibro(8L)).thenReturn(true);
    }

    @Test
    public void queSePuedaObtenerUnaListaDeLibrosQueNoEsteVacia(){

        Set<Libro> librosObtenidos = servicioLibro.getLibros();

        assertThat(librosObtenidos, not(empty()));
    }

    @Test
    public void queSePuedaObtenerUnaListaDeLibrosQueDevuelvaTresLibros(){

        Set<Libro> librosObtenidos = servicioLibro.getLibros();

        assertThat(librosObtenidos.size(), is(3));
    }

    @Test
    public void queSePuedaObtenerUnLibroPorSuId(){
        Libro libroObtenido = servicioLibro.obtenerLibroPorId(ID);

        assertThat(libroObtenido.getID(), is(ID));
    }

    @Test
    public void queSePuedaObtenerUnLibroPorNombre(){

        List<Libro> librosObtenidos = servicioLibro.obtenerLibroPorNombre("Un poco de amor frances");

        assertThat(librosObtenidos, hasSize(1));
    }

    @Test
    public void queSePuedaDarDeBajaUnLibro(){

        when(this.repositorioLibro.borrarLibro(ID)).thenReturn(true);
        //
        assertTrue(this.servicioLibro.eliminarLibro(ID));
    }

}
