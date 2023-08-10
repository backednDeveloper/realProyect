package com.example.imtahan6.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@Data
public class RegistrationDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String checkPassword;
    @Pattern(regexp = "[A-Za-z]+", message = "Please use only words")
    @NotBlank
    private String firstName;
    @Pattern(regexp = "[A-Za-z]+", message = "Please use only words")
    @NotBlank
    private String last_name;
    @NotBlank
    private LocalDate birthdate;
    @NotBlank
    private String username;
    @NotNull
    private Long company_id;

}
