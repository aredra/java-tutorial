package com.example.hello.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {

    private String statusCode;

    private String requestUrl;

    private String code;

    private String message;

    private String resultCode;

    List<Error> errors;
}
