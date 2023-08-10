package com.example.imtahan6.repository;

import com.example.imtahan6.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Company_Repository extends JpaRepository<Company, Long> {
    Optional<Company> findById(Long id);
    boolean existsByName(String name);
}
