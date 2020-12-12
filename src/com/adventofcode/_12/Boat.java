package com.adventofcode._12;

import java.util.List;

public class Boat {
    private final Direction direction = new Direction(Direction.CARDINAL.EAST);
    private final List<Instruction> instructions;
    private final Waypoint waypoint = new Waypoint(10, 1);

    private int xCoordinate = 0;
    private int yCoordinate = 0;

    public Boat(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    void followInstructions() {
        instructions.forEach(this::executeInstruction);
    }

    void followWaypointInstructions() {
        instructions.forEach(this::executeWaypointInstruction);
    }

    int getXCoordinate() {
        return xCoordinate;
    }

    int getYCoordinate() {
        return yCoordinate;
    }

    private void executeInstruction(Instruction instruction) {
        switch (instruction.action) {
            case NORTH -> moveDirectionAmount(Direction.CARDINAL.NORTH, instruction.amount);
            case SOUTH -> moveDirectionAmount(Direction.CARDINAL.SOUTH, instruction.amount);
            case EAST -> moveDirectionAmount(Direction.CARDINAL.EAST, instruction.amount);
            case WEST -> moveDirectionAmount(Direction.CARDINAL.WEST, instruction.amount);
            case LEFT -> direction.turnLeftDegrees(instruction.amount);
            case RIGHT -> direction.turnRightDegrees(instruction.amount);
            case FORWARD -> moveDirectionAmount(direction.getCurrentDirection(), instruction.amount);
        }
    }

    private void executeWaypointInstruction(Instruction instruction) {
        if (instruction.action == Instruction.ACTION.FORWARD) {
            this.xCoordinate += waypoint.getXCoordinate() * instruction.amount;
            this.yCoordinate += waypoint.getYCoordinate() * instruction.amount;
        } else {
            waypoint.executeInstruction(instruction);
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


}
