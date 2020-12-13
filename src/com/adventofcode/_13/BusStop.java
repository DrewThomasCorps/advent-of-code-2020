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
        double startTime = 0;
        double currentPeriodLength = 1;
        int timeAfterFirstBus = 0;
        for (Bus bus : buses) {
            timeAfterFirstBus += bus.getTimeAfterPreviousBus();
            double periodStart = timeWhenNumIsXGreaterThanNumAfterTime(
                    bus.getLoopTime(),
                    currentPeriodLength,
                    startTime,
                    timeAfterFirstBus,
                    startTime
                    );
            double periodEnd = timeWhenNumIsXGreaterThanNumAfterTime(
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

    public double timeWhenNumIsXGreaterThanNumAfterTime(double num1Multiple, double num2Multiple, double num2Offset, double x, double minTime) {
        double num2 = (Math.ceil(minTime/ num2Multiple) * num2Multiple) + num2Offset;
        double num1 = Math.ceil(num2/ num1Multiple) * num1Multiple;
        while (num1 - num2 != x) {
            num2 += num2Multiple;
            num1 = Math.ceil(num2/ num1Multiple) * num1Multiple;
        }
        return num2;
    }
}
