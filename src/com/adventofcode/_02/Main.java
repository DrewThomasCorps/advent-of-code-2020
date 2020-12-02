package com.adventofcode._02;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<PasswordPolicy> passwordPolicies = Unmarshaller.unmarshall(
                Main.class.getResourceAsStream("input.txt")
        );
        System.out.printf("Part 1: %d%n", getValidPasswordCounts(passwordPolicies));
        System.out.printf("Part 2: %d%n", getNewValidPasswordCounts(passwordPolicies));
    }

    public static int getValidPasswordCounts(List<PasswordPolicy> passwordPolicies) {
        return (int) passwordPolicies.stream().filter(PasswordPolicy::passwordIsValid).count();
    }

    public static int getNewValidPasswordCounts(List<PasswordPolicy> passwordPolicies) {
        return (int) passwordPolicies.stream().filter(PasswordPolicy::passwordPositionsIsValid).count();
    }

}
