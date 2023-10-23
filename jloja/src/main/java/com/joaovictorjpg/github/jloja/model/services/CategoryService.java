package com.joaovictorjpg.github.jloja.model.services;

import com.joaovictorjpg.github.jloja.model.entities.Category;
import com.joaovictorjpg.github.jloja.model.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.get();
    }

}
