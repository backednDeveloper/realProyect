package com.example.imtahan6.service.impl;

import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.entity.Users;
import com.example.imtahan6.mapper.Users_Map;
import com.example.imtahan6.repository.Users_Repository;
import com.example.imtahan6.service.Users_Interface;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class Users_Service implements Users_Interface {
    private final Users_Map map;
    private final Users_Repository repository;
//    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public List<Users_Dto> getAllUsers(Users_Dto dto) {
        List<Users> usersDto = repository.findAll();
        return map.mapUsersToDtoList(usersDto);
    }

    @Transactional
    @Override
    public Users_Dto getFromId(Users_Dto dto, Long id) throws NotFoundUserException {
        Users searchUser = repository.findById(id).get();
        if (searchUser == null) {
            throw new NotFoundUserException("This account is not available");
        }
        return map.toDto(searchUser);
    }

    @Transactional
    @Override
    public Users_Dto createUser(Users_Dto dto) throws AvailableException {
        if (repository.existsByFirstName(dto.getFirstName())) {
            throw new AvailableException("This user has been available");
        }
        return map.toDto(repository.save(map.toEntity(dto)));
    }

    @Transactional
    @Override
    public Users_Dto updateUser(Users_Dto dto, Long id) throws NotFoundUserException {
        Optional<Users> searchUser = repository.findById(id);
        if (searchUser.isPresent()) {
            throw new NotFoundUserException("This account is not available");
        }
        Users_Dto usersDto = new Users_Dto();
        usersDto.setCompany_id(dto.getCompany_id());
        usersDto.setFirstName(dto.getFirstName());
        usersDto.setLast_name(dto.getLast_name());
        usersDto.setAge(dto.getAge());
        usersDto.setId(dto.getId());

        return map.toDto(repository.save(map.toEntity(usersDto)));
    }

    @Transactional
    @Override
    public void deleteUser(Long id) throws NotFoundUserException {
        Users searchUser = repository.findById(id).get();
        if (searchUser == null) {
            throw new NotFoundUserException("This account is not available");
        }
        repository.delete(searchUser);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<String> authorities = Arrays.asList("READ", "SEARCH", "CREATE", "UPDATE", "DELETE");
//        authorities.stream()
//                .map(role -> "ROLE_" + role)
//                .collect(Collectors.toList());
//
//        return User.withUsername("user")
//                .password("123456")
//                .authorities(String.valueOf(authorities))
//                .accountLocked(false)
//                .accountExpired(false)
//                .credentialsExpired(false)
//                .build();
//    }
}
