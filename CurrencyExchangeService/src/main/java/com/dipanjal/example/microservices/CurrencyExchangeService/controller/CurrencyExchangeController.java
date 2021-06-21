package com.dipanjal.example.microservices.CurrencyExchangeService.controller;

import com.dipanjal.example.microservices.CurrencyExchangeService.enums.FetchType;
import com.dipanjal.example.microservices.CurrencyExchangeService.exception.CurrencyExchangeException;
import com.dipanjal.example.microservices.CurrencyExchangeService.exception.ConfigurationException;
import com.dipanjal.example.microservices.CurrencyExchangeService.model.CurrencyExchange;
import com.dipanjal.example.microservices.CurrencyExchangeService.props.CurrencyExchangeProps;
import com.dipanjal.example.microservices.CurrencyExchangeService.service.CurrencyExchangeService;
import com.dipanjal.example.microservices.CurrencyExchangeService.service.CurrencyExchangeServiceRest;
import com.dipanjal.example.microservices.CurrencyExchangeService.service.CurrencyExchangeServiceScrap;
import com.dipanjal.example.microservices.CurrencyExchangeService.service.CurrencyExchangeServiceSoap;
import com.dipanjal.example.microservices.CurrencyExchangeService.utils.ApplicationContextHolder;
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

    private final CurrencyExchangeProps apiProp;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchangeValue(@PathVariable final String from,
                                                                  @PathVariable final String to) throws CurrencyExchangeException {
        return ResponseEntity.ok(getService().fetchValue(from, to));
    }

    private CurrencyExchangeService getService(){
        if(FetchType.isREST(apiProp.getApi().getFetchType()))
            return ApplicationContextHolder.getContext().getBean(CurrencyExchangeServiceRest.class);
        if(FetchType.isSOAP(apiProp.getApi().getFetchType()))
            return ApplicationContextHolder.getContext().getBean(CurrencyExchangeServiceSoap.class);
        if(FetchType.isSCRAP(apiProp.getApi().getFetchType()))
            return ApplicationContextHolder.getContext().getBean(CurrencyExchangeServiceScrap.class);

        throw new ConfigurationException("Currency Exchange API - Invalid Fetch Type");
    }
}
