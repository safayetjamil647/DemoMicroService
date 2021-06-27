package com.dipanjal.example.microservices.common.models;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author dipanjal
 * @since 6/27/2021
 */

@Data
public class CurrencyConversion extends CurrencyExchange {
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;

    public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, String environment, BigDecimal quantity, BigDecimal totalCalculatedAmount) {
        super(id, from, to, conversionMultiple, environment);
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
}
