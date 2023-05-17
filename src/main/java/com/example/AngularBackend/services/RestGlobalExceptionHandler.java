package com.example.AngularBackend.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {

        String type = "https://example.net/errors/insert-conflict";
        String title = "The ressource already exists";
        String status = "409";
        String detail = ex.getMessage();
        String instance = "https://example.net/users/create";

        ErrorResponse errorResponse = new ErrorResponse(type,title,status,detail,instance);

        return handleExceptionInternal(ex,errorResponse,new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value={UserNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request){
        String type = "https://example.net/errors/not-found";
        String title = "The ressource cannot be found ";
        String status = "404";
        String detail = ex.getMessage();
        String instance = "https://example.net/users/UserName";

        ErrorResponse errorResponse = new ErrorResponse(type,title,status,detail,instance);

        return handleExceptionInternal(ex,errorResponse,new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {        String type = "https://example.net/errors/failed-validation";
        String title = "At least one of the given values failed validation";
        String statusCode = "422";
        //String detail ="";
        String instance = "https://example.net/users/create";
        List<String> errors=new ArrayList<>();

        ex.getBindingResult().getAllErrors()
                .stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .forEach(fieldError -> errors.add(fieldError.getField()+" "+fieldError.getDefaultMessage()));

        ErrorResponse errorResponse = new ErrorResponse(type,title,statusCode,errors.toString(),instance);

        return handleExceptionInternal(ex,errorResponse,new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
