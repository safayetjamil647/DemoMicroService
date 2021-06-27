package com.dipanjal.example.microservices.CurrencyConversionService.service;

import com.dipanjal.example.microservices.CurrencyConversionService.client.CurrencyExchangeClient;
import com.dipanjal.example.microservices.CurrencyConversionService.exception.CurrencyConversionException;
import com.dipanjal.example.microservices.CurrencyConversionService.utils.ResponseUtils;
import com.dipanjal.example.microservices.common.models.CurrencyConversion;
import com.dipanjal.example.microservices.common.models.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static com.dipanjal.example.microservices.CurrencyConversionService.utils.ResponseUtils.isNotOk;

import java.math.BigDecimal;

/**
 * @author dipanjal
 * @since 6/27/2021
 */

@Service
@RequiredArgsConstructor
public class CurrencyConversionService {

    private final CurrencyExchangeClient client;

    public CurrencyConversion calculateCurrencyConversion(
            final String from,
            final String to,
            final BigDecimal quantity){

        ResponseEntity<CurrencyExchange> response = client.retrieveCurrencyExchangeValue(from, to);
        if(isNotOk(response))
            throw new CurrencyConversionException("Currency Conversion Exception");
        return calculateAndGet(response.getBody(), quantity);
    }

    private CurrencyConversion calculateAndGet(CurrencyExchange exchange, BigDecimal quantity){
        return new CurrencyConversion(
                exchange.getId(), exchange.getFrom(), exchange.getTo(),
                exchange.getConversionMultiple(),
                exchange.getEnvironment(),
                quantity,
                exchange.getConversionMultiple().multiply(quantity)
        );
    }
}
