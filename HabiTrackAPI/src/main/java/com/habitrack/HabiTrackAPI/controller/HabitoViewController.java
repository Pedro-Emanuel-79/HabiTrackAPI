package com.habitrack.HabiTrackAPI.controller;

import com.habitrack.HabiTrackAPI.model.Habito;
import com.habitrack.HabiTrackAPI.model.Usuario;
import com.habitrack.HabiTrackAPI.service.HabitoService;
import com.habitrack.HabiTrackAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HabitoViewController {
    @Autowired
    private HabitoService habitoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/habito/listar")
    public String listar(Model model) {
        List<Habito> habitos = habitoService.findAll();
        model.addAttribute("habitos", habitos);
        return "listaHabito";
    }


    @GetMapping("/habito/cadastrar")
    public String mostrarFormularioCadastro(@RequestParam Long usuarioId, Model model) {
        Habito habito = new Habito();

        model.addAttribute("usuarioId", usuarioId);
        model.addAttribute("habito", habito);

        return "habito";
    }


    @PostMapping("/habito/cadastrar")
    public String cadastrar(@ModelAttribute Habito habito, @RequestParam Long usuarioId) {

        // Busca o usuário pelo ID
        Usuario usuario = usuarioService.buscarUsuarioId(usuarioId);

        // Associa o usuário ao hábito
        habito.setUsuario(usuario);

        // Salva
        habitoService.save(habito);

        return "redirect:/habito/listar";
    }


    @GetMapping("/habito/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Habito habito = habitoService.buscarHabitoId(id);
        model.addAttribute("habito", habito);
        model.addAttribute("usuarioId", usuarioService.listarUsuarios());
        return "editarHabito";
    }

    @PostMapping("/habito/{id}/editar")
    public String editarHabito(@PathVariable Long id, @ModelAttribute Habito habitoAtualizar) {
        Habito habito = habitoService.buscarHabitoId(id);
        habito.setNome(habitoAtualizar.getNome());
        habito.setCategoria(habitoAtualizar.getCategoria());
        habito.setDescricao(habitoAtualizar.getDescricao());
        habito.setObjetivo(habitoAtualizar.getObjetivo());

        if (habitoAtualizar.getUsuario() != null) {

            Usuario usuario = usuarioService.buscarUsuarioId(
                    habitoAtualizar.getUsuario().getId()
            );

            habito.setUsuario(usuario);
        }

        habitoService.save(habito);
        return "redirect:/habito/listar";
    }

    @GetMapping("/habito/{id}/delete")
    public String deleteHabito(@PathVariable Long id){
        habitoService.deletarHabitoId(id);
        return "redirect:/habito/listar";
    }
}
