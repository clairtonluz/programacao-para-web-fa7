package br.edu.fa7.cursojsf.repository;

import br.edu.fa7.cursojsf.model.Estado;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class EstadoRepository {

    @Inject
    private EntityManager entityManager;

    public Estado save(Estado estado) {
        entityManager.getTransaction().begin();
        if (estado.getId() == null) {
            entityManager.persist(estado);
        } else {
            entityManager.merge(estado);
        }
        entityManager.getTransaction().commit();
        return estado;
    }

    public List<Estado> findAll() {
        return entityManager.createQuery("select e from Estado e", Estado.class).getResultList();
    }

    public void remove(Estado estado) {
        entityManager.getTransaction().begin();
        entityManager.remove(estado);
        entityManager.getTransaction().commit();
    }

    public Estado findById(Long id) {
        return entityManager.find(Estado.class, id);
    }
}
