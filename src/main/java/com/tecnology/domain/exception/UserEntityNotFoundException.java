package com.tecnology.domain.exception;

public class UserEntityNotFoundException extends RuntimeException {
    public UserEntityNotFoundException(String message) {
        super(message);
    }
}