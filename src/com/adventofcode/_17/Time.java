package com.adventofcode._17;

import java.util.ArrayList;
import java.util.List;

public class Time {
    List<Space> spaces;

    public Time(List<Space> spaces) {
        this.spaces = spaces;
    }

    public int getActiveCubesCount() {
        return spaces.stream().mapToInt(Space::activeCubesCount).sum();
    }

    public void completeNCycles(int n) {
        for (int i = 0; i < n; i++) {
            getNextCycle();
        }
    }

    private void getNextCycle() {
        List<Space> newSpaces = new ArrayList<>();
        for (int spaceIndex = -1; spaceIndex <= spaces.size(); spaceIndex++) {
            List<Plane> planes = new ArrayList<>();
            for (int planeIndex = -1; planeIndex <= spaces.get(0).planesSize(); planeIndex++) {
                List<List<Boolean>> cubes = new ArrayList<>();
                for (int rowIndex = -1; rowIndex <= spaces.get(0).rowsSize(); rowIndex++) {
                    cubes.add(new ArrayList<>());
                    for (int columnIndex = -1; columnIndex <= spaces.get(0).columnsSize(); columnIndex++) {
                        int activeNeighborCubes = getActiveNeighborCubesCount(spaceIndex, planeIndex, rowIndex, columnIndex);
                        if (getCube(spaceIndex, planeIndex, rowIndex, columnIndex)) {
                            cubes.get(rowIndex + 1).add(activeNeighborCubes == 2 || activeNeighborCubes == 3);
                        } else {
                            cubes.get(rowIndex + 1).add(activeNeighborCubes == 3);
                        }
                    }
                }
                Plane plane = new Plane(cubes);
                planes.add(plane);
            }
            Space space = new Space(planes);
            newSpaces.add(space);
        }
        spaces = newSpaces;
    }


    private int getActiveNeighborCubesCount(int space, int plane, int row, int column) {
        return (int) getNeighborCubes(space, plane, row, column).stream().filter(Boolean::booleanValue).count();
    }

    private List<Boolean> getNeighborCubes(int space, int plane, int row, int column) {
        List<Boolean> neighborCubes = new ArrayList<>();
        for (int spaceIndex = space - 1; spaceIndex <= space + 1; spaceIndex++) {
            for (int planeIndex = plane - 1; planeIndex <= plane + 1; planeIndex++) {
                for (int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
                    for (int columnIndex = column - 1; columnIndex <= column + 1; columnIndex++) {
                        if (spaceIndex == space && planeIndex == plane && rowIndex == row && columnIndex == column) {
                            continue;
                        }
                        neighborCubes.add(getCube(spaceIndex, planeIndex, rowIndex, columnIndex));
                    }
                }
            }
        }
        return neighborCubes;
    }

    Boolean getCube(int space, int plane, int row, int column) {
        if (spaceIsOffTime(space)) {
            return false;
        }
        return spaces.get(space).getCube(plane, row, column);
    }

    private Boolean spaceIsOffTime(int space) {
        return space < 0 || space >= spaces.size();
    }
}
