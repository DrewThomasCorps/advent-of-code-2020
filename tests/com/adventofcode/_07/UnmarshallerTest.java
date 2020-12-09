package com.adventofcode._07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UnmarshallerTest {

    static Map<String, Bag> bagHashMap;

    @BeforeAll
    static void setUp() {
        bagHashMap = Unmarshaller.getBagsMap(UnmarshallerTest.class.getResourceAsStream("testInput.txt"));
    }

    @Test
    void getBagsMap() {
        assertTrue(bagHashMap.containsKey("light red"));
        assertTrue(bagHashMap.containsKey("dotted black"));
        assertTrue(bagHashMap.get("shiny gold").hasBagDescendent(bagHashMap.get("dark olive")));
        assertTrue(bagHashMap.get("shiny gold").hasBagDescendent(bagHashMap.get("vibrant plum")));
    }
}