package org.artem.projects.exceptionhandlerexample.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String requestURI;
    private String message;
    private LocalDateTime currentTime;
}
