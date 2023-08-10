package com.example.imtahan6.mapper;

import com.example.imtahan6.dto.Company_Dto;
import com.example.imtahan6.dto.RegistrationDto;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.entity.Company;
import com.example.imtahan6.entity.Users;
import com.example.imtahan6.repository.Company_Repository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Mapper(imports = LocalDate.class)
public abstract class Users_Map {
    @Autowired
    protected PasswordEncoder encoder;
    protected Company_Repository repository;

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "company", expression = "java(toComapny(dto.getId()))")
    public abstract Users toEntity(Users_Dto dto);

    @Mapping(target = "company_id", expression = "java(tolong(users.getCompany()))")
    @Mapping(target = "age", expression = "java(calculateAge(users.getBirthdate(), LocalDate.now() ))")
    public abstract Users_Dto toDto(Users users);


    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "enabled", constant = "false")
    @Mapping(target = "company", expression = "java(toComapny(dto.getId()))")
    @Mapping(target = "password", expression = "java(encoder.encode(dto.getPassword()))")
    public abstract Users fromRegistrationDtoToUser(RegistrationDto dto);

    public Long tolong(Company company) {
        return company.getId();
    }

    public Company toComapny(Long id) {
        Company company = new Company();
        company.setId(id);
        return company;
    }

    public List<Users_Dto> mapUsersToDtoList(List<Users> usersList) {
        List<Users_Dto> dtoList = new ArrayList<>();
        for (Users user : usersList) {
            dtoList.add(toDto(user));
        }
        return dtoList;
    }

    public @Pattern(regexp = "^(0?[1-9]|[12]\\d|3[01])\\.(0?[1-9]|1[0-2])\\.\\d{4}$") @NotBlank int calculateAge(LocalDate birthDay, LocalDate currentDate) {
        if ((birthDay != null) && (currentDate != null)) {
            return Period.between(birthDay, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
