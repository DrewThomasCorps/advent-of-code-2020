package com.adventofcode._01;

import java.util.*;

public class Main {
    private static final int TARGET_SUM = 2020;
    private static final ArrayList<Integer> input = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> input = getInput();
        System.out.printf("Part 1: %d%n", getMultipleForList(input));
        System.out.printf("Part 2: %d%n", getThreeSum(input));
    }

    public static Integer getMultipleForList(List<Integer> list) {
        HashSet<Integer> neededInteger = new HashSet<>();
        for (int inputValue : list) {
            if (neededInteger.contains(inputValue)) {
                return inputValue * (TARGET_SUM - inputValue);
            } else {
                neededInteger.add(TARGET_SUM - inputValue);
            }
        }
        return null;
    }

    public static Integer getThreeSum(List<Integer> list) {
        HashMap<Integer, List<Integer>> singleSumMap = new HashMap<>();
        HashMap<Integer, List<Integer>> doubleSumMap = new HashMap<>();
        for (int inputValue : list) {
            if (doubleSumMap.containsKey(inputValue)) {
                List<Integer> sumsList = doubleSumMap.get(inputValue);
                return sumsList.get(0) * sumsList.get(1) * inputValue;
            }
            for (Integer neededSum : singleSumMap.keySet()) {
                List<Integer> currentSumList = singleSumMap.get(neededSum);
                if (inputValue < neededSum) {
                    List<Integer> doubleSumList = new ArrayList<>(List.copyOf(currentSumList));
                    doubleSumList.add(inputValue);
                    doubleSumMap.put(neededSum - inputValue, doubleSumList);
                }
            }
            singleSumMap.put(TARGET_SUM - inputValue, Collections.singletonList(inputValue));
        }
        return null;
    }

    private static void setInput()
    {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        while (scanner.hasNextLine()) {
            Integer data = scanner.nextInt();
            input.add(data);
        }
    }

    private static List<Integer> getInput()
    {
        if (input.size() == 0) {
            setInput();
        }
        return input;
    }
}
