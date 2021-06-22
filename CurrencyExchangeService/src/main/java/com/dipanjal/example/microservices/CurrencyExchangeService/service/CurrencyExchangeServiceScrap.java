package com.dipanjal.example.microservices.CurrencyExchangeService.service;

import com.dipanjal.example.microservices.CurrencyExchangeService.exception.CurrencyExchangeException;
import com.dipanjal.example.microservices.CurrencyExchangeService.model.CurrencyExchange;
import com.dipanjal.example.microservices.CurrencyExchangeService.props.CurrencyExchangeProps;
import com.dipanjal.htmlunit.service.scrapper.ifaces.CurrencyExchangeScrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service("currencyExchangeServiceScrap")
@RequiredArgsConstructor
public class CurrencyExchangeServiceScrap implements CurrencyExchangeService {

    private final CurrencyExchangeScrapper<BigDecimal> currencyExchangeScrapper;
    private final CurrencyExchangeProps props;

    @Override
    public CurrencyExchange fetchValue(String from, String to) throws CurrencyExchangeException {
        try{
            BigDecimal exchangeValue = currencyExchangeScrapper.scrap(
                    String.format(props.getApi().getUrl(), from, to),
                    BigDecimal::new
            );
            return new CurrencyExchange(1L, from, to, exchangeValue);
        }catch (IOException e){
            throw new CurrencyExchangeException("Scrapping Server Exception", e);
        }
    }
}
