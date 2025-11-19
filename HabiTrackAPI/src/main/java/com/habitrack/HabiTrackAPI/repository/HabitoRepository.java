package com.habitrack.HabiTrackAPI.repository;

import com.habitrack.HabiTrackAPI.model.Habito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabitoRepository extends JpaRepository<Habito, Long> {
}
