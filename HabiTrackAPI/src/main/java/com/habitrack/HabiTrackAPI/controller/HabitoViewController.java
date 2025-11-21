package com.habitrack.HabiTrackAPI.controller;

import com.habitrack.HabiTrackAPI.model.Habito;
import com.habitrack.HabiTrackAPI.model.Usuario;
import com.habitrack.HabiTrackAPI.service.HabitoService;
import com.habitrack.HabiTrackAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HabitoViewController {
    @Autowired
    private HabitoService habitoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/habito/listar")
    public String listarHabito(Model model) {
        model.addAttribute("habitos", habitoService.listarTodosHabitos());
        return "/templates/habito/listar";
    }

    @GetMapping("/habito/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("habito", new Habito());
        model.addAttribute("usuario", usuarioService.listarUsuarios());
        return "/templates/habito/cadastrar";
    }

    @PostMapping("/habito/cadastrar")
    public String cadastrar(@ModelAttribute Habito habito) {

        if (habito.getUsuario() != null && !habito.getUsuario().equals("")) {
            Usuario usuario = usuarioService.buscarUsuarioId(habito.getUsuario().getId());
            habito.setUsuario(usuario);
        }

        habitoService.save(habito);
        return "redirect:/templates/habito/listar";
    }

    @GetMapping("/habito/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Habito habito = habitoService.buscarHabitoId(id);
        model.addAttribute("habito", habito);
        model.addAttribute("usuario", usuarioService.listarUsuarios());
        return "/templates/habito/editar";
    }

    @PostMapping("/habito/{id}/editar")
    public String editarHabito(@PathVariable Long id, @ModelAttribute Habito habitoAtualizar) {
        Habito habito = habitoService.buscarHabitoId(id);
        habito.setNome(habitoAtualizar.getNome());
        habito.setCategoria(habitoAtualizar.getCategoria());
        habito.setDescricao(habitoAtualizar.getDescricao());
        habito.setObjetivo(habitoAtualizar.getObjetivo());

        if (habitoAtualizar.getUsuario() != null && !habitoAtualizar.getUsuario().equals("")) {
            Usuario usuario = usuarioService.buscarUsuarioId(habitoAtualizar.getUsuario().getId());
            habito.setUsuario(usuario);
        }

        habitoService.save(habito);
        return "redirect:/templates/habito/listar";
    }

    @GetMapping("/habito/{id}/delete")
    public String deleteHabito(@PathVariable Long id){
        habitoService.deletarHabitoId(id);
        return "redirect:/templates/habito/listar";
    }
}
