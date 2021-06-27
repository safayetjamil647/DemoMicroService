package com.dipanjal.example.microservices.CurrencyConversionService.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.function.Predicate;

/**
 * @author dipanjal
 * @since 6/27/2021
 */

public class ResponseUtils {
    private ResponseUtils() { }

    public static boolean isOk(ResponseEntity<?> entity){
        return entity.getStatusCode().equals(HttpStatus.OK);
    }

    public static boolean isOk(ResponseEntity<?> entity, Predicate<ResponseEntity<?>> predicate){
        return predicate.test(entity);
    }

    public static boolean isNotOk(ResponseEntity<?> entity){
        return !isOk(entity);
    }

    public static boolean isNotOk(ResponseEntity<?> entity, Predicate<ResponseEntity<?>> predicate){
        return !isOk(entity, predicate);
    }
}
