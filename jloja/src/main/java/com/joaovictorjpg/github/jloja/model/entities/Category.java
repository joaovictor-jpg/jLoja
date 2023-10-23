package com.joaovictorjpg.github.jloja.model.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ind;
    private String name;

    public Category() {
    }

    public Category(Long ind, String name) {
        this.ind = ind;
        this.name = name;
    }

    public Long getInd() {
        return ind;
    }

    public void setInd(Long ind) {
        this.ind = ind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(ind, category.ind) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ind, name);
    }
}
