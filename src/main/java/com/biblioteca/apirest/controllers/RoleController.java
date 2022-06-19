package com.biblioteca.apirest.controllers;



import com.biblioteca.apirest.models.Editora;
import com.biblioteca.apirest.models.Role;
import com.biblioteca.apirest.repository.RoleRepository;
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
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @ApiOperation(value="Adiciona uma nova editora")
    @PostMapping("/role")
    public Role salvaEditora(@RequestBody Role role) {

        return roleRepository.save(role);
    }
}
