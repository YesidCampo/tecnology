package com.tecnology.domain.exception;

public class UserEntityNotCreatedException extends RuntimeException {
    public UserEntityNotCreatedException(String message) {
        super(message);
    }
}