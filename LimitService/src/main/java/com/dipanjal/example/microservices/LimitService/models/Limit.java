package com.dipanjal.example.microservices.LimitService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dipanjal
 * @since 6/16/2021
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Limit {
    private int minimum;
    private int maximum;
}
