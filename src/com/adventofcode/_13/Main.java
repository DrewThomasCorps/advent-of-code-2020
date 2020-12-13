package com.adventofcode._13;

public class Main {
    public static void main(String[] args) {
        BusStop busStop = Unmarshaller.getBusStop(
                Main.class.getResourceAsStream("input.txt")
        );
        System.out.printf("Part 1: %1$.0f%n", getBusIdMultipliedByWaitedMinutes(busStop));
        System.out.printf("Part 2: %1$.0f%n", busStop.getSequentialFirstBusDepartureTime());
    }

    static double getBusIdMultipliedByWaitedMinutes(BusStop busStop) {
        Bus bus = busStop.getFirstBusToArrive();
        double earliestDepartureTime = busStop.getEarliestDeparture();
        return (bus.getEarliestDepartureAfterTime(earliestDepartureTime) - earliestDepartureTime) * bus.getId();
    }

}
