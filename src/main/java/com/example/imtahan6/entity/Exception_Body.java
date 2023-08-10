package com.example.imtahan6.entity;

import com.example.imtahan6.errors.Field_Error;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Exception_Body {
    public List<Field_Error> fieldErrors;
}
