package com.biblioteca.apirest.repository;


import com.biblioteca.apirest.models.Autor;
import com.biblioteca.apirest.models.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findById(long id);
}
