package com.biblioteca.apirest.controllers;

import com.biblioteca.apirest.models.Autor;
import com.biblioteca.apirest.repository.AutorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Biblioteca")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @ApiOperation(value="Retorna uma lista com todos os autores")
    @GetMapping("/autores")
    public List<Autor> listaAutores(){

        return autorRepository.findAll();
    }

    @ApiOperation(value="Retorna um único autor com base no id")
    @GetMapping("/autor/{id}")
    public Autor listaAutorUnico(@PathVariable(value="id") long id){

        return autorRepository.findById(id);
    }

    @ApiOperation(value="Adiciona um novo autor")
    @PostMapping("/autor")
    public Autor salvaAutor(@RequestBody Autor autor) {

        return autorRepository.save(autor);
    }

    @ApiOperation(value="Deleta um autor")
    @DeleteMapping("/autor")
    public void deletaAutor(@RequestBody Autor autor) {

        autorRepository.delete(autor);
    }

    @ApiOperation(value="Atualiza um autor")
    @PutMapping("/autor")
    public Autor atualizaAutor(@RequestBody Autor autor) {

        return autorRepository.save(autor);
    }
}
