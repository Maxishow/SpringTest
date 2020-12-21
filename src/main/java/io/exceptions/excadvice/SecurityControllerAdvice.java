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
    public SecurityResponse handleSecurityException(EmailAlreadyExistException exc) {
        return new SecurityResponse(exc.getMessage());
    }
    @ExceptionHandler(EmailNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(EmailNotValidException exc) {
        return new SecurityResponse(exc.getMessage());
    }

    @ExceptionHandler(PasswordValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(PasswordValidException exc) {
        return new SecurityResponse(exc.getMessage());
    }

    @ExceptionHandler(NoEmailMatchesException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(NoEmailMatchesException exc) {
        return new SecurityResponse(exc.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(UserNotFoundException exc) {
        return new SecurityResponse(exc.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(IllegalArgumentException exc) {
        return new SecurityResponse(exc.getMessage());
    }

}

