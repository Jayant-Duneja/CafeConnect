package com.Cockroach.config;

import Observer.CafeConnectSubject;
import Observer.LoggingObserver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Observable;
@Configuration

public class ObserverConfig {
    @Bean
    public LoggingObserver loggingObserver() {
        return new LoggingObserver();
    }

    @Bean
    public CafeConnectSubject cafeConnectSubject(LoggingObserver loggingObserver) {
        CafeConnectSubject cafeConnectSubject = new CafeConnectSubject();
        cafeConnectSubject.addObserver(loggingObserver);
        // Add other observers if needed
        return cafeConnectSubject;
    }
}
