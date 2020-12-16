package com.adventofcode._16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainStationTest {

    TrainStation trainStation;

    @BeforeEach
    void setUp() {
        trainStation = Unmarshaller.getTrainStation(
                this.getClass().getResourceAsStream("testInput.txt")
        );
    }

    @Test
    void getTicketScanningErrorRate() {
        assertEquals(71, trainStation.getTicketScanningErrorRate());
    }
}