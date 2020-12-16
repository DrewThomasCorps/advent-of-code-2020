package com.adventofcode._16;

import java.util.HashSet;
import java.util.Set;

public class PreciseTicketRule extends TicketRule {

    private final Set<Integer> possibleLocations;

    public PreciseTicketRule(TicketRule ticketRule, Set<Integer> possibleLocations) {
        super(ticketRule);
        this.possibleLocations = new HashSet<>(possibleLocations);
    }

    void removePossibleLocationIfNumberInvalid(Integer number, Integer location) {
        if (!isNumberValid(number)) {
            this.possibleLocations.remove(location);
        }
    }

    Integer possibleLocationsSize() {
        return possibleLocations.size();
    }

    Integer getLocation() {
        if (possibleLocations.size() != 1) {
            throw new IllegalStateException("Ticket has many possible locations");
        }
        return possibleLocations.iterator().next();
    }

    void removePossibleLocation(Integer location) {
        possibleLocations.remove(location);
    }
}
