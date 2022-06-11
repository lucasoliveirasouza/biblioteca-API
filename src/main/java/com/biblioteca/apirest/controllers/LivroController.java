package com.biblioteca.apirest.controllers;


import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.models.Livro;
import com.biblioteca.apirest.repository.CategoriaRepository;
import com.biblioteca.apirest.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("livros ")
    public List<Livro> listaLivros(){
        return livroRepository.findAll();
    }

    @GetMapping("categoria/{id}/livros")
    public List<Livro> listaLivrosCategoria(@PathVariable("id") long id){
        Categoria categoria = categoriaRepository.findById(id);
        List<Livro> livros = livroRepository.findByCategoria(categoria);
        return livros;
    }

    @PostMapping("categoria/{id}/livro")
    public Livro salvaLivro(@RequestBody Livro livro, @PathVariable("id") long id) {
        Categoria categoria = categoriaRepository.findById(id);
        livro.setCategoria(categoria);
        return livroRepository.save(livro);
    }

    @DeleteMapping("categoria/{id}/livro")
    public void deletaLivro(@RequestBody Livro livro, @PathVariable("id") long id) {
        Categoria categoria = categoriaRepository.findById(id);
        livro.setCategoria(categoria);
        livroRepository.delete(livro);
    }

    @PutMapping("categoria/{id}/livro")
    public Livro atualizaLivro(@RequestBody Livro livro, @PathVariable("id") long id) {
        Categoria categoria = categoriaRepository.findById(id);
        livro.setCategoria(categoria);
        return livroRepository.save(livro);
    }

}
