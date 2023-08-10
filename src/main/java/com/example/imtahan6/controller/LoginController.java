package com.example.imtahan6.controller;

import com.example.imtahan6.dto.LoginDto;
import com.example.imtahan6.entity.Users;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.exceptions.PasswordNotMatchers;
import com.example.imtahan6.service.LoginInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final LoginInterface loginInterface;
    @GetMapping
    public boolean passwordMatcher(@Valid @RequestBody LoginDto dto) throws NotFoundUserException {
        return loginInterface.passwordMatcher(dto);
    }

}
