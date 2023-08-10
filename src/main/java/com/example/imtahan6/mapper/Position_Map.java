package com.example.imtahan6.mapper;

import com.example.imtahan6.dto.Position_Dto;
import com.example.imtahan6.entity.Positions;
import com.example.imtahan6.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface Position_Map {

    Positions toEntity(Position_Dto dto);

    @Mapping(target = "users_id", expression = "java(toLong(positions.getUsers()))")
    Position_Dto toDto(Positions positions);

    default List<Long> toLong(List<Users> users) {
        if (users == null) {
            return null;
        }
        return  users.stream()
                .map(users1 -> users1.getId())
                .collect(Collectors.toList());
    }
}

