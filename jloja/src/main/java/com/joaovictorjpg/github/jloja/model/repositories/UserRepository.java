package com.joaovictorjpg.github.jloja.model.repositories;

import com.joaovictorjpg.github.jloja.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
