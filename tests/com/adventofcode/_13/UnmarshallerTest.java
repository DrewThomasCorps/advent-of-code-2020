package com.adventofcode._13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnmarshallerTest {

    BusStop busStop;

    @BeforeEach
    void setUp() {
        busStop = Unmarshaller.getBusStop(
                this.getClass().getResourceAsStream("testInput.txt")
        );
    }

    @Test
    void getBusStop() {
        assertEquals(939, busStop.getEarliestDeparture());
        assertEquals(7, busStop.getBuses().get(0).getId());
        assertEquals(19, busStop.getBuses().get(4).getId());
    }
}