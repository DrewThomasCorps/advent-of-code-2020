package com.adventofcode._10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnmarshallerTest {

    @Test
    void getSortedInput() {
        List<Integer> sortedList = Unmarshaller.getSortedInput(
                this.getClass().getResourceAsStream("smallTestInput.txt")
        );
        assertEquals(1, sortedList.get(0));
        assertEquals(19, sortedList.get(sortedList.size() - 1));
        assertEquals(4, sortedList.get(1));
        List<Integer> largeSortedList = Unmarshaller.getSortedInput(
                this.getClass().getResourceAsStream("largeTestInput.txt")
        );
    }
}