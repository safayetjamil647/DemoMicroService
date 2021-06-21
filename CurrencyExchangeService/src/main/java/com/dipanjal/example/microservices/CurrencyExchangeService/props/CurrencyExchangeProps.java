package com.dipanjal.example.microservices.CurrencyExchangeService.props;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dipanjal
 * @since 6/21/2021
 */

@Component
@ConfigurationProperties("currency-exchange")
@Data
@ToString
public class CurrencyExchangeProps {

    private Api api;

    @Getter
    @Setter
    @ToString
    public static class Api {
        private String url;
        private String fetchType;
    }
}
