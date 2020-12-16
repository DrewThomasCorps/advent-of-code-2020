package com.adventofcode._16;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Unmarshaller {
    static TrainStation getTrainStation(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<TicketRule> ticketRules = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            ticketRules.add(getTicketRule(line));
        }
        Set<Integer> possibleLocations = new HashSet<>();
        for (int i = 0; i < ticketRules.size(); i++) {
            possibleLocations.add(i);
        }
        List<PreciseTicketRule> preciseTicketRules = ticketRules.stream()
                .map(ticketRule -> new PreciseTicketRule(ticketRule, possibleLocations))
                .collect(Collectors.toList());
        scanner.nextLine();
        Ticket yourTicket = getTicket(scanner.nextLine());
        scanner.nextLine();
        scanner.nextLine();
        List<Ticket> nearbyTickets = new ArrayList<>();
        while (scanner.hasNextLine()) {
            nearbyTickets.add(getTicket(scanner.nextLine()));
        }
        return new TrainStation(preciseTicketRules, yourTicket, nearbyTickets);
    }

    private static TicketRule getTicketRule(String ruleString) {
        String name = ruleString.substring(0, ruleString.indexOf(':'));
        String[] rangeStrings = ruleString.substring(ruleString.indexOf(':') + 1).split("or");
        List<Range> validRanges = new ArrayList<>();
        Arrays.stream(rangeStrings).forEach((String rangeString) -> {
            rangeString = rangeString.trim();
            int min = Integer.parseInt(rangeString.substring(0, rangeString.indexOf('-')));
            int max = Integer.parseInt(rangeString.substring(rangeString.indexOf('-') + 1));
            validRanges.add(new Range(min, max));
        });
        return new TicketRule(name, validRanges);
    }

    private static Ticket getTicket(String ticketString) {
        List<Integer> fields = Arrays.stream(ticketString.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return new Ticket(fields);
    }
}
