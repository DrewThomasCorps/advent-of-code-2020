package com.adventofcode._22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursiveGameTest {

    RecursiveGame game;
    RecursiveGame infinite;

    @BeforeEach
    void setUp() {
        game = Unmarshaller.getRecursiveGame(this.getClass().getResourceAsStream("testInput.txt"));
        infinite = Unmarshaller.getRecursiveGame(this.getClass().getResourceAsStream("infinite.txt"));
    }

    @Test
    void getWinningScore() {
        assertEquals(291, game.getWinningScore());
    }

    @Test
    void infiniteEnds() {
        infinite.getWinningScore();
    }
}