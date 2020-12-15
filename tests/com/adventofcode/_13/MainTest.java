package com.adventofcode._13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    BusStop busStop;
    BusStop smallBusStop;
    BusStop first;
    BusStop second;
    BusStop third;
    BusStop fourth;
    BusStop fifth;

    @BeforeEach
    void setUp() {
        busStop = Unmarshaller.getBusStop(
                this.getClass().getResourceAsStream("testInput.txt")
        );
        smallBusStop = Unmarshaller.getBusStop(
                this.getClass().getResourceAsStream("smallInput.txt")
        );
        first = Unmarshaller.getBusStop(
                this.getClass().getResourceAsStream("first.txt")
        );
        second = Unmarshaller.getBusStop(
                this.getClass().getResourceAsStream("second.txt")
        );
        third = Unmarshaller.getBusStop(
                this.getClass().getResourceAsStream("third.txt")
        );
        fourth = Unmarshaller.getBusStop(
                this.getClass().getResourceAsStream("fourth.txt")
        );
        fifth = Unmarshaller.getBusStop(
                this.getClass().getResourceAsStream("fifth.txt")
        );
    }

    @Test
    void getBusIdMultipliedByWaitedMinutes() {
        assertEquals(295, Main.getBusIdMultipliedByWaitedMinutes(busStop));
    }

    @Test
    void getEarliestSequentialTimestamp() {
        assertEquals(3417, first.getSequentialFirstBusDepartureTime());
        assertEquals(1068781, busStop.getSequentialFirstBusDepartureTime());
        assertEquals(754018, second.getSequentialFirstBusDepartureTime());
        assertEquals(779210, third.getSequentialFirstBusDepartureTime());
        assertEquals(1261476, fourth.getSequentialFirstBusDepartureTime());
        assertEquals(1202161486, fifth.getSequentialFirstBusDepartureTime());
    }

    @Test
    void getSmallEarliestSequentialTimestamp() {
        assertEquals(26, smallBusStop.getSequentialFirstBusDepartureTime());
    }
}