package com.cavanosa.virtual.service;

import com.cavanosa.virtual.entity.Usuario;
import com.cavanosa.virtual.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getOneById(int CUsuario){
        return usuarioRepository.findById(CUsuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getOneByNUsuario(String NUsuario){
        return usuarioRepository.findByNUsuario(NUsuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getOneByTContrasena(Integer TContrasena){
        return usuarioRepository.findByTContrasena(TContrasena);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void delete(int CUsuario){
        usuarioRepository.deleteById(CUsuario);
    }

    public boolean existsById(int CUsuario){
        return usuarioRepository.existsById(CUsuario);
    }

    public boolean existsByNUsuario(String NUsuario){
        return usuarioRepository.existsByNUsuario(NUsuario);
    }

    public boolean exixtsByTContrasena(Integer TContrasena){
        return usuarioRepository.existsByTContrasena(TContrasena);
    }
}
