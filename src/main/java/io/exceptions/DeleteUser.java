package io.exceptions;

public class DeleteUser  extends  RuntimeException {
    public DeleteUser (String message) {
        super(message);
    }
    public DeleteUser (String message, Throwable cause) {
        super(message,cause);
    }
}
