package com.adventofcode._08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnmarshallerTest {

    BootCode bootCode;

    @BeforeEach
    void setUp()
    {
        bootCode = Unmarshaller.getBootCode(UnmarshallerTest.class.getResourceAsStream("testInput.txt"));
    }

    @Test
    void testGetBootCode()
    {
        assertEquals(5, bootCode.runSafe());
    }

    @Test
    void testBootCodeCleaner()
    {
        assertEquals(8, bootCode.runCleaner());
    }

}