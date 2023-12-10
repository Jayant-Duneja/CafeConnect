package com.Cockroach.config;
import com.Cockroach.Observer.CafeConnectSubject;
import com.Cockroach.Observer.LoggingObserver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
