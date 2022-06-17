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
@RequestMapping(value = "/api")
@Api(value = "API REST Biblioteca")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    EditoraRepository editoraRepository;

    @ApiOperation(value = "Retorna uma lista de todos livros")
    @GetMapping("livros")
    public List<Livro> listaLivros() {

        return livroRepository.findAll();
    }

    @ApiOperation(value = "Cadastra um novo livro em uma categoria com base no ID dela")
    @PostMapping("livro/{id_categoria}/{id_autor}/{id_editora}")
    public Livro salvaLivro(@RequestBody Livro livro, @PathVariable("id_categoria") long id_categoria, @PathVariable("id_autor") long id_autor, @PathVariable("id_editora") long id_editora) {
        Categoria categoria = categoriaRepository.findById(id_categoria);
        livro.setCategoria(categoria);

        Autor autor = autorRepository.findById(id_autor);
        livro.setAutor(autor);

        Editora editora = editoraRepository.findById(id_editora);
        livro.setEditora(editora);

        return livroRepository.save(livro);
    }

    @ApiOperation(value = "Deleta um livro com base no id dele")
    @DeleteMapping("livro/{id}/")
    public void deletaLivro(@PathVariable("id") long id) {
        Livro livro = livroRepository.findById(id);
        livroRepository.delete(livro);
    }

    @ApiOperation(value = "Atualiza um livro de uma categoria com base no ID dela")
    @PutMapping("livro/{id_categoria}/{id_autor}/{id_editora}")
    public Livro atualizaLivro(@RequestBody Livro livro, @PathVariable("id_categoria") long id_categoria, @PathVariable("id_autor") long id_autor, @PathVariable("id_editora") long id_editora) {
        Categoria categoria = categoriaRepository.findById(id_categoria);
        livro.setCategoria(categoria);

        Autor autor = autorRepository.findById(id_autor);
        livro.setAutor(autor);

        Editora editora = editoraRepository.findById(id_editora);
        livro.setEditora(editora);


        return livroRepository.save(livro);
    }

    @ApiOperation(value = "Retorna uma lista de todos livros de uma categoria com base no ID dela")
    @GetMapping("categoria/{id}/livros")
    public List<Livro> listaLivrosCategoria(@PathVariable("id") long id) {
        Categoria categoria = categoriaRepository.findById(id);
        List<Livro> livros = livroRepository.findByCategoria(categoria);
        return livros;
    }

    @ApiOperation(value = "Retorna uma lista de todos livros de um autor com base no ID dele")
    @GetMapping("autor/{id}/livros")
    public List<Livro> listaLivrosAutor(@PathVariable("id") long id) {
        Autor autor = autorRepository.findById(id);
        List<Livro> livros = livroRepository.findByAutor(autor);
        return livros;
    }

    @ApiOperation(value = "Retorna uma lista de todos livros de uma editora com base no ID dela")
    @GetMapping("editora/{id}/livros")
    public List<Livro> listaLivrosEditora(@PathVariable("id") long id) {
        Editora editora = editoraRepository.findById(id);
        List<Livro> livros = livroRepository.findByEditora(editora);
        return livros;
    }

}
