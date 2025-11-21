package com.habitrack.HabiTrackAPI.controller;

import com.habitrack.HabiTrackAPI.model.Habito;
import com.habitrack.HabiTrackAPI.service.HabitoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitos")
public class HabitoController {

    private final HabitoService habitoService;

    public HabitoController(HabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @PostMapping
    public Habito criarHabito(@RequestBody Habito habito) {
        return habitoService.salvar(habito);
    }

    @GetMapping
    public List<Habito> listarTodos(){
        return habitoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Habito buscarPorId(@PathVariable Long id) {
        return habitoService.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Habito> listarHabitosDoUsuario(@PathVariable Long usuarioId) {
        return habitoService.listarPorUsuario(usuarioId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        habitoService.deletar(id);
    }
}
