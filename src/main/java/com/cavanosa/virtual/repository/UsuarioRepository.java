package com.cavanosa.virtual.repository;

import com.cavanosa.virtual.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNUsuario(String NUsuario);
    Optional<Usuario> findByTContrasena(Integer TContrasena);
    boolean existsByNUsuario(String NUsuario);
    boolean existsByTContrasena(Integer TContrasena);
}
