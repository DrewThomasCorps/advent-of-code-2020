package com.adventofcode._10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> sortedInput;

    public static void main(String[] args) {
        sortedInput = Unmarshaller.getSortedInput(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 1: %d%n", getJoltageDistributionDifference(sortedInput));
        System.out.printf("Part 2: %d%n", getPossibleCombinations(sortedInput));
    }

    // Could use a tree set to ensure it's sorted
    static Integer getJoltageDistributionDifference(List<Integer> sortedInput) {
        Integer currentJoltage = 0;
        Integer threeJoltDifferenceCount = 1; // Last one
        Integer oneJoltDifferenceCount = 0;

        for (Integer nextJoltage : sortedInput) {
            if (nextJoltage > currentJoltage + 3) {
                break;
            }
            if (nextJoltage - currentJoltage == 3) {
                threeJoltDifferenceCount++;
            } else if (nextJoltage - currentJoltage == 1) {
                oneJoltDifferenceCount++;
            }
            currentJoltage = nextJoltage;
        }
        return threeJoltDifferenceCount * oneJoltDifferenceCount;
    }

    static long getPossibleCombinations(List<Integer> sortedInput) {
        sortedInput.add(sortedInput.get(sortedInput.size() - 1) + 3);
        long possibleCombinations = 1;
        Integer currentJoltage = 0;
        List<Integer> currentFrame = new ArrayList<>();
        for (Integer nextJoltage : sortedInput) {
            if (nextJoltage - currentJoltage == 3) {
                possibleCombinations *= getPossibleCombinationsForFrame(currentFrame);
                currentFrame = new ArrayList<>();
            } else {
                currentFrame.add(currentJoltage);
            }
            currentJoltage = nextJoltage;
        }
        return possibleCombinations;
    }

    private static int getPossibleCombinationsForFrame(List<Integer> frame) {
        int possibleCombinations = 1;
        int maxFrameSize = 4;
        if (frame.size() > maxFrameSize) {
            throw new IllegalArgumentException(String.format("Does not account for frames of size > %d", maxFrameSize));
        }
        // Last element in frame must always be there. Only 1 of the previous 3 need to be
        if (frame.size() == 4) {
            possibleCombinations = 7;
        } // Last element in frame must always be there. The other 2 are options
        else if (frame.size() == 3) {
            possibleCombinations = 4;
        } // First element is optionsal
        else if (frame.size() == 2) {
            possibleCombinations = 2;
        }
        return possibleCombinations;
    }
}
