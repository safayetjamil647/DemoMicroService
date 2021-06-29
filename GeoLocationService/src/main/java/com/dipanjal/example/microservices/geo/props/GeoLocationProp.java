package com.dipanjal.example.microservices.geo.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dipanjal
 * @since 6/29/2021
 */

@Component
@ConfigurationProperties("geo-location")
@Data
public class GeoLocationProp {
    private String apiKey;
    private String fields;
}
