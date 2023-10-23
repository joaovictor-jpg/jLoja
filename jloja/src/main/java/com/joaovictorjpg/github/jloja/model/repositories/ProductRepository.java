package com.joaovictorjpg.github.jloja.model.repositories;

import com.joaovictorjpg.github.jloja.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
