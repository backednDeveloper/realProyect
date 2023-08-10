package com.example.imtahan6.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class User_Position_Dto {
    private Long id;
    @Pattern(regexp = "\\d", message = "Please use only numbers")
    @NotNull
    private Long users_id;
    @Pattern(regexp = "\\d", message = "Please use only numbers")
    @NotNull
    private Long positions_id;
}
