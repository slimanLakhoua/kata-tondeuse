package com.kata.tondeuse.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DirectionTest {

   static final Direction directionN = Direction.N;
    static final Direction directionW = Direction.W;
    static final Direction directionS = Direction.S;
    static final Direction directionE = Direction.E;

    @Test
    void getRightElement() throws Exception {
        // Given
            // direction are declared static
        //When
        Direction rightDirectionN = directionN.getRight();
        Direction rightDirectionW = directionW.getRight();
        Direction rightDirectionS = directionS.getRight();
        Direction rightDirectionE = directionE.getRight();
        //Then
        assertEquals(Direction.E, rightDirectionN);
        assertEquals(Direction.N, rightDirectionW);
        assertEquals(Direction.W, rightDirectionS);
        assertEquals(Direction.S, rightDirectionE);
    }

    @Test
    void getLeftElemnt() throws Exception {
        // Given
            // direction are declared static
        //When
        Direction leftDirectionN = directionN.getLeft();
        Direction leftDirectionW = directionW.getLeft();
        Direction leftDirectionS = directionS.getLeft();
        Direction leftDirectionE = directionE.getLeft();
        //Then
        assertEquals(Direction.W, leftDirectionN);
        assertEquals(Direction.S, leftDirectionW);
        assertEquals(Direction.E, leftDirectionS);
        assertEquals(Direction.N, leftDirectionE);
    }

}