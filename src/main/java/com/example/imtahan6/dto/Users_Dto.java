package com.example.imtahan6.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Users_Dto {
    private Long id;
    @Pattern(regexp = "[A-Za-z]+", message = "Please use only words")
    @NotNull
    private String firstName;
    @Pattern(regexp = "[A-Za-z]+", message = "Please use only words")
    @NotNull
    private String last_name;
//    @Pattern(regexp = "\\d", message = "Please use only numbers")
    @NotNull
    private Long company_id;
    @Pattern(regexp = "^(0?[1-9]|[12]\\d|3[01])\\.(0?[1-9]|1[0-2])\\.\\d{4}$")
    @NotNull
    private int age;
}
