package com.dipanjal.example.microservices.CurrencyConversionService.controller;

import com.dipanjal.example.microservices.CurrencyConversionService.service.CurrencyConversionService;
import com.dipanjal.example.microservices.common.models.CurrencyConversion;
import com.dipanjal.example.microservices.common.models.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author dipanjal
 * @since 6/27/2021
 */

@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService service;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConversion> calculateCurrencyConversion(
            @PathVariable final String from,
            @PathVariable final String to,
            @PathVariable final BigDecimal quantity){

        return ResponseEntity.ok(
                service.calculateCurrencyConversion(from, to, quantity)
        );
    }
}
