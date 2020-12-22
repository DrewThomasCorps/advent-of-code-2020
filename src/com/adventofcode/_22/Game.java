package com.adventofcode._22;

import java.util.Deque;

public class Game {
    Deque<Integer> playerOneDeck;
    Deque<Integer> playerTwoDeck;

    public Game(Deque<Integer> playerOneDeck, Deque<Integer> playerTwoDeck) {
        this.playerOneDeck = playerOneDeck;
        this.playerTwoDeck = playerTwoDeck;
    }

    long getWinningScore() {
        play();
        Deque<Integer> winningDeck = playerOneDeck.size() == 0 ? playerTwoDeck : playerOneDeck;
        long score = 0;
        int winningDeckSize = winningDeck.size();
        for (int i = 0; i < winningDeckSize; i++) {
            Integer nextCard = winningDeck.pop();
            score += (nextCard.longValue() * (winningDeckSize - i));
        }
        return score;
    }

    private void play() {
        while (playerOneDeck.size() != 0 && playerTwoDeck.size() != 0) {
            nextRound();
        }
    }

    private void nextRound() {
        Integer playerOneCard = playerOneDeck.pop();
        Integer playerTwoCard = playerTwoDeck.pop();
        if (playerOneCard > playerTwoCard) {
            playerOneDeck.add(playerOneCard);
            playerOneDeck.add(playerTwoCard);
        } else if (playerTwoCard > playerOneCard) {
            playerTwoDeck.add(playerTwoCard);
            playerTwoDeck.add(playerOneCard);
        } else {
            throw new IllegalStateException("Cards cannot be equal");
        }
    }
}
