package com.dipanjal.example.microservices.geo.config;

import com.dipanjal.example.microservices.geo.props.GeoLocationProp;
import io.ipgeolocation.api.IPGeolocationAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dipanjal
 * @since 6/29/2021
 */

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final GeoLocationProp prop;

    @Bean
    public IPGeolocationAPI ipGeolocationAPI() {
        return new IPGeolocationAPI(prop.getApiKey());
    }
}
