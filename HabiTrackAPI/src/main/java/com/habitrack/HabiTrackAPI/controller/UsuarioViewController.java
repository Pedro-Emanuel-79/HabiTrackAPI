package com.habitrack.HabiTrackAPI.controller;


import org.springframework.ui.Model;
import com.habitrack.HabiTrackAPI.model.Usuario;
import com.habitrack.HabiTrackAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsuarioViewController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuario/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "listaUsuario";
    }


    @GetMapping("/usuario/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario";
    }


    @PostMapping("/usuario/enviar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/listar";

    }


    @GetMapping("/usuario/{id}/editar")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioId(id);
        model.addAttribute("usuario", usuario);
        return "editarUsuario";
    }


    @PostMapping("/usuario/{id}/editar")
    public String editarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuarioAtualizado) {
        Usuario usuario = usuarioService.buscarUsuarioId(id);

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setSobrenome(usuarioAtualizado.getSobrenome());
        usuario.setDataNascimento(usuarioAtualizado.getDataNascimento());
        usuario.setCpf(usuarioAtualizado.getCpf());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setTelefone(usuarioAtualizado.getTelefone());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setEndereco(usuarioAtualizado.getEndereco());
        usuario.setOcupacao(usuarioAtualizado.getOcupacao());

        usuarioService.save(usuario);

        return "redirect:/usuario/listar";
    }


    @GetMapping("/usuario/{id}/delete")
    public String deleteUsuarioId(@PathVariable Long id) {
        usuarioService.deleteusuarioId(id);
        return "redirect:/usuario/listar";
    }


}
