package com.joaovictorjpg.github.jloja.model.services;

import com.joaovictorjpg.github.jloja.Helpers.Utils;
import com.joaovictorjpg.github.jloja.model.entities.User;
import com.joaovictorjpg.github.jloja.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> list = repository.findAll();
        return list;
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User user) {
        User userBanco = repository.getReferenceById(id);
        Utils.copyNonNullProperties(user, userBanco);
        return repository.save(userBanco);
    }

}
