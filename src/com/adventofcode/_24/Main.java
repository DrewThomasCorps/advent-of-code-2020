package com.adventofcode._24;


public class Main {
    public static void main(String[] args) {
        Floor floor = Unmarshaller.getFloor(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 1: %d%n", floor.getBlackTilesCount());
        floor.simulateDays(100);
        System.out.printf("Part 2: %d%n", floor.getBlackTilesCount());
    }
}
