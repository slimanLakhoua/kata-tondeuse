package com.kata.tondeuse;

import com.kata.tondeuse.service.MowItNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class TondeuseApplication {

	@Autowired
	private MowItNowService mowItNowService;
	public static void main(String[] args) {
		SpringApplication.run(TondeuseApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//
//		return args -> {
//			File file = mowItNowService.readFile("exercice");
//
//		};
//	}
}
