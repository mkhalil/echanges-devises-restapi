package com.iobird.echangesdevises.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ApiError> handleBadRequestException(
            BadRequestException ex) {

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>( apiError, new HttpHeaders(), apiError.getStatus());

    }
}
