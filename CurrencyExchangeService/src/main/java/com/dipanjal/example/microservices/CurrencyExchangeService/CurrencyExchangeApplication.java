package com.dipanjal.example.microservices.CurrencyExchangeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
public class CurrencyExchangeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		testLog();
	}

	private void testLog() {
		IntStream.range(1, 10000).forEach(i -> {
			log.info("INFO VALUE {}", i);
			log.trace("TRACE VALUE {}", i);
			log.debug("DEBUG VALUE {}", i);
			log.warn("WARN VALUE {}", i);
			log.error("ERROR VALUE {}", i);
		});
	}
}
