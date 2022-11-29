package com.adjebbi.account.exception.handler;

import com.adjebbi.account.exception.CustomerNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.adjebbi.account.model.Error;

/**
 * @author - Djebbi.Achref@scheidt-bachmann.de
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final String CUSTOMER_NOT_FOUND= "C001";

    @ExceptionHandler(value = {CustomerNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        Error errorBody = new Error(CUSTOMER_NOT_FOUND, ex.getCause().getMessage());
        return handleExceptionInternal(ex, errorBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}