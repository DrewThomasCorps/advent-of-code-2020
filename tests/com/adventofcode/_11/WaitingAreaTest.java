package com.adventofcode._11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaitingAreaTest {

    @Test
    void getOccupiedSeatCountAfterStabilizes() {
        List<List<WaitingArea.OBJECT>> floorPlan = Unmarshaller.getFloorPlan(
                this.getClass().getResourceAsStream("testInput.txt")
        );
        WaitingArea waitingArea = new WaitingArea(floorPlan);
        assertEquals(37, waitingArea.getOccupiedSeatCountAfterStabilizes());
    }

    @Test
    void countOccupiedSeatsAfterVisibleStabilizes() {
        List<List<WaitingArea.OBJECT>> floorPlan = Unmarshaller.getFloorPlan(
                this.getClass().getResourceAsStream("testInput.txt")
        );
        WaitingArea waitingArea = new WaitingArea(floorPlan);
        assertEquals(26, waitingArea.countOccupiedSeatsAfterVisibleStabilizes());
    }
}