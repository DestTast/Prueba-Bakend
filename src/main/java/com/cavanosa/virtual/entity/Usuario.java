package com.cavanosa.virtual.entity;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CUsuario;

    @NotNull
    @Column( length = 100)
    private String NUsuario;

    @NotNull
    @Column( length = 100)
    private Integer TContrasena;


    public Usuario() {
    }

    public Usuario(@NotNull String NUsuario, @NotNull Integer TContrasena) {
        this.NUsuario = NUsuario;
        this.TContrasena = TContrasena;
    }


    public Integer getCUsuario() {
        return CUsuario;
    }



    public void setCUsuario(Integer CUsuario) {
        this.CUsuario = CUsuario;
    }

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
