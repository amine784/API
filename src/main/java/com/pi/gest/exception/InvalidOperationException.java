package com.pi.gest.exception;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException {

    @Getter
    private Errors errorCode;

    public InvalidOperationException(String message) {
        super(message);
    }

    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOperationException(String message, Throwable cause, Errors errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidOperationException(String message, Errors errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
