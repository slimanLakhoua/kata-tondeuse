package com.kata.tondeuse.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MowItNowServiceTest {

    @Autowired
    private MowItNowService mowItNowService;


    @Test
    void should_Read_File() {

        try {
            // given
            String fileName = "exercice";
            // when
            File file = mowItNowService.readFile(fileName);
            // then
            assertNotNull(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}