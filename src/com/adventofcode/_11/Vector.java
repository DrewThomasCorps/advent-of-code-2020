package com.adventofcode._11;

public class Vector {
    private int row;
    private int column;

    private final int initialRow;
    private final int initialColumn;

    public Vector(int row, int column) {
        this.row = row;
        this.initialRow = row;
        this.column = column;
        this.initialColumn = column;
    }

    public void grow() {
        row += initialRow;
        column += initialColumn;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
