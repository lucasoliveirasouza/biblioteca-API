package com.biblioteca.apirest.controllers;


import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.models.Livro;
import com.biblioteca.apirest.repository.CategoriaRepository;
import com.biblioteca.apirest.repository.LivroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Biblioteca")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @ApiOperation(value="Retorna uma lista de todos livros")
    @GetMapping("livros")
    public List<Livro> listaLivros(){

        return livroRepository.findAll();
    }

    @ApiOperation(value="Retorna uma lista de todos livros de uma categoria com base no ID dela")
    @GetMapping("categoria/{id}/livros")
    public List<Livro> listaLivrosCategoria(@PathVariable("id") long id){
        Categoria categoria = categoriaRepository.findById(id);
        List<Livro> livros = livroRepository.findByCategoria(categoria);
        return livros;
    }

    @ApiOperation(value="Cadastra um novo livro em uma categoria com base no ID dela")
    @PostMapping("categoria/{id}/livro")
    public Livro salvaLivro(@RequestBody Livro livro, @PathVariable("id") long id) {
        Categoria categoria = categoriaRepository.findById(id);
        livro.setCategoria(categoria);
        return livroRepository.save(livro);
    }

    @ApiOperation(value="Deleta um livro de uma categoria com base no ID dela")
    @DeleteMapping("categoria/{id}/livro")
    public void deletaLivro(@RequestBody Livro livro, @PathVariable("id") long id) {
        Categoria categoria = categoriaRepository.findById(id);
        livro.setCategoria(categoria);
        livroRepository.delete(livro);
    }

    @ApiOperation(value="Atualiza um livro de uma categoria com base no ID dela")
    @PutMapping("categoria/{id}/livro")
    public Livro atualizaLivro(@RequestBody Livro livro, @PathVariable("id") long id) {
        Categoria categoria = categoriaRepository.findById(id);
        livro.setCategoria(categoria);
        return livroRepository.save(livro);
    }

}
