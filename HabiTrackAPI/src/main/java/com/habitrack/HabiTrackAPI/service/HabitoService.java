package com.habitrack.HabiTrackAPI.service;

import com.habitrack.HabiTrackAPI.model.Habito;
import com.habitrack.HabiTrackAPI.repository.HabitoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitoService {

    private final HabitoRepository repository;

    public HabitoService(HabitoRepository repository) {
        this.repository = repository;
    }

    public Habito salvar(Habito habito) {
        return repository.save(habito);
    }

    public List<Habito> listarTodos(){
        return repository.findAll();
    }

    public Habito buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Habito> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
