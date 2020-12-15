package com.adventofcode._15;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryGameTest {

    @Test
    void getNumberOnTurn_ZeroThreeSix() {
        MemoryGame memoryGame = new MemoryGame(Arrays.asList((long) 0, (long) 3, (long) 6));
        assertEquals(436, memoryGame.getNumberOnTurn((long) 2020));
        assertEquals(175594, memoryGame.getNumberOnTurn((long) 30000000));
    }

    @Test
    void getNumberOnTurn_OneThreeTwo() {
        MemoryGame memoryGame = new MemoryGame(Arrays.asList((long) 1, (long) 3, (long) 2));
        assertEquals(1, memoryGame.getNumberOnTurn((long) 2020));
    }

    @Test
    void getNumberOnTurn_ThreeOneTwo() {
        MemoryGame memoryGame = new MemoryGame(Arrays.asList((long) 3, (long) 1, (long) 2));
        assertEquals(1836, memoryGame.getNumberOnTurn((long) 2020));
    }


}