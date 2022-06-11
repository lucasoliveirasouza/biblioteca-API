package com.biblioteca.apirest.repository;

import com.biblioteca.apirest.models.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, String> {
}
