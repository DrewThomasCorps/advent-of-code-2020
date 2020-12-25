package com.adventofcode._25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void getLoopSize() {
        assertEquals(8, Main.getLoopSize(5764801));
    }

    @Test
    void applyLoop() {
        long value = 1;
        for (int i = 0; i < 8; i++) {
            value = Main.applyLoop(value, 17807724);
        }
        assertEquals(14897079, value);
    }
}