package com.swcodingschool.Lesson221;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringIntializrApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringIntializrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringIntializrApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject("192.168.0.21:8080/random", Quote.class);
			log.info(quote.toString());
		};
	}

}