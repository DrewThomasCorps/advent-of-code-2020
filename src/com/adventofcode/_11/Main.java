package com.adventofcode._11;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<WaitingArea.OBJECT>> floorPlan = Unmarshaller.getFloorPlan(
                Main.class.getResourceAsStream("input.txt")
        );
        WaitingArea waitingArea = new WaitingArea(floorPlan);
        System.out.printf("Part 1: %d%n", waitingArea.getOccupiedSeatCountAfterStabilizes());
        WaitingArea secondWaitingArea = new WaitingArea(floorPlan);
        System.out.printf("Part 2: %d%n", secondWaitingArea.countOccupiedSeatsAfterVisibleStabilizes());
    }
}
