package com.adventofcode._10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    static List<Integer> smallSortedList;
    static List<Integer> largeSortedList;

    @BeforeAll
    static void setUp() {
        smallSortedList = Unmarshaller.getSortedInput(
                MainTest.class.getResourceAsStream("smallTestInput.txt")
        );
        largeSortedList = Unmarshaller.getSortedInput(
                MainTest.class.getResourceAsStream("largeTestInput.txt")
        );
    }

    @Test
    void getJoltageDistributionDifference() {
        assertEquals(35, Main.getJoltageDistributionDifference(smallSortedList));
        assertEquals(220, Main.getJoltageDistributionDifference(largeSortedList));
    }

    @Test
    void getPossibleCombinations() {
        assertEquals(8, Main.getPossibleCombinations(smallSortedList));
        assertEquals(19208, Main.getPossibleCombinations(largeSortedList));
    }
}