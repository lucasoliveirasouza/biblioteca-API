package com.biblioteca.apirest.controllers;

import com.biblioteca.apirest.models.Autor;
import com.biblioteca.apirest.repository.AutorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    public List<Autor> listaAutores(){

        return autorRepository.findAll();
    }

    @ApiOperation(value="Retorna um único autor com base no id")
    @GetMapping("/autor/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Autor listaAutorUnico(@PathVariable(value="id") long id){

        return autorRepository.findById(id);
    }

    @ApiOperation(value="Adiciona um novo autor")
    @PostMapping("/autor")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Autor salvaAutor(@RequestBody Autor autor) {

        return autorRepository.save(autor);
    }

    @ApiOperation(value="Deleta um autor com base no id")
    @DeleteMapping("/autor/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deletaAutor(@PathVariable(value="id") long id) {
        Autor autor = autorRepository.findById(id);
        autorRepository.delete(autor);
    }

    @ApiOperation(value="Atualiza um autor")
    @PutMapping("/autor")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Autor atualizaAutor(@RequestBody Autor autor) {

        return autorRepository.save(autor);
    }
}
