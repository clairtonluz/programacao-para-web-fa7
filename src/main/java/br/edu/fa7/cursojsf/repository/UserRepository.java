package br.edu.fa7.cursojsf.repository;

import br.edu.fa7.cursojsf.model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class UserRepository {

    @Inject
    private EntityManager entityManager;

    public User save(User user) {
        entityManager.getTransaction().begin();
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        entityManager.getTransaction().commit();
        return user;
    }

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void remove(User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public User findByUsernameAndPassword(String username, String password) {
        try {
            return entityManager.createQuery("select  u from User u where u.username = :username and u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
