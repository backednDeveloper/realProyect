package com.example.imtahan6.controller;

import com.example.imtahan6.dto.Position_Dto;
import com.example.imtahan6.entity.Positions;
import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.repository.Positions_Repository;
import com.example.imtahan6.service.Position_Interface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
public class Position_Controller {
    private final Position_Interface positionInterface;

    @GetMapping
    public List<Positions> getAllPosition() {
        return positionInterface.getAllPosition();
    }

    @GetMapping("/{id}")
    public Optional<Positions> getPositionFromId(@Valid @PathVariable Long id) throws NotFoundUserException {
        return positionInterface.getPositionFromId(id);
    }

    @PostMapping
    public Position_Dto createPosition(@Valid @RequestBody Position_Dto dto) throws AvailableException {
        return positionInterface.createPosition(dto);
    }

    @PutMapping("/{id}")
    public Position_Dto updatePosition(@Valid @PathVariable Long id, @Valid @RequestBody Position_Dto dto) throws NotFoundUserException {
        return positionInterface.updatePosition(id, dto);
    }

    @DeleteMapping("/id")
    public void deletePosition(@Valid @PathVariable Long id) throws NotFoundUserException {
        positionInterface.deletePosition(id);
    }
}
