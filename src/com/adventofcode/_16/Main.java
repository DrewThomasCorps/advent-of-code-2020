package com.adventofcode._16;

public class Main {
    public static void main(String[] args) {
        TrainStation trainStation = Unmarshaller.getTrainStation(
                Main.class.getResourceAsStream("input.txt")
        );
        System.out.printf("Part 1: %d%n", trainStation.getTicketScanningErrorRate());
        System.out.printf("Part 2: %d%n", trainStation.getProductOfFieldsStartingWith("departure"));
    }
}
