package com.adventofcode._11;

import java.util.ArrayList;
import java.util.List;

public class WaitingArea {
    public enum OBJECT {
        EMPTY_SEAT,
        OCCUPIED_SEAT,
        FLOOR
    }

    private List<List<OBJECT>> floorPlan;

    WaitingArea(List<List<OBJECT>> floorPlan) {
        this.floorPlan = floorPlan;
    }

    int getOccupiedSeatCountAfterStabilizes() {
        setNextPlanUntilStabilizes();
        return countOccupiedSeats();
    }

    int countOccupiedSeatsAfterVisibleStabilizes() {
        setNextVisiblePlanUntilStabilizes();
        return countOccupiedSeats();
    }

    private int countOccupiedSeats() {
        return floorPlan.stream().reduce(0, (count, rows) ->
                        count += (int) rows.stream().filter(object -> object == OBJECT.OCCUPIED_SEAT).count(),
                Integer::sum
        );
    }

    private void setNextPlanUntilStabilizes() {
        //noinspection StatementWithEmptyBody
        while (setNextPlan()) ;
    }

    private boolean setNextPlan() {
        boolean seatsChanged = false;
        List<List<OBJECT>> nextPlan = new ArrayList<>();
        for (List<OBJECT> rows : floorPlan) {
            nextPlan.add(new ArrayList<>(rows));
        }
        for (int row = 0; row < floorPlan.size(); row++) {
            for (int column = 0; column < floorPlan.get(0).size(); column++) {
                OBJECT object = floorPlan.get(row).get(column);
                if (object == OBJECT.EMPTY_SEAT && countAdjacentOccupiedSeats(row, column) == 0) {
                    nextPlan.get(row).set(column, OBJECT.OCCUPIED_SEAT);
                    seatsChanged = true;
                } else if (object == OBJECT.OCCUPIED_SEAT && countAdjacentOccupiedSeats(row, column) >= 4) {
                    nextPlan.get(row).set(column, OBJECT.EMPTY_SEAT);
                    seatsChanged = true;
                }
            }
        }
        floorPlan = nextPlan;
        return seatsChanged;
    }

    private int countAdjacentOccupiedSeats(int row, int column) {
        int count = 0;
        for (int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
            if (rowIndex < 0 || rowIndex >= floorPlan.size()) {
                continue;
            }
            for (int columnIndex = column - 1; columnIndex <= column + 1; columnIndex++) {
                if (columnIndex < 0 || columnIndex >= floorPlan.get(0).size()) {
                    continue;
                }
                if (rowIndex == row && columnIndex == column) {
                    continue; //don't count current seat
                }
                if (floorPlan.get(rowIndex).get(columnIndex) == OBJECT.OCCUPIED_SEAT) {
                    count++;
                }
            }
        }
        return count;
    }

    private void setNextVisiblePlanUntilStabilizes() {
        //noinspection StatementWithEmptyBody
        while (setNextVisiblePlan()) ;
    }

    // Could refactor with lambdas to reduce code duplication
    private boolean setNextVisiblePlan() {
        boolean seatsChanged = false;
        List<List<OBJECT>> nextPlan = new ArrayList<>();
        for (List<OBJECT> rows : floorPlan) {
            nextPlan.add(new ArrayList<>(rows));
        }
        for (int row = 0; row < floorPlan.size(); row++) {
            for (int column = 0; column < floorPlan.get(0).size(); column++) {
                OBJECT object = floorPlan.get(row).get(column);
                if (object == OBJECT.EMPTY_SEAT && countVisibleOccupiedSeats(row, column) == 0) {
                    nextPlan.get(row).set(column, OBJECT.OCCUPIED_SEAT);
                    seatsChanged = true;
                } else if (object == OBJECT.OCCUPIED_SEAT && countVisibleOccupiedSeats(row, column) >= 5) {
                    nextPlan.get(row).set(column, OBJECT.EMPTY_SEAT);
                    seatsChanged = true;
                }
            }
        }
        floorPlan = nextPlan;
        return seatsChanged;
    }

    private int countVisibleOccupiedSeats(int row, int column) {
        int occupiedSeatCount = 0;
        for (int rowDirection = -1; rowDirection <= 1; rowDirection++) {
            for (int columnDirection = -1; columnDirection <= 1; columnDirection++) {
                if (rowDirection == 0 && columnDirection == 0) {
                    continue;
                }
                if (objectSeenInDirection(row, column, new Vector(rowDirection, columnDirection))
                        == OBJECT.OCCUPIED_SEAT
                ) {
                    occupiedSeatCount++;
                }
            }
        }
        return occupiedSeatCount;
    }

    private OBJECT objectSeenInDirection(int row, int column, Vector vector) {
        while (true) {
            int rowIndex = row + vector.getRow();
            int columnIndex = column + vector.getColumn();
            if (isPointOutsideFloorPlan(rowIndex, columnIndex)) {
                break;
            }
            OBJECT object = floorPlan.get(rowIndex).get(columnIndex);
            if (object != OBJECT.FLOOR) {
                return object;
            }
            vector.grow();
        }
        return OBJECT.FLOOR;
    }

    private boolean isPointOutsideFloorPlan(int row, int column) {
        return row < 0
                || column < 0
                || row >= floorPlan.size()
                || column >= floorPlan.get(0).size();
    }

}
