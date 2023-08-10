package com.example.imtahan6.service.impl;

import com.example.imtahan6.dto.LoginDto;
import com.example.imtahan6.entity.Users;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.exceptions.PasswordNotMatchers;
import com.example.imtahan6.repository.Users_Repository;
import com.example.imtahan6.service.LoginInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginInterface {
    private final Users_Repository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean passwordMatcher(LoginDto dto) throws NotFoundUserException {
        Users user = repository.findByEmail(dto.getEmail());
        if (user == null) {
            throw new NotFoundUserException("Cannot find username ");

        }
        return passwordEncoder.matches(dto.getPassword(), user.getPassword());
    }
}
