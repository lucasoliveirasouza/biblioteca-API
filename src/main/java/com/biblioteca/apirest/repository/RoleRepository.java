package com.biblioteca.apirest.repository;

import com.biblioteca.apirest.models.ERole;
import com.biblioteca.apirest.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
