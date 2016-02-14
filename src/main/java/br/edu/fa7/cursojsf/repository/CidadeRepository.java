package br.edu.fa7.cursojsf.repository;

import br.edu.fa7.cursojsf.model.Cidade;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CidadeRepository {

    @Inject
    private EntityManager entityManager;

    public Cidade save(Cidade cidade) {
        entityManager.getTransaction().begin();
        if (cidade.getId() == null) {
            entityManager.persist(cidade);
        } else {
            entityManager.merge(cidade);
        }
        entityManager.getTransaction().commit();
        return cidade;
    }

    public void remove(Cidade cidade) {
        entityManager.getTransaction().begin();
        entityManager.remove(cidade);
        entityManager.getTransaction().commit();
    }

    public Cidade findById(Long id) {
        return entityManager.find(Cidade.class, id);
    }
}
