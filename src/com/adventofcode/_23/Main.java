package com.adventofcode._23;

public class Main {
    public static void main(String[] args) {
        Game game = Unmarshaller.getGame(Main.class.getResourceAsStream("input.txt"));
        game.play(100);
        System.out.printf("Part 1: %s%n", game.getOrder());
        Game extendedGame = Unmarshaller.getExtendedGame(Main.class.getResourceAsStream("input.txt"));
        extendedGame.play(10_000_000);
        System.out.printf("Part 1: %d%n", extendedGame.getTwoCupsAfterOneMultiplied());
    }
}
