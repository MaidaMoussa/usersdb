package com.example.AngularBackend.services;

public class UserAlreadyExistsException extends Exception{

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
