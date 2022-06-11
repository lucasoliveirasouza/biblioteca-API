package com.biblioteca.apirest.repository;

import com.biblioteca.apirest.models.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, String> {
}
