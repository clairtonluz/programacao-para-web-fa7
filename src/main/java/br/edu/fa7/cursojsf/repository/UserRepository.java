package br.edu.fa7.cursojsf.repository;

import br.edu.fa7.cursojsf.model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class UserRepository implements Serializable {

    @Inject
    private EntityManager entityManager;

    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        return user;
    }
}
