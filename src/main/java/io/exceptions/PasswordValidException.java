package io.exceptions;

public class PasswordValidException extends RuntimeException{
    public PasswordValidException(String message) {
        super(message);
    }
    public PasswordValidException(String message, Throwable cause) {
        super(message,cause);
    }
}
