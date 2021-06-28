package com.dipanjal.example.microservices.CurrencyExchangeService.controller;

import com.dipanjal.example.microservices.CurrencyExchangeService.advice.ApiError;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author dipanjal
 * @since 6/28/2021
 */

@Slf4j
@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "retryService", fallbackMethod = "sampleFallbackHandler")
    @CircuitBreaker(name = "retryServiceB", fallbackMethod = "sampleFallbackHandler")
    public ResponseEntity<String> sampleApi(){
        log.info("Sample Api Call Received");
        return new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);
    }

    protected ResponseEntity<String> sampleFallbackHandler(Throwable t){
        log.info("Exception occurred - {}", t.getMessage());
        log.error(t.getMessage(), t);
        return ResponseEntity
                .internalServerError()
                .body("Sample Fallback Response");
    }
}
