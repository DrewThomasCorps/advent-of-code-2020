package com.adventofcode._17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpaceTest {

    Space space;

    @BeforeEach
    void setUp() {
        space = Unmarshaller.getStartingSpace(
                this.getClass().getResourceAsStream("testInput.txt")
        );
    }

    @Test
    void getActiveCubesCount() {
        assertEquals(5, space.activeCubesCount());
    }

    @Test
    void completeNCycles() {
        space.completeNCycles(6);
        assertEquals(112, space.activeCubesCount());
    }
}