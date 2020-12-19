package com.adventofcode._18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {

    @Test
    void evaluateExpression() {
        Expression expression = new Expression("2 * 3 + (4 * 5)");
        assertEquals(26, expression.evaluateExpression());
        expression = new Expression("5 + (8 * 3 + 9 + 3 * 4 * 3)");
        assertEquals(437, expression.evaluateExpression());
        expression = new Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2");
        assertEquals(13632, expression.evaluateExpression());
    }

    @Test
    void evaluatePrecedenceExpression() {
        Expression expression = new Expression("2 * 3 + (4 * 5)");
        assertEquals(46, expression.evaluatePrecedenceExpression());
        expression = new Expression("5 + (8 * 3 + 9 + 3 * 4 * 3)");
        assertEquals(1445, expression.evaluatePrecedenceExpression());
        expression = new Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2");
        assertEquals(23340, expression.evaluatePrecedenceExpression());
    }
}