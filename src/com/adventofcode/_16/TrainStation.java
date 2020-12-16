package com.adventofcode._16;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainStation {
    private final List<PreciseTicketRule> ticketRules;
    private final Ticket yourTicket;
    private final List<Ticket> nearbyTickets;

    public TrainStation(List<PreciseTicketRule> ticketRules, Ticket yourTicket, List<Ticket> nearbyTickets) {
        this.ticketRules = ticketRules;
        this.yourTicket = yourTicket;
        this.nearbyTickets = nearbyTickets;
    }

    Integer getTicketScanningErrorRate() {
        return nearbyTickets.stream().mapToInt(ticket -> ticket.getInvalidFieldSum(ticketRules)).sum();
    }

    Long getProductOfFieldsStartingWith(String prefix) {
        filterRuleLocations();
        return ticketRules.stream()
                .filter(ticketRule -> ticketRule.nameStartsWithString(prefix))
                .mapToLong(ticketRule -> yourTicket.getFieldValue(ticketRule.getLocation()))
                .reduce((acc, value) -> acc *= value).getAsLong();
    }

    private void filterRuleLocations() {
        List<Ticket> validTickets = this.getValidTickets();
        validTickets.forEach(ticket -> ticket.filterRules(ticketRules));
        int maxPossibleLocations = getTicketRulesMaxPossibleLocations();
        while (maxPossibleLocations != 1) {
            List<PreciseTicketRule> ticketRulesWithOneLocation = ticketRules.stream()
                    .filter(preciseTicketRule -> preciseTicketRule.possibleLocationsSize() == 1)
                    .collect(Collectors.toList());
            for (PreciseTicketRule ticketRule : ticketRules) {
                for (PreciseTicketRule singleLocationTicketRule : ticketRulesWithOneLocation) {
                    if (ticketRule != singleLocationTicketRule) {
                        ticketRule.removePossibleLocation(singleLocationTicketRule.getLocation());
                    }
                }
            }
            maxPossibleLocations = getTicketRulesMaxPossibleLocations();
        }
    }

    private Integer getTicketRulesMaxPossibleLocations() {
        return ticketRules.stream()
                .mapToInt(PreciseTicketRule::possibleLocationsSize)
                .max()
                .getAsInt();
    }

    private List<Ticket> getValidTickets() {
        List<Ticket> validTickets = new ArrayList<>();
        validTickets.add(yourTicket);
        validTickets.addAll(
                nearbyTickets.stream()
                        .filter(ticket -> ticket.isValid(ticketRules))
                        .collect(Collectors.toList()));
        return validTickets;
    }


}
