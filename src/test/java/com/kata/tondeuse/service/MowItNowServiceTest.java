package com.kata.tondeuse.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowItNowServiceTest {

    private final MowItNowService mowItNowService = new MowItNowServiceImpl();


    @Test
    void processFile_should_return_valid_output() {

        var results = mowItNowService.processFile("exercice.txt");
        assertAll(() -> {
            assertEquals("1 3 N", results.get(0));
            assertEquals("5 1 E", results.get(1));
        });
    }

}