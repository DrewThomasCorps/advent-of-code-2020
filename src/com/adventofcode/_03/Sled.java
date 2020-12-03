package com.adventofcode._03;

public class Sled {
    private Coordinate currentCoordinate = new Coordinate(0, 0);
    private final int slopeRight;
    private final int slopeDown;

    public Sled(int slopeRight, int slopeDown) {

        this.slopeRight = slopeRight;
        this.slopeDown = slopeDown;
    }

    public Coordinate getNextCoordinate() {
        currentCoordinate = new Coordinate(
                currentCoordinate.right + slopeRight,
                currentCoordinate.down + slopeDown
        );
        return currentCoordinate;
    }
}
