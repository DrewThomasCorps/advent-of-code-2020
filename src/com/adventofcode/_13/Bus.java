package com.adventofcode._13;

public class Bus {
    private final int id;
    private final int loopTime;

    private final Integer timeAfterPreviousBus;

    public Bus(int loopTime, int timeAfterPreviousBus) {
        this.id = loopTime;
        this.loopTime = loopTime;
        this.timeAfterPreviousBus = timeAfterPreviousBus;
    }

    public int getId() {
        return id;
    }

    public int getLoopTime() {
        return loopTime;
    }

    public Integer getTimeAfterPreviousBus() {
        return timeAfterPreviousBus;
    }

    public double getEarliestDepartureAfterTime(double time) {
        double firstLoopBack = Math.ceil(time / (float) loopTime);
        return firstLoopBack * loopTime;
    }


}
