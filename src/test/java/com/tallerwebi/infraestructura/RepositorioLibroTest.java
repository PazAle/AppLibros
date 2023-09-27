package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.libro.Libro;
import com.tallerwebi.integracion.config.HibernateTestConfig;
import com.tallerwebi.integracion.config.SpringWebTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = { SpringWebTestConfig.class, HibernateTestConfig.class })

public class RepositorioLibroTest {

    @Autowired
    private RepositorioLibro repositorioLibro;
    private Libro libro;
    private String nombre = "Recuerdos que mienten un poco";

    @BeforeEach
    public void init(){
        libro = new Libro();
        libro.setNombre(nombre);
        repositorioLibro.guardar(libro);
    }

    @Transactional // mandas datos
    @Rollback // restablese los registros despues del test vuelve atras
    @Test
    public void queSePuedaBuscarUnLibroPorSuId(){

        Libro buscado = repositorioLibro.obtenerLibroPorId(libro.getID());

        assertThat(buscado, is(notNullValue()));

    }

    @Transactional
    @Rollback
    @Test
    public void queSePuedaBuscarUnLibroPorSuNombre(){

        Libro libro1 = new Libro();
        libro1.setNombre("Scaramanzia");
        repositorioLibro.guardar(libro1);

        Libro libro2 = new Libro();
        libro2.setNombre("Heroes del Whisky");
        repositorioLibro.guardar(libro2);

        List<Libro> buscados = repositorioLibro.obtenerLibroPorNombre(libro2.getNombre());

        assertThat(buscados, hasSize(1));
    }

    @Transactional
    @Rollback
    @Test
<<<<<<< HEAD
    public void  queSePuedaGuardarUnLibro(){

        repositorioLibro.guardar(libro);

        Libro libroBuscado = repositorioLibro.buscarLibroPorId(1L);


        assertThat(libroBuscado.getID(), is(1L));

    }

    @Transactional
    @Rollback
    @Test
    public void  queSePuedaGuardarUnLibroYAutoincrementeSuId(){

        Libro librito2 = new Libro();
        librito2.setNombre("Las aventuras de pepito");

        repositorioLibro.guardar(libro);
        repositorioLibro.guardar(librito2);

        Libro libroBuscado = repositorioLibro.buscarLibroPorId(2L);


        assertThat(libroBuscado.getID(), is(2L));

=======
    public void queSePuedaBorrarUnLibro(){
        assertTrue(repositorioLibro.borrarLibro(libro.getID()));
>>>>>>> c80a47a8bb179eaf94f5b869fdcdb3b31f674c37
    }

}
