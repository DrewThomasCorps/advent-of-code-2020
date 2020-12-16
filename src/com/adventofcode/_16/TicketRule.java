package com.adventofcode._16;

import java.util.List;

public class TicketRule {
    private final String name;
    private final List<Range> validRanges;


    public TicketRule(String name, List<Range> validRanges) {
        this.name = name;
        this.validRanges = validRanges;
    }

    protected TicketRule(TicketRule ticketRule) {
        this.name = ticketRule.name;
        this.validRanges = ticketRule.validRanges;
    }

    boolean isNumberValid(int number) {
        return validRanges.stream().anyMatch(range -> range.isNumberIn(number));
    }

    boolean nameStartsWithString(String string) {
        return name.startsWith(string);
    }
}
