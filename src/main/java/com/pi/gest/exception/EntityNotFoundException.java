package com.pi.gest.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{


    @Getter
    private Errors errors;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, Errors errors) {
        super(message, cause);
        this.errors = errors;
    }

    public EntityNotFoundException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }
}
