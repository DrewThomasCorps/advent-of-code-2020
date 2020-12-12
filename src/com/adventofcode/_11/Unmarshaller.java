package com.adventofcode._11;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Unmarshaller {
    public static List<List<WaitingArea.OBJECT>> getFloorPlan(InputStream inputStream) {
        List<List<WaitingArea.OBJECT>> floorPlan = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<WaitingArea.OBJECT> row = line.chars().mapToObj((input) -> switch (input) {
                case '.' -> WaitingArea.OBJECT.FLOOR;
                case 'L' -> WaitingArea.OBJECT.EMPTY_SEAT;
                case '#' -> WaitingArea.OBJECT.OCCUPIED_SEAT;
                default -> throw new IllegalArgumentException(String.format("%c is not a legal character", input));
            }).collect(Collectors.toList());
            floorPlan.add(row);
        }
        return floorPlan;
    }
}
