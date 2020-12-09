package com.adventofcode._07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    static Map<String, Bag> bagsMap;

    @BeforeAll
    static void setUp() {
        bagsMap = Unmarshaller.getBagsMap(MainTest.class.getResourceAsStream("testInput.txt"));
    }

    @Test
    void testGetBagsCountWithBagDescendent() {
        assertEquals(4, Main.getBagsCountWithBagDescendent(bagsMap, bagsMap.get("shiny gold")));
    }

    @Test
    void testGetChildrenBagCount() {
        Map<String, Bag> bagsMap = Unmarshaller.getBagsMap(
                MainTest.class.getResourceAsStream("goldTestInput.txt")
        );
        assertEquals(126, bagsMap.get("shiny gold").getChildrenBagsCount());
    }
}