package com.habitrack.HabiTrackAPI.controller;

import com.habitrack.HabiTrackAPI.model.Habito;
import com.habitrack.HabiTrackAPI.model.Usuario;
import com.habitrack.HabiTrackAPI.repository.HabitoRepository;
import com.habitrack.HabiTrackAPI.service.HabitoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitoController {

    @Autowired
    private HabitoRepository habitoRepository;
    @Autowired
    private HabitoService habitoService;

    @PostMapping("/habito")
    @ResponseStatus(HttpStatus.CREATED)
    public Habito cadastrarHabito(@RequestBody Habito habito){
        Habito habitoCadastrado = habitoRepository.save(habito);
        return habitoCadastrado;
    }

    @PutMapping("/habito/{id}/editar")
    public Habito editarHabito(@RequestBody Habito habitoAtualizado, @PathVariable Long id){
        Habito habitoSalvo = habitoService.buscarHabitoId(id);
        habitoSalvo.setNome(habitoAtualizado.getNome());
        habitoSalvo.setCategoria(habitoAtualizado.getCategoria());
        habitoSalvo.setDescricao(habitoAtualizado.getDescricao());
        habitoSalvo.setObjetivo(habitoAtualizado.getObjetivo());
        return habitoService.save(habitoSalvo);
    }

    @GetMapping("/habito/{id}")
    public Habito buscarHabitoId(@PathVariable Long id){
        return habitoService.buscarHabitoId(id);
    }

    @DeleteMapping("/habito/{id}/delete")
    public void deleteHabitoId(@PathVariable Long id){
        habitoRepository.deleteById(id);
    }

}
