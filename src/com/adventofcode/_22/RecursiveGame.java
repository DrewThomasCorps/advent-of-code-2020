package com.adventofcode._22;

import java.util.*;

public class RecursiveGame {
    private final Deque<Integer> playerOneDeck;
    private Deque<Integer> playerTwoDeck;

    private final List<Integer> playerOneStartingDeck;
    private final List<Integer> playerTwoStartingDeck;

    private final Set<RecursiveGame> pastRecursiveGames = new HashSet<>();

    public RecursiveGame(Deque<Integer> playerOneDeck, Deque<Integer> playerTwoDeck) {
        this.playerOneDeck = playerOneDeck;
        this.playerTwoDeck = playerTwoDeck;
        this.playerOneStartingDeck = new ArrayList<>(playerOneDeck);
        this.playerTwoStartingDeck = new ArrayList<>(playerTwoDeck);
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
        RecursiveGame thisGame = new RecursiveGame(new ArrayDeque<>(playerOneDeck), new ArrayDeque<>(playerTwoDeck));
        if (pastRecursiveGames.contains(thisGame)) {
            // Player one wins
            playerTwoDeck = new ArrayDeque<>();
            return;
        }
        pastRecursiveGames.add(thisGame);
        Integer playerOneCard = playerOneDeck.pop();
        Integer playerTwoCard = playerTwoDeck.pop();
        if (didPlayerOneWinRound(playerOneCard, playerTwoCard)) {
            playerOneDeck.add(playerOneCard);
            playerOneDeck.add(playerTwoCard);
        } else {
            playerTwoDeck.add(playerTwoCard);
            playerTwoDeck.add(playerOneCard);
        }
    }

    private boolean didPlayerOneWinRound(Integer playerOneCard, Integer playerTwoCard) {
        if (playerOneCard > playerOneDeck.size() || playerTwoCard > playerTwoDeck.size()) {
            return playerOneCard > playerTwoCard;
        } else {
            RecursiveGame subGame = new RecursiveGame(new ArrayDeque<>(
                    new ArrayList<>(playerOneDeck).subList(0, playerOneCard)
            ), new ArrayDeque<>(
                    new ArrayList<>(playerTwoDeck).subList(0, playerTwoCard)
            ));
            return subGame.didPlayerOneWinGame();
        }
    }

    private boolean didPlayerOneWinGame() {
        this.play();
        return playerTwoDeck.size() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursiveGame that = (RecursiveGame) o;
        return playerOneStartingDeck.equals(that.playerOneStartingDeck) && playerTwoStartingDeck.equals(that.playerTwoStartingDeck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerOneStartingDeck, playerTwoStartingDeck);
    }
}
