package com.pi.gest.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{

    @Getter
    private Errors errorCode;
    @Getter
    private List<String> errors;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, Errors errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, Errors errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, Errors errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
