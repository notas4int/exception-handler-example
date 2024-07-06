package org.artem.projects.exceptionhandlerexample.exceptions;

public class PoorWineQualityException extends RuntimeException {
    public PoorWineQualityException(String message) {
        super(message);
    }
}
