package com.adventofcode._06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private static List<CustomsDeclaration> customsDeclarations;

    @BeforeAll
    static void setUp() {
        customsDeclarations = Unmarshaller.getCustomDeclarations(
                MainTest.class.getResourceAsStream("testInput.txt")
        );
    }

    @Test
    void testSumYesQuestions() {
        assertEquals(11, Main.sumOfYesQuestions(customsDeclarations));
    }

    @Test
    void testSumIntersectionYesQuestions() {
        assertEquals(6, Main.sumIntersectionYesQuestions(customsDeclarations));
    }

}