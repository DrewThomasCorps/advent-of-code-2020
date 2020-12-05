package com.adventofcode._04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UnmarshallerTest {

    @Test
    void getPassportsCountIsCorrect() {
        List<Passport> passports = Unmarshaller.getPassports(this.getClass().getResourceAsStream("testInput.txt"));
        Assertions.assertEquals(4, passports.size());
    }

    @Test
    void getPassportsAddsCorrectFields() {
        List<Passport> passports = Unmarshaller.getPassports(this.getClass().getResourceAsStream("testInput.txt"));
        Assertions.assertTrue(passports.get(0).hasField("cid"));
        Assertions.assertTrue(passports.get(0).hasField("eyr"));
        Assertions.assertFalse(passports.get(0).hasField("2020"));

        Assertions.assertFalse(passports.get(2).hasField("cid"));
        Assertions.assertTrue(passports.get(0).hasField("eyr"));
        Assertions.assertFalse(passports.get(0).hasField("2020"));
    }
}