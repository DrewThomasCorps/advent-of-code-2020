package com.adventofcode._19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rule {
    private List<List<Rule>> subRules;
    private Character matchingCharacter;

    public Rule() {
        subRules = new ArrayList<>();
    }

    public Rule(List<List<Rule>> subRules) {
        this.subRules = subRules;
    }

    public Rule(Character matchingCharacter) {
        this.matchingCharacter = matchingCharacter;
    }

    void setSubRules(List<List<Rule>> subRules) {
        this.subRules = subRules;
    }

    void setMatchingCharacter(Character matchingCharacter) {
        this.matchingCharacter = matchingCharacter;
    }

    Boolean stringMatches(String string) {
        List<StringBuilder> matchingRemainingStrings = getPossibleUnmatchedStrings(
                Collections.singletonList(new StringBuilder(string))
        );
        for (StringBuilder matchingRemainingString : matchingRemainingStrings) {
            if (matchingRemainingString.length() == 0) {
                return true;
            }
        }
        return false;
    }

    List<StringBuilder> getPossibleUnmatchedStrings(List<StringBuilder> possibleUnmatchedStrings) {
        List<StringBuilder> possibleRemainingMatchingStrings = new ArrayList<>();
        for (StringBuilder possibleUnmatchedString : possibleUnmatchedStrings) {
            for (List<Rule> rules : subRules) {
                possibleRemainingMatchingStrings.addAll(matchRules(rules, new StringBuilder(possibleUnmatchedString)));
            }
        }
        return possibleRemainingMatchingStrings;
    }

    private List<StringBuilder> getRemainingMatchingStrings(StringBuilder stringBuilder) {
        List<StringBuilder> matches = new ArrayList<>();
        if (matchingCharacter != null) {
            StringBuilder remaining = matchCharacter(stringBuilder);
            if (remaining != null) {
                matches.add(remaining);
            }
        } else {
            for (List<Rule> rules : subRules) {
                List<StringBuilder> remainingMatchingStrings = matchRules(rules, new StringBuilder(stringBuilder));
                if (remainingMatchingStrings != null) {
                    matches.addAll(remainingMatchingStrings);
                }
            }
        }
        return matches;
    }

    private List<StringBuilder> matchRules(List<Rule> rules, StringBuilder stringBuilder) {
        List<StringBuilder> remainingMatches = new ArrayList<>(Collections.singletonList(stringBuilder));
        for (Rule rule : rules) {
            List<StringBuilder> nextRemainingMatches = new ArrayList<>();
            for (StringBuilder remainingMatch : remainingMatches) {
                nextRemainingMatches.addAll(rule.getRemainingMatchingStrings(remainingMatch));
            }
            remainingMatches = nextRemainingMatches;
        }
        return remainingMatches;
    }

    private StringBuilder matchCharacter(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) != matchingCharacter) {
            return null;
        }
        return stringBuilder.deleteCharAt(0);
    }
}
