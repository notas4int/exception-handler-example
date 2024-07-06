package org.artem.projects.exceptionhandlerexample.exceptions;

public class BeerNotFoundException extends RuntimeException {
    public BeerNotFoundException(String message) {
        super(message);
    }
}
