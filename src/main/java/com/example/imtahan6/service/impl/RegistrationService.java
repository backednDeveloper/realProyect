package com.example.imtahan6.service.impl;

import com.example.imtahan6.dto.RegistrationDto;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.entity.Users;
import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.PasswordNotMatchers;
import com.example.imtahan6.mapper.Users_Map;
import com.example.imtahan6.repository.Users_Repository;
import com.example.imtahan6.service.RegistratinInterface;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService implements RegistratinInterface {
    private final Users_Map map;
    private final Users_Repository repository;

    @Override
    public Users_Dto register(RegistrationDto dto) throws AvailableException, PasswordNotMatchers {
        Optional<Users> searchUser = repository.findById(map.fromRegistrationDtoToUser(dto).getId());
        if (searchUser.isPresent()) {
            throw new AvailableException("This user is available");
        }
        if (dto.getPassword().equals(dto.getCheckPassword())) {
            repository.save(map.fromRegistrationDtoToUser(dto));
        }
        else {
            throw new PasswordNotMatchers("Password is not matcher");
        }
        return map.toDto(map.fromRegistrationDtoToUser(dto));
    }
}

