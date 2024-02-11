package com.pizzeria.pizzeriaback.Services.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pizzeria.pizzeriaback.Models.Usuario;
import com.pizzeria.pizzeriaback.Repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario inicioSesion(String correo, String contraseña) {
        if (!(usuarioRepository.findByUsuarioCorreo(correo).isEmpty())) {
            Usuario usuarioValidado = usuarioRepository.findByUsuarioCorreo(correo).get();
            if (usuarioValidado.getUsuarioContrasena().equals(contraseña)) {
                return usuarioValidado;
            }
            return null;
        }
        return null;
    }

    @Override
    public Usuario registro(Usuario usuario) {
        if (usuarioRepository.findByUsuarioCorreo(usuario.getUsuarioCorreo()).isEmpty()) {
            usuarioRepository.save(usuario);
            return usuario;
        }
        return null;
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuarioActualizado = usuarioRepository.findById(id).get();
            usuarioActualizado.setUsuarioNombre(usuario.getUsuarioNombre());
            usuarioActualizado.setUsuarioCorreo(usuario.getUsuarioCorreo());
            usuarioActualizado.setUsuarioNumeroTelefono(usuario.getUsuarioNumeroTelefono());
            usuarioActualizado.setUsuarioContrasena(usuario.getUsuarioContrasena());
            return usuarioActualizado;
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    
}
