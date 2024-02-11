package com.pizzeria.pizzeriaback.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pizzeria.pizzeriaback.Models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
    Optional<Usuario> findByUsuarioCorreo(String usuarioCorreo);
}
