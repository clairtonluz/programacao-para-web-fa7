package br.edu.fa7.cursojsf.repository;

import br.edu.fa7.cursojsf.model.UrlAcesso;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class UrlAcessoRepository {

    @Inject
    private EntityManager entityManager;


    public UrlAcesso save(UrlAcesso urlAcesso) {
        entityManager.getTransaction().begin();
        if (urlAcesso.getId() == null) {
            entityManager.persist(urlAcesso);
        } else {
            entityManager.merge(urlAcesso);
        }
        entityManager.getTransaction().commit();
        return urlAcesso;
    }

    public UrlAcesso findByUrl(String url) {
        try {
            return entityManager.createQuery("select ua from UrlAcesso ua where ua.url = :url", UrlAcesso.class)
                    .setParameter("url", url).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<UrlAcesso> findAll() {
        return entityManager.createQuery("select ua from UrlAcesso ua", UrlAcesso.class).getResultList();
    }
}
