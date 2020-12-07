package com.adventofcode._07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    static Bag one = new Bag();
    static Bag two = new Bag();
    static Bag three = new Bag();

    @BeforeAll
    static void setUp() {
        one.addBagRule(two, 4);
        two.addBagRule(three, 2);
    }

    @Test
    void hasBagDescendentGrandchild() {
        assertTrue(one.hasBagDescendent(three));
        assertFalse(three.hasBagDescendent(one));
    }

    @Test
    void getChildrenBagsCount() {
        // 4 two bags + (4 * 2 three bags)
        Assertions.assertEquals(12, one.getChildrenBagsCount());
    }
}