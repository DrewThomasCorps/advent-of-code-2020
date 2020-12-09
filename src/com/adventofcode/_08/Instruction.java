package com.adventofcode._08;

public class Instruction {
    private OPERATION operation;
    private final Integer argument;
    private final BootCode bootCode;
    private boolean executed = false;

    Instruction(OPERATION operation, Integer argument, BootCode bootCode) {
        this.operation = operation;
        this.argument = argument;
        this.bootCode = bootCode;
    }

    void execute() {
        if (executed) {
            throw new IllegalStateException("Cannot execute instruction again, will enter loop condition");
        }
        executed = true;
        switch (operation) {
            case ACCUMULATE -> {
                bootCode.addToAccumulator(argument);
                bootCode.executeNextInstruction();
            }
            case JUMP -> {
                bootCode.addToCurrentInstructionIndex(argument);
                bootCode.executeCurrentInstruction();
            }
            case NO_OPERATION -> {
                bootCode.executeNextInstruction();
            }
        }
    }

    OPERATION getOperation() {
        return operation;
    }

    void setOperation(OPERATION operation) {
        this.operation = operation;
    }

    void reset() {
        executed = false;
    }
}
