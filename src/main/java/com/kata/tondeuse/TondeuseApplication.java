package com.kata.tondeuse;

import com.kata.tondeuse.service.MowItNowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class TondeuseApplication {

    private final MowItNowService mowItNowService;

    @Autowired
    public TondeuseApplication(MowItNowService mowItNowService) {
        this.mowItNowService = mowItNowService;
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            var results = mowItNowService.processFile("exercice.txt");
            results.forEach(log::info);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TondeuseApplication.class, args);
    }
}
