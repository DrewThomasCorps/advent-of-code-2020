package com.adventofcode._12;

public class Waypoint {
    private int xCoordinate;
    private int yCoordinate;

    Waypoint(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    int getXCoordinate() {
        return xCoordinate;
    }

    int getYCoordinate() {
        return yCoordinate;
    }

    void executeInstruction(Instruction instruction) {
        switch (instruction.action) {
            case NORTH -> moveDirectionAmount(Direction.CARDINAL.NORTH, instruction.amount);
            case SOUTH -> moveDirectionAmount(Direction.CARDINAL.SOUTH, instruction.amount);
            case EAST -> moveDirectionAmount(Direction.CARDINAL.EAST, instruction.amount);
            case WEST -> moveDirectionAmount(Direction.CARDINAL.WEST, instruction.amount);
            case LEFT -> turnLeftDegrees(instruction.amount);
            case RIGHT -> turnRightDegrees(instruction.amount);
            case FORWARD -> throw new IllegalArgumentException("Waypoint does not have Forward instruction");
        }
    }

    private void moveDirectionAmount(Direction.CARDINAL direction, int amount) {
        switch (direction) {
            case NORTH -> yCoordinate += amount;
            case SOUTH -> yCoordinate -= amount;
            case EAST -> xCoordinate += amount;
            case WEST -> xCoordinate -= amount;
        }
    }

    void turnRightDegrees(int degrees) {
        turnDirectionDegrees(Direction.ACTION.RIGHT, degrees);
    }

    void turnLeftDegrees(int degrees) {
        turnDirectionDegrees(Direction.ACTION.LEFT, degrees);
    }

    private void turnDirectionDegrees(Direction.ACTION action, int degrees) {
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
        int temp = xCoordinate;
        xCoordinate = yCoordinate * -1;
        yCoordinate = temp;
    }

    private void turnRight() {
        int temp = xCoordinate;
        //noinspection SuspiciousNameCombination
        xCoordinate = yCoordinate;
        yCoordinate = temp * -1;
    }

}
