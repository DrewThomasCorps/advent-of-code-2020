package com.adventofcode._22;

public class Main {
    public static void main(String[] args) {
        Game game = Unmarshaller.getGame(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 1: %d%n", game.getWinningScore());
        RecursiveGame recursiveGame = Unmarshaller.getRecursiveGame(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 2: %d%n", recursiveGame.getWinningScore());
    }
}
