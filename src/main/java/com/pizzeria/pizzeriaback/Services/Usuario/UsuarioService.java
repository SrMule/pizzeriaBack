package com.pizzeria.pizzeriaback.Services.Usuario;

import com.pizzeria.pizzeriaback.Models.Usuario;

public interface UsuarioService{

    Usuario inicioSesion(String correo, String contraseña);
    Usuario registro(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
}
