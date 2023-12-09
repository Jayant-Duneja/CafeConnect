package com.Cockroach;

import com.Cockroach.config.ObserverConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ObserverConfig.class)
public class CockroachDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CockroachDbApplication.class, args);
	}

}
