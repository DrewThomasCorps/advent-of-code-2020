package com.adventofcode._08;

import java.util.List;

public class BootCode {
    private List<Instruction> instructions;
    private int accumulator = 0;
    private int currentInstructionIndex = 0;

    void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    int runSafe() {
        try {
            executeCurrentInstruction();
        } catch (IllegalStateException exception) {
            // Expected to create infinite loop
        }
        return accumulator;
    }

    int runCleaner() {
        for (Instruction instruction : instructions) {
            if (instruction.getOperation() == OPERATION.ACCUMULATE) {
                continue;
            }
            flipInstructionOperation(instruction);
            reset();
            try {
                return run();
            } catch (Exception exception) {
                // Wrong instruction flipped
                flipInstructionOperation(instruction);
            }
        }
        return -1;
    }

    void executeCurrentInstruction() {
        if (currentInstructionIndex < instructions.size()) {
            instructions.get(currentInstructionIndex).execute();
        }
        if (currentInstructionIndex > instructions.size()) {
            // Expect to end at instruction.size, but not greater
            throw new IllegalStateException("Instruction not available");
        }
    }

    void executeNextInstruction() {
        currentInstructionIndex++;
        executeCurrentInstruction();

    }

    void addToCurrentInstructionIndex(int amount) {
        currentInstructionIndex += amount;
    }

    void addToAccumulator(int amount) {
        accumulator += amount;
    }

    private int run() {
        executeCurrentInstruction();
        return accumulator;
    }

    private void flipInstructionOperation(Instruction instruction) {
        if (instruction.getOperation() == OPERATION.NO_OPERATION) {
            instruction.setOperation(OPERATION.JUMP);
        } else if (instruction.getOperation() == OPERATION.JUMP) {
            instruction.setOperation(OPERATION.NO_OPERATION);
        }
    }

    private void reset() {
        accumulator = 0;
        currentInstructionIndex = 0;
        instructions.forEach(Instruction::reset);
    }
}
