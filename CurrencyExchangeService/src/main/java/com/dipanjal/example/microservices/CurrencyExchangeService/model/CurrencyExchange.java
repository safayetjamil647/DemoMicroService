package com.dipanjal.example.microservices.CurrencyExchangeService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author dipanjal
 * @since 6/20/2021
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
