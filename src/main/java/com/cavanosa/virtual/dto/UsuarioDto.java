package com.cavanosa.virtual.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioDto {
    @NotBlank
    private String NUsuario;
    @NotBlank
    @Email
    private Integer TContrasena;

    public String getNUsuario() {
        return NUsuario;
    }

    public void setNUsuario(String NUsuario) {
        this.NUsuario = NUsuario;
    }

    public Integer getTContrasena() {
        return TContrasena;
    }

    public void setTContrasena(Integer TContrasena) {
        this.TContrasena = TContrasena;
    }
}
