package com.adventofcode._15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryGame {
    private final HashMap<Long, List<Long>> numberToTurnMap = new HashMap<>();
    private Long turnNumber = (long) 1;
    private Long previousNumber = null;

    MemoryGame(List<Long> startingNumbers) {
        startingNumbers.forEach(this::addNumberToMap);
    }

    Long getNumberOnTurn(Long turn) {
        while (turnNumber <= turn) {
            nextTurn();
        }
        return previousNumber;
    }

    private void addNumberToMap(Long number) {
        List<Long> turns = numberToTurnMap.getOrDefault(number, new ArrayList<>());
        turns.add(turnNumber);
        numberToTurnMap.put(number, turns);
        previousNumber = number;
        turnNumber++;
    }

    private void nextTurn() {
        List<Long> turnsPreviousNumberSpoken = numberToTurnMap.get(previousNumber);
        if (turnsPreviousNumberSpoken.size() == 1) {
            addNumberToMap((long) 0);
        } else {
            Long turnDifference = turnsPreviousNumberSpoken.get(turnsPreviousNumberSpoken.size() - 1)
                    - turnsPreviousNumberSpoken.get(turnsPreviousNumberSpoken.size() - 2);
            addNumberToMap(turnDifference);
        }
    }


}
