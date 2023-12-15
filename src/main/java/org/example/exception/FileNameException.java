package org.example.exception;

public class FileNameException extends RuntimeException {
    public FileNameException(String message, Throwable ex) {
        super(message, ex);
    }
}
