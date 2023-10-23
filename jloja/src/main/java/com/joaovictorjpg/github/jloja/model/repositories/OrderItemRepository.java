package com.joaovictorjpg.github.jloja.model.repositories;

import com.joaovictorjpg.github.jloja.model.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
