package com.adventofcode._09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnmarshallerTest {

    @Test
    void getInput() {
        List<Long> input = Unmarshaller.getInput(this.getClass().getResourceAsStream("testInput.txt"));
        assertEquals(35, input.get(0));
        assertEquals(20, input.get(1));
        assertEquals(576, input.get(input.size() - 1));
    }
}