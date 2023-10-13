package com.OneToMany.expocicion.controllers;

import com.OneToMany.expocicion.exceptions.ObjectNotFoundExceptions;
import com.OneToMany.expocicion.exceptions.RepeatFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionsController {

    Map<String, String> errors;
    @ExceptionHandler
    public Map<String, String> handleRepeatUserFoundException(RepeatFoundException rufe){
        errors = new HashMap<>();
        errors.put("message", rufe.getMessage());
        return errors;
    }

    @ExceptionHandler
    public Map<String, String> handleObjectNotFoundException(ObjectNotFoundExceptions onfe){
        errors = new HashMap<>();
        errors.put("message", onfe.getMessage());
        return errors;
    }
}
