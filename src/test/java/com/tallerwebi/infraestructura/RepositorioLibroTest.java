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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

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

    @Transactional
    @Rollback
    @Test
    public void queSePuedaGuardarYPersistirUnLibro(){

        Libro buscado = repositorioLibro.buscarLibroPorId(libro.getID());

        assertThat(buscado, is(notNullValue()));

    }

    @Transactional
    @Rollback
    @Test
    public void queSePuedaBuscarUnLibroPorSuNombre(){

        Libro buscado = repositorioLibro.buscarLibroPorNombre(nombre);

        assertThat(buscado.getNombre(), is(nombre));
    }
}
