package com.biblioteca.apirest.repository;

import com.biblioteca.apirest.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Livro findById(long id);
}
