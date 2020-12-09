package com.adventofcode._09;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Long> inputList = Unmarshaller.getInput(Main.class.getResourceAsStream("input.txt"));
        Xmas xmas = new Xmas(25);
        Long firstFailingLong = getFirstFailingLong(inputList, xmas);
        System.out.printf("Part 1: %d%n", firstFailingLong);
        List<Long> contiguousList = getContiguousValuesThatAddToNumber(inputList, firstFailingLong);
        assert contiguousList != null;
        System.out.printf("Part 2: %d%n", getSumOfMinAndMaxValues(contiguousList));
    }

    public static Long getFirstFailingLong(List<Long> inputList, Xmas xmas) {
        for (Long input : inputList) {
            try {
                xmas.addToQueue(input);
            } catch (IllegalArgumentException exception) {
                return input;
            }
        }
        return null;
    }

    public static List<Long> getContiguousValuesThatAddToNumber(List<Long> possibleList, Long number) {
        Queue<Long> contiguousValues = new ArrayDeque<>();
        Long neededNumber = number;
        for (Long currentNumber : possibleList) {
            if (currentNumber.equals(neededNumber)) {
                contiguousValues.add(currentNumber);
                neededNumber -= currentNumber;
            } else if (neededNumber > currentNumber) {
                contiguousValues.add(currentNumber);
                neededNumber -= currentNumber;
            } else {
                while (neededNumber < currentNumber) {
                    neededNumber += contiguousValues.remove();
                }
                contiguousValues.add(currentNumber);
                neededNumber -= currentNumber;
            }
            if (neededNumber == 0) {
                return new ArrayList<>(contiguousValues);
            }
        }
        return null;
    }

    public static Long getSumOfMinAndMaxValues(List<Long> values) {
        return values.stream().min(Comparator.comparingLong(Long::longValue)).get()
                + values.stream().max(Comparator.comparingLong(Long::longValue)).get();
    }
}
