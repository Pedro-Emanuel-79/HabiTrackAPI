package com.habitrack.HabiTrackAPI.repository;

import com.habitrack.HabiTrackAPI.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitoRepository extends JpaRepository<Habito, Long>{

    List<Habito> findByUsuarioId(Long usuarioId);
}
