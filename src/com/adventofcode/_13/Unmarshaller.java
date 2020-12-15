package com.adventofcode._13;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Unmarshaller {
    static BusStop getBusStop(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<Bus> buses = new ArrayList<>();
        int earliestDeparture = Integer.parseInt(scanner.nextLine());
        String busLine = scanner.nextLine();
        String[] busStrings = busLine.split(",");
        int timeAfterPreviousBus = 0;
        for (String busString : busStrings) {
            if (busString.equals("x")) {
                timeAfterPreviousBus++;
            } else {
                Bus bus = new Bus(Integer.parseInt(busString), timeAfterPreviousBus);
                buses.add(bus);
                timeAfterPreviousBus = 1;
            }
        }
        return new BusStop(earliestDeparture, buses);
    }
}
