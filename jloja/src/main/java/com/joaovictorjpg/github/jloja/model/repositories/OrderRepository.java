package com.joaovictorjpg.github.jloja.model.repositories;

import com.joaovictorjpg.github.jloja.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
