package io.exceptions;

public class NoEmailMatchesException  extends RuntimeException {
    public NoEmailMatchesException(String message) {
        super(message);
    }
    public NoEmailMatchesException(String message, Throwable cause) {
        super(message);
    }
}
