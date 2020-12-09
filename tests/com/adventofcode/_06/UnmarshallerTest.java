package com.adventofcode._06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnmarshallerTest {

    private static List<CustomsDeclaration> customsDeclarations;

    @BeforeAll
    static void setUp() {
        customsDeclarations = Unmarshaller.getCustomDeclarations(
                UnmarshallerTest.class.getResourceAsStream("testInput.txt")
        );
    }

    @Test
    void getCustomDeclarations() {
        assertEquals(3, customsDeclarations.get(0).getYesQuestionsCount());
        assertEquals(3, customsDeclarations.get(2).getYesQuestionsCount());
        assertEquals(1, customsDeclarations.get(4).getYesQuestionsCount());
    }
}