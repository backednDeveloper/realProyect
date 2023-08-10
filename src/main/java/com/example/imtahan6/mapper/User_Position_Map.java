package com.example.imtahan6.mapper;

import com.example.imtahan6.dto.User_Position_Dto;
import com.example.imtahan6.entity.User_Position;
import com.example.imtahan6.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface User_Position_Map {
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "positions", ignore = true)
    User_Position toEntity(User_Position_Dto dto);

    @Mapping(target = "users_id", expression = "java(entity.getUsers().getId())")
    @Mapping(target = "positions_id", expression = "java(entity.getPositions().getId())")
    User_Position_Dto toDto(User_Position entity);
}
