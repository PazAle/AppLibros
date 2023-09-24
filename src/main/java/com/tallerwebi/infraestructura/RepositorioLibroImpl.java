package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.libro.Libro;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("repositorioLibro")
public class RepositorioLibroImpl implements RepositorioLibro {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioLibroImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Libro> getLibros() {
        List<Libro> libros = new ArrayList<>();
        return libros;

    }

    public Libro buscarLibroPorId(Long id) {
        return (Libro) this.sessionFactory.getCurrentSession().createCriteria(Libro.class)
                .add(Restrictions.eq("ID", id)).uniqueResult();
    }

    @Override
    public void guardar(Libro libro) {
        this.sessionFactory.getCurrentSession().save(libro);
    }

    @Override
    public Libro buscarLibroPorNombre(String nombre) {
        return (Libro) sessionFactory.getCurrentSession().createCriteria(Libro.class)
                .add(Restrictions.eq("nombre", nombre)).uniqueResult();
    }

}
