package com.biblioteca.apirest.repository;

import com.biblioteca.apirest.models.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    Editora findById(long id);
}
