package com.adventofcode._04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static List<Passport> passports;
    private static PassportScanner scanner;

    @BeforeAll
    static void setUp(){
        passports = Unmarshaller.getPassports(MainTest.class.getResourceAsStream("testInput.txt"));
        scanner = new PassportScanner(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
    }

    @Test
    void getValidPassportCount() {
        Assertions.assertEquals(2, Main.getValidPassportCount(scanner, passports));
    }

    @Test
    void getValidPassportStrictCount() {
        List<Passport> validPassports = Unmarshaller.getPassports(MainTest.class.getResourceAsStream("validInput.txt"));
        Assertions.assertEquals(4, Main.getValidPassportStrictCount(scanner, validPassports));
    }

    @Test
    void getInvalidPassportStrictCount() {
        List<Passport> validPassports = Unmarshaller.getPassports(MainTest.class.getResourceAsStream("invalidInput.txt"));
        Assertions.assertEquals(0, Main.getValidPassportStrictCount(scanner, validPassports));
    }
}