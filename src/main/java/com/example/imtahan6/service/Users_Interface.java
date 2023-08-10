package com.example.imtahan6.service;

import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.dto.Users_Dto;

import java.util.List;

public interface Users_Interface  {
    public List<Users_Dto> getAllUsers(Users_Dto dto);
    public Users_Dto getFromId(Users_Dto dto, Long id) throws NotFoundUserException;
    public Users_Dto createUser(Users_Dto dto) throws AvailableException;
    public Users_Dto updateUser(Users_Dto dto, Long id) throws NotFoundUserException;
    public void deleteUser(Long id) throws NotFoundUserException;
}
