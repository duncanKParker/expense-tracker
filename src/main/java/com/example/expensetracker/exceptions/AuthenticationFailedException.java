// AuthenticationFailedException.java
package com.example.expensetracker.exceptions;

public class AuthenticationFailedException extends RuntimeException {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}
