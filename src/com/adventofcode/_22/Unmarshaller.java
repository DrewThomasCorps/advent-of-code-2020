package com.adventofcode._22;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Unmarshaller {

    static Deque<Integer> playerOneDeck;
    static Deque<Integer> playerTwoDeck;

    static Game getGame(InputStream inputStream) {
        setUpDecks(inputStream);
        return new Game(playerOneDeck, playerTwoDeck);
    }

    static RecursiveGame getRecursiveGame(InputStream inputStream) {
        setUpDecks(inputStream);
        return new RecursiveGame(playerOneDeck, playerTwoDeck);
    }

    private static void setUpDecks(InputStream inputStream) {
        playerOneDeck = new ArrayDeque<>();
        playerTwoDeck = new ArrayDeque<>();
        Scanner scanner = new Scanner(inputStream);
        boolean playerOne = true;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Player 2")) {
                playerOne = false;
            }
            if (line.equals("") || line.contains("Player")) {
                continue;
            }
            Deque<Integer> deck = playerOne ? playerOneDeck : playerTwoDeck;
            deck.add(Integer.parseInt(line));
        }
    }
}
