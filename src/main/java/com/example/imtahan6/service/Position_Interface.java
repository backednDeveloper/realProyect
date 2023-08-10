package com.example.imtahan6.service;

import com.example.imtahan6.dto.Position_Dto;
import com.example.imtahan6.entity.Positions;
import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.NotFoundUserException;

import java.util.List;
import java.util.Optional;

public interface Position_Interface {
    public List<Positions> getAllPosition();
    public Optional<Positions> getPositionFromId(Long id) throws NotFoundUserException;
    public Position_Dto createPosition(Position_Dto dto) throws AvailableException;
    public Position_Dto updatePosition(Long id, Position_Dto dto) throws NotFoundUserException;
    public void deletePosition(Long id) throws NotFoundUserException;
}
