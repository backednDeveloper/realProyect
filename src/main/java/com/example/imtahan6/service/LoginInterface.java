package com.example.imtahan6.service;

import com.example.imtahan6.dto.LoginDto;
import com.example.imtahan6.entity.Users;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.exceptions.PasswordNotMatchers;

public interface LoginInterface {
    public boolean passwordMatcher(LoginDto dto) throws NotFoundUserException;
}
