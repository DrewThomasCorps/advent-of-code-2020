package com.adventofcode._12;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Instruction> instructions = Unmarshaller.getInstructions(
                Main.class.getResourceAsStream("input.txt")
        );
        Boat boat = new Boat(instructions);
        System.out.printf("Part 1: %d%n", getManhattanDistanceAfterInstructions(boat));
        boat = new Boat(instructions);
        System.out.printf("Part 2: %d%n", getManhattanDistanceAfterWaypointInstructions(boat));
    }

    static int getManhattanDistanceAfterInstructions(Boat boat) {
        boat.followInstructions();
        return Math.abs(boat.getXCoordinate()) + Math.abs(boat.getYCoordinate());
    }

    static int getManhattanDistanceAfterWaypointInstructions(Boat boat) {
        boat.followWaypointInstructions();
        return Math.abs(boat.getXCoordinate()) + Math.abs(boat.getYCoordinate());
    }
}
