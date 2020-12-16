package com.adventofcode._16;

public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    boolean isNumberIn(int number) {
        return number >= min && number <= max;
    }
}
