package com.adventofcode._12;

public class Instruction {
    enum ACTION {
        NORTH,
        SOUTH,
        EAST,
        WEST,
        LEFT,
        RIGHT,
        FORWARD
    }

    final ACTION action;
    final int amount;

    Instruction(ACTION action, int amount) {
        this.action = action;
        this.amount = amount;
    }
}
