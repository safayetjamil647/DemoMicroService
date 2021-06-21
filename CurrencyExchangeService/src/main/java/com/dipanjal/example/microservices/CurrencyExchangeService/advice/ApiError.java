package com.dipanjal.example.microservices.CurrencyExchangeService.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author dipanjal
 * @since 6/21/2021
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;

}
