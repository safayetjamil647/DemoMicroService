package com.dipanjal.example.microservices.geo.service;

import com.dipanjal.example.microservices.common.models.GeoIP;
import com.dipanjal.example.microservices.geo.props.GeoLocationProp;
import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author dipanjal
 * @since 6/29/2021
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GeoLocationService {

    private final IPGeolocationAPI ipGeolocationAPI;
    private final GeoLocationProp prop;

    public Geolocation fetchGeoLocationForIPAddress(String ipAddress) {
        GeolocationParams geoParams = new GeolocationParams();
        geoParams.setIPAddress(ipAddress);
        geoParams.setFields(prop.getFields());


        Geolocation geolocation = ipGeolocationAPI.getGeolocation(geoParams);

        if(geolocation.getStatus() != 200) {
            log.info("Status Code: {}, Message: {}\n", geolocation.getStatus(), geolocation.getMessage());
            return null;
        }

        return geolocation;
    }
}
