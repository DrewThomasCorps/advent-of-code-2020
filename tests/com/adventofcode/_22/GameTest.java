package com.adventofcode._22;

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
    void getWinningScore() {
        assertEquals(306, game.getWinningScore());
    }
}