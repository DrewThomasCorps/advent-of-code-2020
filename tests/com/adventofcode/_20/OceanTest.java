package com.adventofcode._20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OceanTest {

    Ocean ocean;

    @BeforeEach
    void setUp() {
        Assembler assembler = Unmarshaller.getAssembler(this.getClass().getResourceAsStream("testInput.txt"));
        ocean = new Ocean(assembler.getAssembledTile());
    }

    @Test
    void getMostSeaMonsterCount() {
        assertEquals(2, ocean.getMostSeaMonsterCount());
    }

    @Test
    void getWaterRoughness() {
        assertEquals(273, ocean.getWaterRoughness());
    }
}