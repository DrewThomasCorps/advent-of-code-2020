package com.adventofcode._15;

public class Main {
    public static void main(String[] args) {
        MemoryGame memoryGame = Unmarshaller.getMemoryGame(
                Main.class.getResourceAsStream("input.txt")
        );
        System.out.printf("Part 1: %d%n", memoryGame.getNumberOnTurn((long) 2020));
        // No need to reset the memory game, it's stored the 2020th turn
        System.out.printf("Part 2: %d%n", memoryGame.getNumberOnTurn((long) 30000000));
    }
}
