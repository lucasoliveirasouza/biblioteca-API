package com.biblioteca.apirest.repository;

import com.biblioteca.apirest.models.Autor;
import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.models.Editora;
import com.biblioteca.apirest.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByCategoria(Categoria categoria);
    List<Livro> findByEditora(Editora editora);
    List<Livro> findByAutor(Autor autor);
    Livro findById(long id);
}
