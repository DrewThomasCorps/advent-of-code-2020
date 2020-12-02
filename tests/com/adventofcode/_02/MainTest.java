package com.adventofcode._02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class MainTest {
    static List<PasswordPolicy> passwordPolicies;

    @BeforeAll
    static void setUp() {
        passwordPolicies = Unmarshaller.unmarshall(MainTest.class.getResourceAsStream("testInput.txt"));
    }

    @Test
    void getValidPasswordCounts() {
        Assertions.assertEquals(2, Main.getValidPasswordCounts(passwordPolicies));
    }

    @Test
    void getNewValidPasswordCounts() {
        Assertions.assertEquals(1, Main.getNewValidPasswordCounts(passwordPolicies));
    }

}