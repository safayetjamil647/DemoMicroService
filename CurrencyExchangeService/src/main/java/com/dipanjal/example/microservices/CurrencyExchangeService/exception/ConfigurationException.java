package com.dipanjal.example.microservices.CurrencyExchangeService.exception;

import lombok.NoArgsConstructor;

/**
 * @author dipanjal
 * @since 6/21/2021
 */
@NoArgsConstructor
public class ConfigurationException extends RuntimeException {
    public ConfigurationException(String message) {
        super(message);
    }
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
