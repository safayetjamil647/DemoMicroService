package com.dipanjal.example.microservices.CurrencyExchangeService.service;

import com.dipanjal.example.microservices.CurrencyExchangeService.exception.CurrencyExchangeException;
import com.dipanjal.example.microservices.CurrencyExchangeService.model.CurrencyExchange;
import com.dipanjal.example.microservices.CurrencyExchangeService.props.CurrencyExchangeProps;
import com.dipanjal.htmlunit.service.scrapper.ifaces.CurrencyExchangeScrapper;
import com.dipanjal.htmlunit.service.scrapper.ifaces.WebScrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service("currencyExchangeServiceScrap")
@RequiredArgsConstructor
public class CurrencyExchangeServiceScrap implements CurrencyExchangeService {

/*    private final WebScrapper<String, Double> currencyExchangeScrapper;

    public CurrencyExchangeServiceScrap(WebScrapper<String, Double> currencyExchangeScrapper) {
        this.currencyExchangeScrapper = currencyExchangeScrapper;
    }*/

    private final CurrencyExchangeScrapper<Double> currencyExchangeScrapper;
    private final CurrencyExchangeProps props;

    @Override
    public CurrencyExchange fetchValue(String from, String to) throws CurrencyExchangeException {
        try{
            Double exchangeValue = currencyExchangeScrapper.scrap(
                    String.format(props.getApi().getUrl(), from, to),
                    Double::valueOf
            );
            return new CurrencyExchange(1L, from, to, BigDecimal.valueOf(exchangeValue));
        }catch (IOException e){
            throw new CurrencyExchangeException("Scrapping Server Exception", e);
        }
    }
}
