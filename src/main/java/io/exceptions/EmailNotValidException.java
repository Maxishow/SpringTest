package io.exceptions;

public class EmailNotValidException extends RuntimeException {
    public EmailNotValidException(String message) {
        super(message);
    }
    public EmailNotValidException(String message, Throwable cause) {

    }
}
