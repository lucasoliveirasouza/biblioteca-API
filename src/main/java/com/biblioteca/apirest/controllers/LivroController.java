package com.biblioteca.apirest.controllers;


import com.biblioteca.apirest.models.Autor;
import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.models.Editora;
import com.biblioteca.apirest.models.Livro;
import com.biblioteca.apirest.repository.AutorRepository;
import com.biblioteca.apirest.repository.CategoriaRepository;
import com.biblioteca.apirest.repository.EditoraRepository;
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

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    EditoraRepository editoraRepository;

    @ApiOperation(value="Retorna uma lista de todos livros")
    @GetMapping("livros")
    public List<Livro> listaLivros(){

        return livroRepository.findAll();
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

    @ApiOperation(value="Retorna uma lista de todos livros de uma categoria com base no ID dela")
    @GetMapping("categoria/{id}/livros")
    public List<Livro> listaLivrosCategoria(@PathVariable("id") long id){
        Categoria categoria = categoriaRepository.findById(id);
        List<Livro> livros = livroRepository.findByCategoria(categoria);
        return livros;
    }

    @ApiOperation(value="Retorna uma lista de todos livros de um autor com base no ID dele")
    @GetMapping("autor/{id}/livros")
    public List<Livro> listaLivrosAutor(@PathVariable("id") long id){
        Autor autor = autorRepository.findById(id);
        List<Livro> livros = livroRepository.findByAutor(autor);
        return livros;
    }

    @ApiOperation(value="Retorna uma lista de todos livros de uma editora com base no ID dela")
    @GetMapping("editora/{id}/livros")
    public List<Livro> listaLivrosEditora(@PathVariable("id") long id){
        Editora editora = editoraRepository.findById(id);
        List<Livro> livros = livroRepository.findByEditora(editora);
        return livros;
    }

}
