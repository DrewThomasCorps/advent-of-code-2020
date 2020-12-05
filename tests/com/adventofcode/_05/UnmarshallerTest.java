package com.adventofcode._05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class UnmarshallerTest {

    private static List<Seat> seats;

    @BeforeAll
    static void setUp() {
        seats = Unmarshaller.getSeats(UnmarshallerTest.class.getResourceAsStream("testInput.txt"));
    }

    @Test
    void getSeatsRows() {
        Assertions.assertEquals(70, seats.get(0).getRow());
        Assertions.assertEquals(14, seats.get(1).getRow());
        Assertions.assertEquals(102, seats.get(2).getRow());
    }

    @Test
    void getSeatsColumns() {
        Assertions.assertEquals(7, seats.get(0).getColumn());
        Assertions.assertEquals(7, seats.get(1).getColumn());
        Assertions.assertEquals(4, seats.get(2).getColumn());
    }

    @Test
    void getSeatsIds() {
        Assertions.assertEquals(567, seats.get(0).getId());
        Assertions.assertEquals(119, seats.get(1).getId());
        Assertions.assertEquals(820, seats.get(2).getId());
    }
}