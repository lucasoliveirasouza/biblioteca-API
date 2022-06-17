package com.biblioteca.apirest.controllers;

import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.repository.CategoriaRepository;
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
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @ApiOperation(value="Retorna uma lista com todas categorias")
    @GetMapping("/categorias")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Categoria> listaCategorias(){

        return categoriaRepository.findAll();
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation(value="Retorna uma única categoria com base no id")
    @GetMapping("/categoria/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    public Categoria listaCategoriaUnica(@PathVariable(value="id") long id){

        return categoriaRepository.findById(id);
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation(value="Adiciona uma nova categoria")
    @PostMapping("/categoria")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    public Categoria salvaCategoria(@RequestBody Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation(value="Deleta uma categoria  com base no id")
    @DeleteMapping("/categoria/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    public void deletaCategoria(@PathVariable(value="id") long id) {
        Categoria categoria = categoriaRepository.findById(id);
        categoriaRepository.delete(categoria);
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation(value="Atualiza uma categoria")
    @PutMapping("/categoria")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    public Categoria atualizaCategoria(@RequestBody Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

}
