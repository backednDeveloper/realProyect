package com.example.imtahan6.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class Position_Dto {

    @NotBlank
    private Long id;
    @Pattern(regexp = "[A-Za-z]+", message = "Please use only words")
    @NotBlank
    private String name;
    @Pattern(regexp = "\\d", message = "Please use only numbers")
    @NotBlank
    private List<Long> users_id;
}
