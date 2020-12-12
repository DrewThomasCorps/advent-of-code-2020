package com.adventofcode._12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Boat boat;

    @BeforeEach
    void setUp() {
        List<Instruction> instructions = Unmarshaller.getInstructions(
                this.getClass().getResourceAsStream("testInput.txt")
        );
        boat = new Boat(instructions);
    }

    @Test
    void getManhattanDistanceAfterInstructions() {
        assertEquals(25, Main.getManhattanDistanceAfterInstructions(boat));
    }

    @Test
    void getManhattanDistanceAfterWaypointInstructions() {
        assertEquals(286, Main.getManhattanDistanceAfterWaypointInstructions(boat));
    }
}