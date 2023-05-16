package com.example.AngularBackend.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {

        String type = "https://example.net/errors/insert-conflict";
        String title = "The ressource already exists";
        String status = "409";
        String detail = ex.getMessage();
        String instance = "";

        ErrorResponse errorResponse = new ErrorResponse(type,title,status,detail,instance);

        return handleExceptionInternal(ex,errorResponse,new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
