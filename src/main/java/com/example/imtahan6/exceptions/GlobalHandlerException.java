package com.example.imtahan6.exceptions;

import com.example.imtahan6.entity.Exception_Body;
import com.example.imtahan6.errors.Field_Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;
import java.util.List;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handle(org.springframework.validation.BindException e){
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<Field_Error> errors = fieldErrors.stream()
                .map(error-> new Field_Error(error.getField(), error.getDefaultMessage()))
                .toList();
        Exception_Body body = new Exception_Body(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
