package com.dipanjal.example.microservices.CurrencyConversionService.client;

import com.dipanjal.example.microservices.common.models.CurrencyExchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author dipanjal
 * @since 6/27/2021
 */

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeClient {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ResponseEntity<CurrencyExchange> retrieveCurrencyExchangeValue(@PathVariable final String from,
                                                                   @PathVariable final String to);
}
