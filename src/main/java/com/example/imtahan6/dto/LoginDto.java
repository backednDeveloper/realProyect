package com.example.imtahan6.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Data
@Getter
@Setter
public class LoginDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
