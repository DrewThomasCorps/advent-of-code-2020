package com.adventofcode._03;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Forest forest = Unmarshaller.getForest(Main.class.getResourceAsStream("input.txt"));
        Sled sled = new Sled(3, 1);
        System.out.printf("Part 1: %d%n", treesHitInForestWithSledCount(forest, sled));
        List<int[]> slopeList = Arrays.asList(new int[][]{{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}});
        System.out.printf("Part 2: %d%n", multiplicationOfTreesHitAtSlopes(forest, slopeList));
    }

    public static int treesHitInForestWithSledCount(Forest forest, Sled sled) {
        Coordinate coordinate = sled.getNextCoordinate();
        int treesHit = 0;
        while (forest.contains(coordinate)) {
            treesHit += forest.hasTreeAtCoordinate(coordinate) ? 1 : 0;
            coordinate = sled.getNextCoordinate();
        }
        return treesHit;
    }

    // Could refactor int[] to a Vector class
    public static long multiplicationOfTreesHitAtSlopes(Forest forest, List<int[]> slopesList) {
        long multiple = 1;
        for (int[] slopes : slopesList) {
            Sled sled = new Sled(slopes[0], slopes[1]);
            multiple *= treesHitInForestWithSledCount(forest, sled);
        }
        return multiple;
    }
}
