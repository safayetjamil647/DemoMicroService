package com.dipanjal.example.microservices.CurrencyExchangeService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @author dipanjal
 * @since 6/26/2021
 */

public class BaseService {

    private Environment environment;

    @Autowired
    public void injectDependencies(final Environment environment){
        this.environment = environment;
    }

    protected String getLocalServerPort(){
        return environment.getProperty("local.server.port");
    }
}
