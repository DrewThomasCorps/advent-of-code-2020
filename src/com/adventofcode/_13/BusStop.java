package com.adventofcode._13;

import java.util.Comparator;
import java.util.List;

public class BusStop {
    private final double earliestDeparture;
    private final List<Bus> buses;

    BusStop(double earliestDeparture, List<Bus> buses) {
        this.earliestDeparture = earliestDeparture;
        this.buses = buses;
    }

    public double getEarliestDeparture() {
        return earliestDeparture;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Bus getFirstBusToArrive() {
        return buses.stream()
                .min(Comparator.comparingDouble((Bus a) -> a.getEarliestDepartureAfterTime(earliestDeparture)))
                .get();
    }

    public double getSequentialFirstBusDepartureTime() {
        long startTime = 0;
        long currentPeriodLength = 1;
        int timeAfterFirstBus = 0;
        for (Bus bus : buses) {
            timeAfterFirstBus += bus.getTimeAfterPreviousBus();
            long periodStart = timeWhenNumIsXGreaterThanNumAfterTime(
                    bus.getLoopTime(),
                    currentPeriodLength,
                    startTime,
                    timeAfterFirstBus,
                    startTime
            );
            long periodEnd = timeWhenNumIsXGreaterThanNumAfterTime(
                    bus.getLoopTime(),
                    currentPeriodLength,
                    startTime,
                    timeAfterFirstBus,
                    periodStart + 1
            );
            currentPeriodLength = periodEnd - periodStart;
            startTime = periodStart;
        }
        return startTime;
    }

    public long timeWhenNumIsXGreaterThanNumAfterTime(long num1Multiple, long num2Multiple,
                                                      long num2Offset, long x, long minTime) {
        long num2 = (long) (Math.ceil((minTime / (double) num2Multiple)) * num2Multiple + num2Offset);
        long num1 = (long) (Math.ceil((num2 / (double) num1Multiple))) * num1Multiple;
        while (num1 - num2 != x) {
            num2 += num2Multiple;
            num1 = (long) (Math.ceil((num2 / (double) num1Multiple))) * num1Multiple;
            while ((num1 - x) < num2) {
                num1 += num1Multiple;
            }
        }
        return num2;
    }
}
