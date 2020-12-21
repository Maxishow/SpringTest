package io.exceptions.excadvice;

import io.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SecurityControllerAdvice {
    @ExceptionHandler(EmailAlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(EmailAlreadyExistException se) {
        return new SecurityResponse(se.getMessage());
    }
    @ExceptionHandler(EmailNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(EmailNotValidException se) {
        return new SecurityResponse(se.getMessage());
    }

    @ExceptionHandler(PasswordValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(PasswordValidException se) {
        return new SecurityResponse(se.getMessage());
    }

    @ExceptionHandler(NoEmailMatchesException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(NoEmailMatchesException se) {
        return new SecurityResponse(se.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(UserNotFoundException se) {
        return new SecurityResponse(se.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(IllegalArgumentException se) {
        return new SecurityResponse(se.getMessage());
    }

}

