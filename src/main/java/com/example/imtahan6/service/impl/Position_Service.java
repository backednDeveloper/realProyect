package com.example.imtahan6.service.impl;

import com.example.imtahan6.dto.Position_Dto;
import com.example.imtahan6.entity.Positions;
import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.mapper.Position_Map;
import com.example.imtahan6.repository.Positions_Repository;
import com.example.imtahan6.service.Position_Interface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Position_Service implements Position_Interface {
    private final Position_Map map;
    private final Positions_Repository repository;

    @Override
    public List<Positions> getAllPosition() {
        return repository.findAll();
    }

    @Override
    public Optional<Positions> getPositionFromId(Long id) throws NotFoundUserException {
        Optional<Positions> searchPosition = repository.findById(id);
        if(searchPosition.isEmpty()){
            throw new NotFoundUserException("This user is not availabel");
        }
        return repository.findById(id);
    }

    @Override
    public Position_Dto createPosition(Position_Dto dto) throws AvailableException {
        Optional<Positions> searchPosition = repository.findById(dto.getId());
        if(searchPosition.isPresent()){
            throw new AvailableException("This position is available");
        }
        return map.toDto(repository.save(map.toEntity(dto)));
    }

    @Override
    public Position_Dto updatePosition(Long id, Position_Dto dto) throws NotFoundUserException {
        Optional<Positions> searchPosition = repository.findById(dto.getId());
        if (searchPosition.isEmpty()){
            throw new NotFoundUserException("This position not found");
        }
        Position_Dto dto1 = new Position_Dto();
        dto1.setName(dto.getName());
        dto1.setUsers_id(dto.getUsers_id());
        dto1.setId(dto.getId());
        return map.toDto(repository.save(map.toEntity(dto)));

    }

    @Override
    public void deletePosition(Long id) throws NotFoundUserException {
        Positions searchPosition = repository.findById(id).get();
        if (searchPosition == null){
            throw new NotFoundUserException("This position not found");
        }
        repository.delete(searchPosition);
    }
}
