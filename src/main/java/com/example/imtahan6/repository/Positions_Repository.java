package com.example.imtahan6.repository;

import com.example.imtahan6.entity.Positions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Positions_Repository extends JpaRepository<Positions, Long> {
    Optional<Positions> findById(Long id);
}
