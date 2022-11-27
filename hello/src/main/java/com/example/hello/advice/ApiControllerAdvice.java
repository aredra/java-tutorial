package com.example.hello.advice;

import com.example.hello.controller.ApiController;
import com.example.hello.dto.Error;
import com.example.hello.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
@RestControllerAdvice(basePackageClasses = ApiController.class)
public class ApiControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> exception(Exception e) {
        log.error(">>>>>>>>>>>>>>>>" + e.getClass().getName() + ", " + e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e,
                                                             HttpServletRequest httpServletRequest) {

        List<Error> errors = new ArrayList<>();
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getAllErrors().forEach(objectError -> {

            FieldError fieldError = (FieldError) objectError;
            Error error = new Error();
            error.setField(fieldError.getField());
            error.setMessage(fieldError.getDefaultMessage());
            error.setInvalidValue(Objects.requireNonNull(fieldError.getRejectedValue()).toString());

            errors.add(error);
        });
        log.error(errors.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(makeErrorResponse(httpServletRequest, errors));
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationException(ConstraintViolationException e,
                                                          HttpServletRequest httpServletRequest) {
        List<Error> errors = new ArrayList<>();
        e.getConstraintViolations().forEach(violation -> {
            Stream<Path.Node> stream = StreamSupport.stream(violation.getPropertyPath().spliterator(), false);
            List<Path.Node> list = stream.collect(Collectors.toList());
            String field = list.get(list.size() -1).getName();

            Error error = new Error();
            error.setField(field);
            error.setMessage(violation.getMessage());
            error.setInvalidValue(violation.getInvalidValue().toString());

            errors.add(error);
        });
        log.error(errors.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(makeErrorResponse(httpServletRequest, errors));
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e,
                                                                     HttpServletRequest httpServletRequest) {

        Error error = new Error();
        error.setField(e.getParameterName());
        error.setMessage(e.getMessage());

        List<Error> errors = new ArrayList<>();
        errors.add(error);

        log.error(error.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(makeErrorResponse(httpServletRequest, errors));
    }

    private ErrorResponse makeErrorResponse(HttpServletRequest request, List<Error> errors) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrors(errors);
        errorResponse.setMessage("");
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setRequestUrl(request.getRequestURI());
        errorResponse.setResultCode("FAIL");

        return errorResponse;
    }
}
