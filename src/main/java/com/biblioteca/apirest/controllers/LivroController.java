package com.biblioteca.apirest.controllers;


import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.models.Livro;
import com.biblioteca.apirest.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/livros")
    public List<Livro> listaLivros(){
        return livroRepository.findAll();
    }

    @GetMapping("/livro/{id}")
    public Livro listaLivroUnico(@PathVariable(value="id") long id){
        return livroRepository.findById(id);
    }

    @PostMapping("/livro")
    public Livro salvaLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @DeleteMapping("/livro")
    public void deletaLivro(@RequestBody Livro livro) {
        livroRepository.delete(livro);
    }

    @PutMapping("/livro")
    public Livro atualizaLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }
}
