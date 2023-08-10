package com.example.imtahan6.repository;

import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Users_Repository extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long id);

    boolean existsByFirstName(String first_name);

    Users findByEmail(String username);

}
