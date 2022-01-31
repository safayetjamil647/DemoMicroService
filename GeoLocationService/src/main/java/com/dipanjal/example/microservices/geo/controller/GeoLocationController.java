package com.dipanjal.example.microservices.geo.controller;

import com.dipanjal.example.microservices.geo.service.GeoLocationService;
import io.ipgeolocation.api.Geolocation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dipanjal
 * @since 6/29/2021
 */

@RestController
public class GeoLocationController {

    private final GeoLocationService service;

    public GeoLocationController(GeoLocationService service) {
        this.service = service;
    }

    @GetMapping("/geo-location/{ipAddress}")
    public ResponseEntity<Geolocation> getGeoLocationForIPAddress(@PathVariable String ipAddress){
        return ResponseEntity.ok(service.fetchGeoLocationForIPAddress(ipAddress));
    }
}
