package com.dipanjal.example.microservices.CurrencyExchangeService;

/**
 * @author dipanjal
 * @since 6/20/2021
 */

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Currency;
import java.util.function.Consumer;

@SpringBootTest
class CurrencyExchangeApplicationTests {

    @Test
    void availableCurrencyListTest() {
        Consumer<Currency> currencyConsumer = c -> System.out.println(c.getCurrencyCode());
        Currency.getAvailableCurrencies()
                .forEach(currencyConsumer);
    }

}

