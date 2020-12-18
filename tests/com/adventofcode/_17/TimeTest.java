package com.adventofcode._17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeTest {

    Time time;

    @BeforeEach
    void setUp() {
        time = Unmarshaller.getStartingTime(
                this.getClass().getResourceAsStream("testInput.txt")
        );
    }

    @Test
    void getActiveCubesCount() {
        assertEquals(5, time.getActiveCubesCount());
    }

    @Test
    void completeNCycles() {
        time.completeNCycles(6);
        assertEquals(848, time.getActiveCubesCount());
    }
}