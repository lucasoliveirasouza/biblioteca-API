package com.biblioteca.apirest.repository;

import com.biblioteca.apirest.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findById(long id);
}
