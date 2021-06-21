package com.dipanjal.example.microservices.CurrencyExchangeService.advice;

import com.dipanjal.example.microservices.CurrencyExchangeService.exception.CurrencyExchangeException;
import com.dipanjal.example.microservices.CurrencyExchangeService.exception.ConfigurationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

/**
 * @author dipanjal
 * @since 6/21/2021
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CurrencyExchangeException.class)
    public ResponseEntity<Object> handleCurrencyExchangeException(CurrencyExchangeException ex, HttpHeaders headers, WebRequest request) {
        var body = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), Collections.singletonList(ex.getMessage()));
        return handleExceptionInternal(
                ex,
                body,
                headers,
                body.getStatus(),
                request
        );
    }

    @ExceptionHandler(ConfigurationException.class)
    public ResponseEntity<Object> handleFetchTypeException(ConfigurationException ex, HttpHeaders headers, WebRequest request) {
        var body = new ApiError(HttpStatus.NOT_ACCEPTABLE, ex.getMessage(), Collections.singletonList(ex.getMessage()));
        return handleExceptionInternal(
                ex,
                body,
                headers,
                body.getStatus(),
                request
        );
    }
}
