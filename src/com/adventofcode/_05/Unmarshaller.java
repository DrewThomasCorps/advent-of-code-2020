package com.adventofcode._05;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Unmarshaller {
    public static List<Seat> getSeats(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<Seat> seats = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String rowString = line.substring(0, 7);
            List<Boolean> rowShouldTakeUppers = areStringCharsExpectedChar(rowString, 'B');
            String colString = line.substring(7, 10);
            List<Boolean> colShouldTakeUppers = areStringCharsExpectedChar(colString, 'R');
            Seat seat = new Seat(rowShouldTakeUppers, colShouldTakeUppers);
            seats.add(seat);
        }
        return seats;
    }

    private static List<Boolean> areStringCharsExpectedChar(String string, char expectedChar) {
        IntStream intStream = string.chars();
        return intStream.mapToObj(
                (int i) -> i == expectedChar)
                .collect(Collectors.toList());
    }
}
