package com.biblioteca.apirest.controllers;

import com.biblioteca.apirest.models.Categoria;
import com.biblioteca.apirest.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public List<Categoria> listaCategorias(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/categoria/{id}")
    public Categoria listaCategoriaUnica(@PathVariable(value="id") long id){
        return categoriaRepository.findById(id);
    }

    @PostMapping("/categoria")
    public Categoria salvaCategoria(@RequestBody Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/categoria")
    public void deletaCategoria(@RequestBody Categoria categoria) {

        categoriaRepository.delete(categoria);
    }

    @PutMapping("/categoria")
    public Categoria atualizaCategoria(@RequestBody Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

}
