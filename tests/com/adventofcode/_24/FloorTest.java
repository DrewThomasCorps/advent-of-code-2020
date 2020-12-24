package com.adventofcode._24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FloorTest {

    Floor floor;

    @BeforeEach
    void setUp() {
        floor = Unmarshaller.getFloor(this.getClass().getResourceAsStream("testInput.txt"));
    }

    @Test
    void countBlackTiles() {
        assertEquals(10, floor.getBlackTilesCount());
    }

    @Test
    void countBlackTiles_1() {
        floor.simulateDays(1);
        assertEquals(15, floor.getBlackTilesCount());
    }

    @Test
    void countBlackTiles_10() {
        floor.simulateDays(10);
        assertEquals(37, floor.getBlackTilesCount());
    }

    @Test
    void countBlackTiles_100() {
        floor.simulateDays(100);
        assertEquals(2208, floor.getBlackTilesCount());
    }
}