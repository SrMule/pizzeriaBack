package com.pizzeria.pizzeriaback.Controllers;

import org.springframework.web.bind.annotation.RestController;
import com.pizzeria.pizzeriaback.Models.Usuario;
import com.pizzeria.pizzeriaback.Services.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioRestController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/iniciosesion/{correo}/{contraseña}")
    public Usuario inicioSesion(@PathVariable String correo,@PathVariable String contraseña) {
        return usuarioService.inicioSesion(correo, contraseña);
    }

    @PostMapping("/registro")
    public Usuario registro(@RequestBody Usuario usuario) {
        return usuarioService.registro(usuario);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizar(id, usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar((id));
    }
    
    
}
