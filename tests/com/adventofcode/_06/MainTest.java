package com.adventofcode._06;

import org.junit.jupiter.api.BeforeAll;

import java.io.InputStream;

class MainTest {

    @BeforeAll
    void setUp() {
        InputStream inputStream = MainTest.class.getResourceAsStream("testInput.txt");
    }
}