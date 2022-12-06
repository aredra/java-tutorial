package com.example.goodtaste.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> baseApiControllerException(Exception e) {
        log.error(">>>>>>>>>>>>>>>>>> Name: {}, Message: {}",
                e.getClass().getName(), e.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    }
}
