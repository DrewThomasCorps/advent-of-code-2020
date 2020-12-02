package com.adventofcode._02;

public class PasswordPolicy {
    private final Policy policy;
    private final String password;

    PasswordPolicy(Policy policy, String password) {
        this.policy = policy;
        this.password = password;
    }

    public Boolean passwordIsValid() {
        return policy.stringIsValid(password);
    }

    public Boolean passwordPositionsIsValid() {
        return policy.characterPositionsAreValid(password);
    }
}
