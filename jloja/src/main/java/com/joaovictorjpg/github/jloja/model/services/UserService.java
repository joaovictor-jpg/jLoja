package com.joaovictorjpg.github.jloja.model.services;

import com.joaovictorjpg.github.jloja.Helpers.Bcrypt;
import com.joaovictorjpg.github.jloja.Helpers.Utils;
import com.joaovictorjpg.github.jloja.model.entities.User;
import com.joaovictorjpg.github.jloja.model.repositories.UserRepository;
import com.joaovictorjpg.github.jloja.model.services.exceptionServices.AutoFillException;
import com.joaovictorjpg.github.jloja.model.services.exceptionServices.DatabaseException;
import com.joaovictorjpg.github.jloja.model.services.exceptionServices.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        user.setPassword(Bcrypt.brycptPassword(user.getPassword()));
        return repository.save(user);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        try {
            User userBanco = repository.getReferenceById(id);
            Utils.copyNonNullProperties(user, userBanco);
            return repository.save(userBanco);
        } catch (FatalBeanException e) {
            throw new AutoFillException(e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public User findByName(String name) {
        return repository.findByName(name);
    }

}
