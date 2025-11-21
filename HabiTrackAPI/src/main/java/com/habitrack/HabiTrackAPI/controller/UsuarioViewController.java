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

    // ----- LISTAR TODOS -----
    @GetMapping("/usuarios/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "usuarios/listar";
    }

    // ----- FORMULÁRIO DE CADASTRO -----
    @GetMapping("/usuarios/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/usuarios/cadastrar";
    }

    // ----- ENVIAR FORM DE CADASTRO -----
    @PostMapping("/usuarios/enviar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    // ----- FORMULÁRIO DE EDIÇÃO -----
    @GetMapping("/usuarios/{id}/editar")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioId(id);
        model.addAttribute("usuario", usuario);
        return "/usuarios/editar";
    }

    // ----- ENVIAR FORM DE EDIÇÃO -----
    @PostMapping("/usuarios/{id}/editar")
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

        return "redirect:/usuarios/listar";
    }

    // ----- DELETE -----
    @GetMapping("/usuario/{id}/delete")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteusuarioId(id);
        return "redirect:/usuarios/listar";
    }


}
