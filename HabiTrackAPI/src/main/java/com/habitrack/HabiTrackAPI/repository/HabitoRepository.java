package com.habitrack.HabiTrackAPI.repository;

import com.habitrack.HabiTrackAPI.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabitoRepository extends JpaRepository<Habito, Long> {
    @Modifying
    @Query("DELETE FROM Habito h WHERE h.usuario.id = :usuarioId")
    void deleteByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT h FROM Habito h WHERE h.usuario.id = :usuarioId")
    List<Habito> findByUsuarioId(@Param("usuario_id") Long usuarioId);
}
