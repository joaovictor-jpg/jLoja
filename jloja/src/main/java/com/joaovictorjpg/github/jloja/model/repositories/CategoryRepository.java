package com.joaovictorjpg.github.jloja.model.repositories;

import com.joaovictorjpg.github.jloja.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
