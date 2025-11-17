package com.habitrack.HabiTrackAPI.service;


import com.habitrack.HabiTrackAPI.model.Usuario;
import com.habitrack.HabiTrackAPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario buscarUsuarioId(Long id){
        return usuarioRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Usuario não encontrado"));
    }
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public void deleteusuarioId(Long id){
        usuarioRepository.deleteById(id);
    }
}
