package com.example.imtahan6.controller;

import com.example.imtahan6.dto.RegistrationDto;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.PasswordNotMatchers;
import com.example.imtahan6.service.RegistratinInterface;
import com.example.imtahan6.service.impl.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistratinInterface registratinInterface;

    @PostMapping
    public Users_Dto register(@Valid @RequestBody RegistrationDto dto)throws AvailableException, PasswordNotMatchers {
        return registratinInterface.register(dto);
    }
}
