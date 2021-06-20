package com.dipanjal.example.microservices.LimitService.controllers;

import com.dipanjal.example.microservices.LimitService.configs.LimitProperties;
import com.dipanjal.example.microservices.LimitService.models.Limit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dipanjal
 * @since 6/16/2021
 */

@RestController
@RequiredArgsConstructor
public class LimitController {

    private final LimitProperties config;

    @GetMapping("/limit")
    public ResponseEntity<Limit> retrieveLimit(){
        return ResponseEntity.ok(new Limit(config.getMinimum(), config.getMaximum()));
    }
}
