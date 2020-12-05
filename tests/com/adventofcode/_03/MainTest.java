package com.adventofcode._03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MainTest {

    private static Forest forest;

    @BeforeAll
    static void setUp() {
        forest = Unmarshaller.getForest(MainTest.class.getResourceAsStream("testInput.txt"));
    }

    @Test
    void treesHitInForestWithSledCount() {
        Sled sled = new Sled(3, 1);
        Assertions.assertEquals(7, Main.treesHitInForestWithSledCount(forest, sled));
    }


    @Test
    void multiplicationOfTreesHitAtSlopes() {
        List<int[]> slopeList = Arrays.asList(new int[][]{{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}});
        Assertions.assertEquals(336, Main.multiplicationOfTreesHitAtSlopes(forest, slopeList));
    }
}