package com.adventofcode._16;

import java.util.List;

public class Ticket {
    List<Integer> fields;

    public Ticket(List<Integer> fields) {
        this.fields = fields;
    }

    Integer getFieldValue(Integer index) {
        return fields.get(index);
    }

    <T extends TicketRule> Integer getInvalidFieldSum(List<T> ticketRules) {
        return fields.stream()
                .filter(field -> !isFieldValidForAnyRules(field, ticketRules))
                .mapToInt(Integer::intValue)
                .sum();
    }

    <T extends TicketRule> boolean isValid(List<T> ticketRules) {
        return fields.stream()
                .allMatch(field -> isFieldValidForAnyRules(field, ticketRules));
    }

    void filterRules(List<PreciseTicketRule> ticketRules) {
        for (int i = 0; i < fields.size(); i++) {
            int finalI = i;
            ticketRules.forEach(ticketRule ->
                    ticketRule.removePossibleLocationIfNumberInvalid(fields.get(finalI), finalI)
            );
        }

    }

    private <T extends TicketRule> boolean isFieldValidForAnyRules(Integer field, List<T> ticketRules) {
        return ticketRules.stream()
                .anyMatch(
                        (ticketRule -> ticketRule.isNumberValid(field))
                );
    }
}
