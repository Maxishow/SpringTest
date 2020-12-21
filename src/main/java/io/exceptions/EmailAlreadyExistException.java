package io.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmailAlreadyExistException extends  RuntimeException {
    public EmailAlreadyExistException(String message) {
        super(message);
    }
    public EmailAlreadyExistException(String message, Throwable cause) {
        super(message,cause);
    }
}
