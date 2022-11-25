package com.cavanosa.virtual.controller;

import com.cavanosa.virtual.dto.Mensaje;
import com.cavanosa.virtual.dto.UsuarioDto;
import com.cavanosa.virtual.entity.Usuario;
import com.cavanosa.virtual.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> lista(){
        List<Usuario> list = usuarioService.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{CUsuario}")
    public ResponseEntity<Usuario> getOne(@PathVariable("CUsuario") int CUsuario){
        if(!usuarioService.existsById(CUsuario))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioService.getOneById(CUsuario).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody UsuarioDto usuarioDto, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNUsuario(usuarioDto.getNUsuario()))
            return new ResponseEntity(new Mensaje("ya existe ese nombre"), HttpStatus.BAD_REQUEST);
        if(usuarioService.exixtsByTContrasena(usuarioDto.getTContrasena()))
            return new ResponseEntity(new Mensaje("ya existe ese email"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(usuarioDto.getNUsuario(), usuarioDto.getTContrasena());
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);

    }

    @PutMapping("/actualizar/{CUsuario}")
    public ResponseEntity<?> actualizar(@Valid @RequestBody UsuarioDto usuarioDto, BindingResult bindingResult, @PathVariable("CUsuario") int CUsuario){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        if(!usuarioService.existsById(CUsuario))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(usuarioService.existsByNUsuario(usuarioDto.getNUsuario()) && usuarioService.getOneByNUsuario(usuarioDto.getNUsuario()).get().getCUsuario() !=CUsuario)
            return new ResponseEntity(new Mensaje("ya existe ese nombre"), HttpStatus.BAD_REQUEST);
        if(usuarioService.exixtsByTContrasena(usuarioDto.getTContrasena()) && usuarioService.getOneByTContrasena(usuarioDto.getTContrasena()).get().getCUsuario() !=CUsuario)
            return new ResponseEntity(new Mensaje("ya existe ese email"), HttpStatus.BAD_REQUEST);
        Usuario usuario = usuarioService.getOneById(CUsuario).get();
        usuario.setNUsuario(usuarioDto.getNUsuario());
        usuario.setTContrasena(usuarioDto.getTContrasena());
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{CUsuario}")
    public ResponseEntity<?> borrar(@PathVariable("CUsuario") int CUsuario){
        if(!usuarioService.existsById(CUsuario))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        usuarioService.delete(CUsuario);
        return new ResponseEntity(new Mensaje("usuario eliminado"), HttpStatus.OK);
    }
}
