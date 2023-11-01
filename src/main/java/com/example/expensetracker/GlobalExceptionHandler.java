package com.example.expensetracker;

import com.example.expensetracker.exceptions.AuthenticationFailedException;
import com.example.expensetracker.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleUserNotFoundException(UserNotFoundException ex) {
        logger.error("User not found", ex);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleAuthenticationFailedException(AuthenticationFailedException ex) {
        logger.error("Authentication failed", ex);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        System.out.println("Method Argument Type Mismatch: " + ex.toString());
        logger.error("Method Argument Type Mismatch", ex);
    }
}

