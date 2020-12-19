package com.adventofcode._19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RuleTest {

    Rule rule;

    @BeforeEach
    void setUp() {
        Rule five = new Rule('b');
        Rule four = new Rule('a');
        Rule three = new Rule(Arrays.asList(Arrays.asList(four, five), Arrays.asList(five, four)));
        Rule two = new Rule(Arrays.asList(Arrays.asList(four, four), Arrays.asList(five, five)));
        Rule one = new Rule(Arrays.asList(Arrays.asList(two, three), Arrays.asList(three, two)));
        rule = new Rule(Collections.singletonList(Arrays.asList(four, one, five)));
    }

    @Test
    void stringMatches() {
        assertTrue(rule.stringMatches("ababbb"));
        assertTrue(rule.stringMatches("abbbab"));
        assertFalse(rule.stringMatches("bababa"));
        assertFalse(rule.stringMatches("aaabbb"));
        assertFalse(rule.stringMatches("aaaabbb"));
    }
}