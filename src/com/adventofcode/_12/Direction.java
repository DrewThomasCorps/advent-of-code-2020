package com.adventofcode._12;

public class Direction {
    enum CARDINAL {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    enum ACTION {
        LEFT,
        RIGHT
    }

    private CARDINAL currentDirection;

    Direction(CARDINAL currentDirection) {
        this.currentDirection = currentDirection;
    }

    CARDINAL getCurrentDirection() {
        return currentDirection;
    }

    void turnRightDegrees(int degrees) {
        turnDirectionDegrees(ACTION.RIGHT, degrees);
    }

    void turnLeftDegrees(int degrees) {
        turnDirectionDegrees(ACTION.LEFT, degrees);
    }

    private void turnDirectionDegrees(ACTION action, int degrees) {
        if (degrees % 90 != 0) {
            throw new IllegalArgumentException("Can only turn multiple of 90 degrees");
        }
        for (int i = 0; i < degrees / 90; i++) {
            switch (action) {
                case LEFT -> turnLeft();
                case RIGHT -> turnRight();
            }
        }
    }

    private void turnLeft() {
        switch (this.currentDirection) {
            case NORTH -> this.currentDirection = CARDINAL.WEST;
            case SOUTH -> this.currentDirection = CARDINAL.EAST;
            case EAST -> this.currentDirection = CARDINAL.NORTH;
            case WEST -> this.currentDirection = CARDINAL.SOUTH;
        }
    }

    private void turnRight() {
        switch (this.currentDirection) {
            case NORTH -> this.currentDirection = CARDINAL.EAST;
            case SOUTH -> this.currentDirection = CARDINAL.WEST;
            case EAST -> this.currentDirection = CARDINAL.SOUTH;
            case WEST -> this.currentDirection = CARDINAL.NORTH;
        }
    }
}
