package com.adventofcode._14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {


    @Test
    void getSumOfMemoryValues() {
        Computer computer = new Computer(
                this.getClass().getResourceAsStream("testInput.txt")
        );
        assertEquals(165, computer.getSumOfMemoryValues());
    }
}