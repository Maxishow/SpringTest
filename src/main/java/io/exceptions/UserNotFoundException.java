package io.exceptions;

import org.apache.logging.log4j.message.Message;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(String message,Throwable cause) {
        super(message,cause);

    }
}
