package com.adventofcode._18;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Expression> expressions = Unmarshaller.getExpressions(
                Main.class.getResourceAsStream("input.txt")
        );
        System.out.printf("Part 1: %d%n", getSum(expressions));
        System.out.printf("Part 2: %d%n", getPrecedenceSum(expressions));
    }

    static long getSum(List<Expression> expressions) {
        return expressions.stream().mapToLong(Expression::evaluateExpression).sum();
    }

    static long getPrecedenceSum(List<Expression> expressions) {
        return expressions.stream().mapToLong(Expression::evaluatePrecedenceExpression).sum();
    }
}
