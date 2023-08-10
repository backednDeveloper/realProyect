package com.example.imtahan6.controller;

import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.service.Users_Interface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class User_Controller {
    private final Users_Interface usersInterface;

    @GetMapping
    public List<Users_Dto> getAllUsers(@Valid @RequestBody Users_Dto dto) {
        return usersInterface.getAllUsers(dto);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("!hasAuthority('ROLE_READ')")
    public Users_Dto getFromId(@Valid @RequestBody Users_Dto dto, @Valid @PathVariable Long id) throws NotFoundUserException {
        return usersInterface.getFromId(dto, id);
    }

    @PostMapping
    public Users_Dto createUser(@Valid @RequestBody Users_Dto dto) throws AvailableException {
        return usersInterface.createUser(dto);
    }

    @PutMapping("/{id}")
    public Users_Dto updateUser(@Valid @RequestBody Users_Dto dto, @Valid @PathVariable Long id) throws NotFoundUserException {
        return usersInterface.updateUser(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@Valid @PathVariable Long id) throws NotFoundUserException {
        usersInterface.deleteUser(id);
    }
}
