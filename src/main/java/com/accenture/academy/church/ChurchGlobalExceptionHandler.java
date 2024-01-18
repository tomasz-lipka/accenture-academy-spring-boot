package com.accenture.academy.church;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ChurchGlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(BindException.class)
    List<String> bindExceptionHandler(BindException bindException){
        List<FieldError> fieldErrors = bindException.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors){
            errors.add(fieldError.getDefaultMessage());
        }
        return errors;
    }
}
