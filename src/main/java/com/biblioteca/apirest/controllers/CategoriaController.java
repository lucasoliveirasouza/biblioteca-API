package com.biblioteca.apirest.controllers;

import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.repository.CategoriaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Categoria> listaCategorias(){

        return categoriaRepository.findAll();
    }

    @ApiOperation(value="Retorna uma única categoria com base no id")
    @GetMapping("/categoria/{id}")
    public Categoria listaCategoriaUnica(@PathVariable(value="id") long id){

        return categoriaRepository.findById(id);
    }

    @ApiOperation(value="Adiciona uma nova categoria")
    @PostMapping("/categoria")
    public Categoria salvaCategoria(@RequestBody Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    @ApiOperation(value="Deleta uma categoria")
    @DeleteMapping("/categoria")
    public void deletaCategoria(@RequestBody Categoria categoria) {

        categoriaRepository.delete(categoria);
    }

    @ApiOperation(value="Atualiza uma categoria")
    @PutMapping("/categoria")
    public Categoria atualizaCategoria(@RequestBody Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

}
