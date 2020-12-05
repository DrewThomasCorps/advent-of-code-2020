package com.adventofcode._04;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PassportScanner scanner = new PassportScanner(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
        List<Passport> passports = Unmarshaller.getPassports(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 1: %d%n", getValidPassportCount(scanner, passports));
        System.out.printf("Part 2: %d%n", getValidPassportStrictCount(scanner, passports));
    }

    public static long getValidPassportCount(PassportScanner scanner, List<Passport> passports) {
        return passports.stream().filter(scanner::passportIsValid).count();
    }

    public static long getValidPassportStrictCount(PassportScanner scanner, List<Passport> passports) {
        return passports.stream().filter(scanner::passportIsValidStrict).count();
    }
}
