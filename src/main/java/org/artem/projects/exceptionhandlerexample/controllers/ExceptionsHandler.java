package org.artem.projects.exceptionhandlerexample.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.artem.projects.exceptionhandlerexample.exceptions.BeerNotFoundException;
import org.artem.projects.exceptionhandlerexample.exceptions.DetectedLiverCirrhosisException;
import org.artem.projects.exceptionhandlerexample.exceptions.ExceptionResponse;
import org.artem.projects.exceptionhandlerexample.exceptions.PoorWineQualityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Log4j2
public class ExceptionsHandler {
    @ExceptionHandler(BeerNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundBeerException(RuntimeException e,
                                                                      HttpServletRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(request.getRequestURI(), e.getMessage(),
                LocalDateTime.now());
        log.info(exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PoorWineQualityException.class)
    public ResponseEntity<ExceptionResponse> handlePoorWineQualityException(RuntimeException e,
                                                                                    HttpServletRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(request.getRequestURI(), e.getMessage(),
                LocalDateTime.now());
        log.info(exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DetectedLiverCirrhosisException.class)
    public ResponseEntity<ExceptionResponse> handleDetectedLiverCirrhosisException(RuntimeException e,
                                                                                    HttpServletRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(request.getRequestURI(), e.getMessage(),
                LocalDateTime.now());
        log.info(exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }
}
