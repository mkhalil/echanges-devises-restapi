package com.iobird.echangesdevises.controller;

import com.iobird.echangesdevises.exceptions.BadRequestException;
import com.iobird.echangesdevises.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionMapperController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionMapperController.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void onResourceNotFoundException(ResourceNotFoundException exception, HttpServletResponse response) throws IOException {
        String errorMsg = "Resource not found : " +exception.getMessage();
        LOGGER.error(errorMsg, exception);
        response.sendError(HttpStatus.NOT_FOUND.value(),errorMsg);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void onFraisInvalidException(BadRequestException exception, HttpServletResponse response) throws IOException {
        String errorMsg = "Bad Request : " +exception.getMessage();
        LOGGER.error(errorMsg, exception);
        response.sendError(HttpStatus.BAD_REQUEST.value(), errorMsg);
    }
}
