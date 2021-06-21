package com.dipanjal.example.microservices.CurrencyExchangeService.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Locale;

@AllArgsConstructor
@Getter
public enum FetchType {
    REST,
    SOAP,
    SCRAP
    ;

    public static boolean isREST(String value){
        return value.toUpperCase(Locale.ROOT).equals(REST.name());
    }

    public static boolean isSOAP(String value){
        return value.toUpperCase(Locale.ROOT).equals(SOAP.name());
    }

    public static boolean isSCRAP(String value){
        return value.toUpperCase(Locale.ROOT).equals(SCRAP.name());
    }
}
