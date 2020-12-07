package com.adventofcode._04;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportScanner {
    private final List<String> requiredFields;

    public PassportScanner(List<String> requiredFields) {
        this.requiredFields = requiredFields;
    }

    public boolean passportIsValid(Passport passport) {
        return requiredFields.stream().allMatch(passport::hasField);
    }

    public boolean passportIsValidStrict(Passport passport) {
        if (!passportIsValid(passport)) {
            return false;
        }
        if (isYearOutsideDates(passport.getField("byr"), 1920, 2002)) {
            return false;
        }
        if (isYearOutsideDates(passport.getField("iyr"), 2010, 2020)) {
            return false;
        }
        if (isYearOutsideDates(passport.getField("eyr"), 2020, 2030)) {
            return false;
        }
        String height = passport.getField("hgt");
        if (!heightIsValid(height)) {
            return false;
        }
        Pattern hairColorPattern = Pattern.compile("#[a-f0-9]{6}");
        Matcher hairColorMatcher = hairColorPattern.matcher(passport.getField("hcl"));
        if (!hairColorMatcher.matches()) {
            return false;
        }
        if (!eyeColorMatches(passport.getField("ecl"))) {
            return false;
        }
        return pidIsValid(passport.getField("pid"));
    }

    private boolean isYearOutsideDates(String year, int minimum, int maximum) {
        Pattern yearPattern = Pattern.compile("[\\d]{4}");
        Matcher yearMatcher = yearPattern.matcher(year);
        if (!yearMatcher.matches()) {
            return true;
        }
        int yearInteger = Integer.parseInt(year);
        return !numberIsBetweenValues(yearInteger, minimum, maximum);
    }

    private boolean numberIsBetweenValues(int number, int minimum, int maximum) {
        return number >= minimum && number <= maximum;
    }

    private boolean heightIsValid(String height) {
        Pattern heightPattern = Pattern.compile("([\\d]+)(cm|in)");
        Matcher heightMatcher = heightPattern.matcher(height);
        if (heightMatcher.matches()) {
            String unit = heightMatcher.group(2);
            int heightInteger = Integer.parseInt(heightMatcher.group(1));
            if (unit.equals("in")) {
                return numberIsBetweenValues(heightInteger, 59, 76);
            } else if (unit.equals("cm")) {
                return numberIsBetweenValues(heightInteger, 150, 193);
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean eyeColorMatches(String ecl) {
        Pattern pattern = Pattern.compile("amb|blu|brn|gry|grn|hzl|oth");
        Matcher matcher = pattern.matcher(ecl);
        return matcher.matches();
    }

    private boolean pidIsValid(String pid) {
        Pattern pattern = Pattern.compile("[\\d]{9}");
        Matcher matcher = pattern.matcher(pid);
        return matcher.matches();
    }
}
