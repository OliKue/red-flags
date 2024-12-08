package com.olikue.redflags;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@SpringBootApplication
public class RedflagsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedflagsApplication.class, args);
	}
}
