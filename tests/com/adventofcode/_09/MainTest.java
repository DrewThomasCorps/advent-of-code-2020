package com.adventofcode._09;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    static List<Long> inputList;

    @BeforeAll
    static void setUp() {
        inputList = Unmarshaller.getInput(MainTest.class.getResourceAsStream("testInput.txt"));
    }

    @Test
    void getFirstFailingInt() {
        Xmas xmas = new Xmas(5);
        assertEquals(127, Main.getFirstFailingLong(inputList, xmas));
    }

    @Test
    void getContiguousValuesThatAddToNumber() {
        List<Long> contiguousValues = Main.getContiguousValuesThatAddToNumber(inputList, (long) 127);
        assertEquals(15, contiguousValues.get(0));
        assertEquals(40, contiguousValues.get(contiguousValues.size() - 1));
    }

    @Test
    void getSumOfMinAndMaxValues() {
        List<Long> values = Arrays.asList((long) 15, (long) 25, (long) 47, (long) 40);
        assertEquals(62, Main.getSumOfMinAndMaxValues(values));
    }
}