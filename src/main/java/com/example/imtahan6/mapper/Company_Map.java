package com.example.imtahan6.mapper;

import com.example.imtahan6.dto.Company_Dto;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.entity.Company;
import com.example.imtahan6.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(imports = LocalDate.class)
public interface Company_Map {

    Company toEntity(Company_Dto dto);

    @Mapping(target = "users_id", expression = "java(toLong(company.getUsersList()))")
    @Mapping(target = "companyAge", expression = "java(calculateAge(company.getCreate_date(), LocalDate.now()))")
    Company_Dto toDto(Company company);

    default List<Company_Dto> toDtoList(List<Company> companies) {
        List<Company_Dto> companyDtos = new ArrayList<>();
        for (Company company : companies) {
            companyDtos.add(toDto(company));
        }
        return companyDtos;
    }

    default @Pattern(regexp = "^(0?[1-9]|[12]\\d|3[01])\\.(0?[1-9]|1[0-2])\\.\\d{4}$") @NotBlank int calculateAge(LocalDate createDate, LocalDate currentDate) {
        if ((createDate != null) && (currentDate != null)) {
            return Period.between(createDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    default List<Long> toLong(List<Users> users) {
        if (users == null) {
            return null;
        }
        return users.stream()
                .map(users1 -> users1.getId()).collect(Collectors.toList());
    }

}
