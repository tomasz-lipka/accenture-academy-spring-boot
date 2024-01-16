package com.accenture.academy.leader;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class LeaderGlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(LeaderNotFoundException.class)
    String leaderNotFoundExceptionHandler(LeaderNotFoundException ex){
        return ex.getMessage();
    }
}
