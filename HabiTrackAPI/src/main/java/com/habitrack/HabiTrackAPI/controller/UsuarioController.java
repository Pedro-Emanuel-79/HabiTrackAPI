package com.habitrack.HabiTrackAPI.controller;


import com.habitrack.HabiTrackAPI.model.Usuario;
import com.habitrack.HabiTrackAPI.repository.UsuarioRepository;
import com.habitrack.HabiTrackAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrarusuario(@RequestBody Usuario usuario) {
        Usuario usuarioCadastrado = usuarioService.save(usuario);
        return usuarioCadastrado;
    }

    @PutMapping("/usuario/{id}/editar")
    public Usuario editarusuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuarioSalvo = usuarioService.buscarUsuarioId(id);
        usuarioSalvo.setNome(usuarioAtualizado.getNome());
        usuarioSalvo.setSobrenome(usuarioAtualizado.getSobrenome());
        usuarioSalvo.setDataNascimento(usuarioAtualizado.getDataNascimento());
        usuarioSalvo.setCpf(usuarioAtualizado.getCpf());
        usuarioSalvo.setEmail(usuarioAtualizado.getEmail());
        usuarioSalvo.setTelefone(usuarioAtualizado.getTelefone());
        usuarioSalvo.setSenha(usuarioAtualizado.getSenha());
        usuarioSalvo.setEndereco(usuarioAtualizado.getEndereco());
        usuarioSalvo.setOcupacao(usuarioAtualizado.getOcupacao());
        return usuarioService.save(usuarioSalvo);
    }

    @GetMapping("/usuario/{id}")
    public Usuario buscarUsuarioId(@PathVariable Long id){
        return usuarioService.buscarUsuarioId(id);
    }

    @DeleteMapping("/usuario/{id}/delete")
    public void deleteusuarioId(@PathVariable Long id){
        usuarioService.deleteusuarioId(id);    }

}
