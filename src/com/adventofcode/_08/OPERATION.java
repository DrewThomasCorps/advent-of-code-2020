package com.adventofcode._08;

public enum OPERATION {
    ACCUMULATE, JUMP, NO_OPERATION;

    public static OPERATION getInstruction(String abbreviation) {
        return switch (abbreviation) {
            case "acc" -> ACCUMULATE;
            case "jmp" -> JUMP;
            case "nop" -> NO_OPERATION;
            default -> throw new IllegalArgumentException(String.format("Invalid abbreviation: %s", abbreviation));
        };
    }
}
