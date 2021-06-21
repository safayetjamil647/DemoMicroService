package com.dipanjal.example.microservices.CurrencyExchangeService.service;

import com.dipanjal.example.microservices.CurrencyExchangeService.exception.CurrencyExchangeException;
import com.dipanjal.example.microservices.CurrencyExchangeService.model.CurrencyExchange;

public interface CurrencyExchangeService {
    CurrencyExchange fetchValue(String from, String to) throws CurrencyExchangeException;
}
