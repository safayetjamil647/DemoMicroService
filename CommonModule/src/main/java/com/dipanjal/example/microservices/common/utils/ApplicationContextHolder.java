package com.dipanjal.example.microservices.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author dipanjal
 * @since 6/21/2021
 */

@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext CTX;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CTX = applicationContext;
    }

    public static ApplicationContext getContext() {
        return CTX;
    }
}
