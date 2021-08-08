package com.dipanjal.example.microservices.CurrencyConversionService.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dipanjal
 * @since 0.0.1
 */

@Slf4j
@Component
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.logRequest("Request from", request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        this.logRequest("Processing", request);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        this.logRequest("Returning from", request);
    }

    private void logRequest(String prefix, HttpServletRequest request){
        log.info("{} -> {}:{}{}", prefix,
                request.getRemoteAddr(),
                request.getLocalPort(),
                request.getRequestURI());
    }
}
