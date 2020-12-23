package com.adventofcode._23;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = Unmarshaller.getGame(this.getClass().getResourceAsStream("testInput.txt"));
    }

    @Test
    void getOrder_0() {
        assertEquals("25467389", game.getOrder());
    }

    @Test
    void getOrder_10() {
        game.play(10);
        assertEquals("92658374", game.getOrder());
    }

    @Test
    void getOrder_100() {
        game.play(100);
        assertEquals("67384529", game.getOrder());
    }

    @Test
    void getTwoCupsAfterOneMultiplied() {
        Game extendedGame = Unmarshaller.getExtendedGame(this.getClass().getResourceAsStream("testInput.txt"));
        extendedGame.play(10_000_000);
        assertEquals(149245887792L, extendedGame.getTwoCupsAfterOneMultiplied());
    }
}