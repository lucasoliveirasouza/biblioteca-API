package com.biblioteca.apirest.controllers;

import com.biblioteca.apirest.models.Editora;
import com.biblioteca.apirest.repository.EditoraRepository;
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
public class EditoraController {

    @Autowired
    EditoraRepository editoraRepository;

    @ApiOperation(value="Retorna uma lista com todos os editoras")
    @GetMapping("/editoras")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Editora> listaEditoras(){

        return editoraRepository.findAll();
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation(value="Retorna uma única editora com base no id")
    @GetMapping("/editora/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    public Editora listaEditoraUnico(@PathVariable(value="id") long id){

        return editoraRepository.findById(id);
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @ApiOperation(value="Adiciona uma nova editora")
    @PostMapping("/editora")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    public Editora salvaEditora(@RequestBody Editora editora) {

        return editoraRepository.save(editora);
    }

    @ApiOperation(value="Deleta uma editora com base no id")
    @DeleteMapping("/editora/{id}")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public void deletaEditora(@PathVariable(value="id") long id) {
        Editora editora = editoraRepository.findById(id);
        editoraRepository.delete(editora);
    }

    @ApiOperation(value="Atualiza uma editora")
    @PutMapping("/editora")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Editora atualizaEditora(@RequestBody Editora editora) {

        return editoraRepository.save(editora);
    }
}
