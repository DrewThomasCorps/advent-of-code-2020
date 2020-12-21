package com.adventofcode._20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void getCornersMultiplied() {
        Assembler assembler = Unmarshaller.getAssembler(this.getClass().getResourceAsStream("testInput.txt"));
        assertEquals(20899048083289L, Main.getCornersMultiplied(assembler));
    }

}