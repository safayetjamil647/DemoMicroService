package com.dipanjal.example.microservices.CurrencyExchangeService.service;

import com.dipanjal.example.microservices.CurrencyExchangeService.exception.CurrencyExchangeException;
import com.dipanjal.example.microservices.CurrencyExchangeService.props.CurrencyExchangeProps;
import com.dipanjal.example.microservices.common.models.CurrencyExchange;
import com.dipanjal.htmlunit.service.scrapper.ifaces.CurrencyExchangeScrapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Slf4j
@Service("currencyExchangeServiceScrap")
@RequiredArgsConstructor
public class CurrencyExchangeServiceScrap extends BaseService implements CurrencyExchangeService {

    private final CurrencyExchangeScrapper<BigDecimal> currencyExchangeScrapper;
    private final CurrencyExchangeProps props;

    @Override
    @CircuitBreaker(name = "retryServiceB", fallbackMethod = "currencyExchangeFallbackHandler")
    public CurrencyExchange fetchValue(String from, String to) throws CurrencyExchangeException {
        try{
            BigDecimal exchangeValue = currencyExchangeScrapper.scrap(
                    String.format(props.getApi().getUrl(), from, to),
                    BigDecimal::new
            );
            return new CurrencyExchange(1L, from, to, exchangeValue, getLocalServerPort());
        }catch (IOException e){
            throw new CurrencyExchangeException(e.getMessage(), e);
        }
    }

    private CurrencyExchange currencyExchangeFallbackHandler(Throwable throwable){
        return new CurrencyExchange(1L, "USD", "BDT", new BigDecimal(88), getLocalServerPort());
    }
}
