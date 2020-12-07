package com.adventofcode._02;

public class Policy {
    private final int min;
    private final int max;
    private final char policyCharacter;

    Policy(int min, int max, char policyCharacter) {
        this.min = min;
        this.max = max;
        this.policyCharacter = policyCharacter;
    }

    Boolean stringIsValid(String string) {
        int charCount = 0;
        for (char stringCharacter : string.toCharArray()) {
            if (stringCharacter == policyCharacter) {
                charCount++;
            }
        }
        return charCount >= min && charCount <= max;
    }

    Boolean characterPositionsAreValid(String string) {
        return string.charAt(this.min - 1) == policyCharacter ^ string.charAt(this.max - 1) == policyCharacter;
    }
}
