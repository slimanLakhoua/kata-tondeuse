package com.kata.tondeuse.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    private Field field;

    @BeforeEach
    void init() {
        field = new Field(5,5);
    }

    @Test
    void should_return_true_when_x2_y2() {
        // Given
        int x = 2;
        int y = 2;

        // When
        boolean canMove = field.canMove(x,y);

        // Then
        assertTrue(canMove);
    }

    @Test
    void should_return_false_when_x6_y6() {
        // Given
        int x = 6;
        int y = 6;

        // When
        boolean canMove = field.canMove(x,y);

        // Then
        assertFalse(canMove);
    }

    @Test
    void should_throw_exception_when_given_nigative_coordinates() {
        // Given
        int x = -1;
        int y = -1;

        // When
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class ,() -> {
            field.canMove(x,y);
        });

        // Then
        assertEquals("coordinates can not be negative", thrown.getMessage());
    }
}