package com.dipanjal.example.microservices.CurrencyConversionService.exception;

import lombok.NoArgsConstructor;

/**
 * @author dipanjal
 * @since 6/21/2021
 */
@NoArgsConstructor
public class CurrencyConversionException extends RuntimeException {
    public CurrencyConversionException(String message) {
        super(message);
    }

    public CurrencyConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
