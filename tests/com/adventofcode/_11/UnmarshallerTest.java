package com.adventofcode._11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnmarshallerTest {

    @Test
    void getFloorPlan() {
        List<List<WaitingArea.OBJECT>> waitingArea = Unmarshaller.getFloorPlan(
                this.getClass().getResourceAsStream("testInput.txt")
        );
        assertEquals(WaitingArea.OBJECT.EMPTY_SEAT, waitingArea.get(0).get(0));
        assertEquals(WaitingArea.OBJECT.FLOOR, waitingArea.get(0).get(1));
        assertEquals(WaitingArea.OBJECT.EMPTY_SEAT, waitingArea.get(0).get(9));
        assertEquals(WaitingArea.OBJECT.FLOOR, waitingArea.get(9).get(7));
    }
}