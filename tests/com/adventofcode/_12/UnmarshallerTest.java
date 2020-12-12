package com.adventofcode._12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnmarshallerTest {

    @Test
    void getInstructions() {
        List<Instruction> instructions = Unmarshaller.getInstructions(
                this.getClass().getResourceAsStream("testInput.txt")
        );
        assertEquals(Instruction.ACTION.FORWARD, instructions.get(0).action);
        assertEquals(Instruction.ACTION.RIGHT, instructions.get(3).action);
        assertEquals(10, instructions.get(0).amount);
        assertEquals(11, instructions.get(4).amount);
    }
}