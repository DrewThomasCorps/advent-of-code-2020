package com.adventofcode._05;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Seat> seats = Unmarshaller.getSeats(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 1: %d%n", getMaxSeatId(seats));
        System.out.printf("Part 2: %d%n", getMissingSeatId(seats));
    }

    public static int getMaxSeatId(List<Seat> seats) {
        //noinspection OptionalGetWithoutIsPresent
        return seats.stream().max(Comparator.comparingInt(Seat::getId)).get().getId();
    }

    // Potential Optimization Time: O(n log n) -> O(n)
    // Create a hash mapping row numbers to a bounded array of seats.
    // Once row size reaches 8, the row would be removed from the hashmap.
    // Could then iterate over remaining rows (3 theoretically possible) looking for missing column
    public static int getMissingSeatId(List<Seat> seats) {
        List<Seat> sortedSeats = seats.stream().sorted(Comparator.comparingInt(Seat::getId))
                .collect(Collectors.toList());
        Seat previousSeat = sortedSeats.get(0);
        for (Seat currentSeat : sortedSeats.subList(1, sortedSeats.size())) {
            if (currentSeat.getId() - previousSeat.getId() == 2) {
                return currentSeat.getId() - 1;
            }
            previousSeat = currentSeat;
        }
        return -1;
    }
}
