package br.edu.fa7.cursojsf.service;

import br.edu.fa7.cursojsf.model.User;
import br.edu.fa7.cursojsf.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by clairtonluz on 13/02/16.
 */
public class UserService {

    @Inject
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.remove(userRepository.findById(id));
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
