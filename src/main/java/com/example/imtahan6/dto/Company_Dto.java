package com.example.imtahan6.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class Company_Dto {

    private Long id;
    @Pattern(regexp = "[A-Za-z]+", message = "Please use only words")
    @NotBlank
    private String name;
    @Pattern(regexp = "^(0?[1-9]|[12]\\d|3[01])\\.(0?[1-9]|1[0-2])\\.\\d{4}$")
    @NotBlank
    private LocalDate create_date;
    @NotBlank
    public int companyAge;
    @NotBlank
    private List<Long> users_id;



}
