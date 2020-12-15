package com.adventofcode._14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModernComputerTest {

    @Test
    void getSumOfMemoryValues() {
        ModernComputer modernComputer = new ModernComputer(
                this.getClass().getResourceAsStream("floatingInput.txt")
        );
        assertEquals(208, modernComputer.getSumOfMemoryValues());
    }
}