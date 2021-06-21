package com.dipanjal.example.microservices.CurrencyExchangeService.exception;

import lombok.NoArgsConstructor;

/**
 * @author dipanjal
 * @since 6/21/2021
 */
@NoArgsConstructor
public class CurrencyExchangeException extends Exception {
    public CurrencyExchangeException(String message) {
        super(message);
    }

    public CurrencyExchangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
