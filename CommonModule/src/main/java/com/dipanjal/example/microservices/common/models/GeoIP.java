package com.dipanjal.example.microservices.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dipanjal
 * @since 6/29/2021
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoIP {
    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
}
