package com.pizzeria.pizzeriaback.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "nombre")
    private String usuarioNombre;

    @Column(name = "correo", unique = true)
    private String usuarioCorreo;

    @Column(name = "numero_telefono")
    private String usuarioNumeroTelefono;

    @Column(name = "contrasena")
    private String usuarioContrasena;

}
