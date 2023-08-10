package com.example.imtahan6.service;

import com.example.imtahan6.dto.RegistrationDto;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.PasswordNotMatchers;

public interface RegistratinInterface {
    public Users_Dto register(RegistrationDto dto)throws AvailableException, PasswordNotMatchers;
}
