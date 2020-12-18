package com.adventofcode._17;

public class Main {
    public static void main(String[] args) {
        Space space = Unmarshaller.getStartingSpace(Main.class.getResourceAsStream("input.txt"));
        space.completeNCycles(6);
        System.out.printf("Part 1: %d%n", space.activeCubesCount());
        Time time = Unmarshaller.getStartingTime(Main.class.getResourceAsStream("input.txt"));
        time.completeNCycles(6);
        System.out.printf("Part 2: %d%n", time.getActiveCubesCount());
    }
}
