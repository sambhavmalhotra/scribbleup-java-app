package com.scribbleup.exception;

/**
 * Created by sambhavmalhotra.
 * A common exceptions file to throw exception in API services
 */

public class BusinessException extends RuntimeException {
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException() {
        super();
    }
}
