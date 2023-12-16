package org.example.exception;

public class LoadDriverException extends RuntimeException {
    public LoadDriverException(String message, Throwable ex) {
        super(message, ex);
    }
}
