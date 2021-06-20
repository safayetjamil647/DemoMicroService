package com.dipanjal.example.microservices.LimitService.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dipanjal
 * @since 6/16/2021
 */
@Component
@ConfigurationProperties("limit-service")
@Data
public class LimitProperties {
    private int maximum;
    private int minimum;
}
