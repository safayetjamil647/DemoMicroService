package com.dipanjal.example.microservices.CurrencyExchangeService.controller;

import com.dipanjal.example.microservices.CurrencyExchangeService.exception.CurrencyExchangeException;
import com.dipanjal.example.microservices.CurrencyExchangeService.factory.CurrencyExchangeServiceFactory;
import com.dipanjal.example.microservices.CurrencyExchangeService.model.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dipanjal
 * @since 6/20/2021
 */

@RestController
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeServiceFactory factory;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchangeValue(@PathVariable final String from,
                                                                  @PathVariable final String to) throws CurrencyExchangeException {
        return ResponseEntity.ok(factory.getService().fetchValue(from, to));
    }


}
