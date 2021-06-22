package com.dipanjal.example.microservices.CurrencyExchangeService.factory;

import com.dipanjal.example.microservices.CurrencyExchangeService.enums.FetchType;
import com.dipanjal.example.microservices.CurrencyExchangeService.exception.ConfigurationException;
import com.dipanjal.example.microservices.CurrencyExchangeService.props.CurrencyExchangeProps;
import com.dipanjal.example.microservices.CurrencyExchangeService.service.CurrencyExchangeService;
import com.dipanjal.example.microservices.CurrencyExchangeService.service.CurrencyExchangeServiceRest;
import com.dipanjal.example.microservices.CurrencyExchangeService.service.CurrencyExchangeServiceScrap;
import com.dipanjal.example.microservices.CurrencyExchangeService.service.CurrencyExchangeServiceSoap;
import com.dipanjal.example.microservices.CurrencyExchangeService.utils.ApplicationContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author dipanjal
 * @since 6/22/2021
 */

@Component
@RequiredArgsConstructor
public class CurrencyExchangeServiceFactory {

    private final CurrencyExchangeProps props;

    public CurrencyExchangeService getService(){
        if(FetchType.isREST(props.getApi().getFetchType()))
            return ApplicationContextHolder.getContext().getBean(CurrencyExchangeServiceRest.class);
        if(FetchType.isSOAP(props.getApi().getFetchType()))
            return ApplicationContextHolder.getContext().getBean(CurrencyExchangeServiceSoap.class);
        if(FetchType.isSCRAP(props.getApi().getFetchType()))
            return ApplicationContextHolder.getContext().getBean(CurrencyExchangeServiceScrap.class);

        throw new ConfigurationException("Currency Exchange API - Invalid Fetch Type");
    }
}
