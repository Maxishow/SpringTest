package io.exceptions.excadvice;

import io.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SecurityControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponseError handleSecurityException(EmailAlreadyExistException exc) {
        return new SecurityResponseError(exc.getMessage());
    }
    @ExceptionHandler(EmailNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponseError handleSecurityException(EmailNotValidException exc) {
        return new SecurityResponseError(exc.getMessage());
    }

    @ExceptionHandler(PasswordValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponseError handleSecurityException(PasswordValidException exc) {
        return new SecurityResponseError(exc.getMessage());
    }

    @ExceptionHandler(NoEmailMatchesException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponseError handleSecurityException(NoEmailMatchesException exc) {
        return new SecurityResponseError(exc.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponseError handleSecurityException(UserNotFoundException exc) {
        return new SecurityResponseError(exc.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponseError handleSecurityException(IllegalArgumentException exc) {
        return new SecurityResponseError(exc.getMessage());
    }

    @ExceptionHandler(DeleteUser.class)
 protected ResponseEntity<SecurityResponseMessage> handleSecurityException(DeleteUser exc) {
        return new ResponseEntity<>(new SecurityResponseMessage(exc.getMessage()), HttpStatus.OK);
    }
}

