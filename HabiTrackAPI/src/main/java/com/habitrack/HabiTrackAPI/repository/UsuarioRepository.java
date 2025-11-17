package com.habitrack.HabiTrackAPI.repository;

import com.habitrack.HabiTrackAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
