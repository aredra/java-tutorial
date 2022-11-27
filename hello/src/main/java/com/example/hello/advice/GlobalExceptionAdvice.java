package com.example.hello.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> authException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
