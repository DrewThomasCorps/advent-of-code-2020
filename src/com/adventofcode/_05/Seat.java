package com.adventofcode._05;

import java.util.List;

public class Seat {

    private final int row;
    private final int column;

    public Seat(List<Boolean> rowShouldTakeUppers, List<Boolean> columnShouldTakeUppers) {
        this.row = getBinarySpacePartition(rowShouldTakeUppers);
        this.column = getBinarySpacePartition(columnShouldTakeUppers);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getId() {
        return (row * 8) + column;
    }

    private int getBinarySpacePartition(List<Boolean> shouldTakeUppers) {
        int min = 0;
        int max = (int) Math.pow(2, shouldTakeUppers.size()) - 1;
        for (Boolean shouldTakeUpper : shouldTakeUppers) {
            if (shouldTakeUpper) {
                min = (int) Math.ceil(((min + max) / 2.0));
            } else {
                max = (min + max) / 2;
            }
        }
        // Min and max are equal at the end, can return either
        return max;
    }
}
