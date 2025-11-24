package com.habitrack.HabiTrackAPI.service;

import com.habitrack.HabiTrackAPI.model.Habito;
import com.habitrack.HabiTrackAPI.model.Usuario;
import com.habitrack.HabiTrackAPI.repository.HabitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HabitoService {

    @Autowired
    private HabitoRepository habitoRepository;

    public Habito save(Habito habito) {
        return habitoRepository.save(habito);
    }

    public Habito buscarHabitoId(Long id) {
        return habitoRepository.findById(id).orElseThrow(()->new NoSuchElementException("Habito não encontrado"));
    }

    public List<Habito> listarTodosHabitos() {
        return habitoRepository.findAll();
    }

    public void deletarHabitoId(Long id) {
        habitoRepository.deleteById(id);
    }


}
