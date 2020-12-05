package com.adventofcode._05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class MainTest {

    private static List<Seat> seats;

    @BeforeAll
    static void setUp() {
        seats = Unmarshaller.getSeats(MainTest.class.getResourceAsStream("testInput.txt"));
    }

    @Test
    void getMaxSeatId() {
        Assertions.assertEquals(820, Main.getMaxSeatId(seats));
    }
}