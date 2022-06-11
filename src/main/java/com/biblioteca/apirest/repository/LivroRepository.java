package com.biblioteca.apirest.repository;

import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByCategoria(Categoria categoria);
    Livro findById(long id);
}
