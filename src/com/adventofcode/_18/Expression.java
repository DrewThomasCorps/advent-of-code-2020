package com.adventofcode._18;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final String expression;
    private int expressionIndex = 0;

    private enum OPERATION {
        ADD,
        MULTIPLY
    }

    public Expression(String expression) {
        this.expression = expression;
    }

    long evaluateExpression() {
        long currentValue = 0;
        OPERATION operation = null;
        while (expressionIndex < expression.length()) {
            char character = expression.charAt(expressionIndex);
            expressionIndex++;
            switch (character) {
                case ' ':
                    break;
                case '(':
                    currentValue = calculate(currentValue, evaluateExpression(), operation);
                    break;
                case ')':
                    return currentValue;
                case '*':
                    operation = OPERATION.MULTIPLY;
                    break;
                case '+':
                    operation = OPERATION.ADD;
                    break;
                default:
                    currentValue = calculate(currentValue,
                            Integer.parseInt(String.valueOf(character)),
                            operation
                    );
            }
        }
        expressionIndex = 0; // Reset so can be recalculated
        return currentValue;
    }

    long evaluatePrecedenceExpression() {
        List<Long> multiplicities = new ArrayList<>();
        multiplicities.add((long) 1);
        long currentValue = 0;
        OPERATION operation = null;
        while (expressionIndex < expression.length()) {
            char character = expression.charAt(expressionIndex);
            expressionIndex++;
            switch (character) {
                case ' ':
                    break;
                case '(':
                    currentValue = calculate(currentValue, evaluatePrecedenceExpression(), operation);
                    break;
                case ')':
                    multiplicities.add(getValueToMultiply(currentValue));
                    return multiplyList(multiplicities);
                case '*':
                    multiplicities.add(currentValue);
                    currentValue = 0;
                    break;
                case '+':
                    operation = OPERATION.ADD;
                    break;
                default:
                    currentValue = calculate(currentValue,
                            Integer.parseInt(String.valueOf(character)),
                            operation
                    );
            }
        }
        expressionIndex = 0; // Reset so can be recalculated
        multiplicities.add(currentValue);
        return multiplyList(multiplicities);
    }

    private long getValueToMultiply(long value) {
        if (value == 0) {
            return 1;
        } else {
            return value;
        }
    }

    private long multiplyList(List<Long> multiplicities) {
        return multiplicities.stream().reduce((acc, value) -> acc *= value).get();
    }

    private long calculate(long accumulator, long value, OPERATION operation) {
        if (operation == null || accumulator == 0) {
            return value;
        }
        switch (operation) {
            case ADD -> accumulator += value;
            case MULTIPLY -> accumulator *= value;
        }
        return accumulator;
    }
}
