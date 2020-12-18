package com.adventofcode._17;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private List<Plane> planes;

    public Space(List<Plane> planes) {
        this.planes = planes;
    }

    public int planesSize() {
        return this.planes.size();
    }

    public int rowsSize() {
        return planes.get(0).rowsSize();
    }

    public int columnsSize() {
        return planes.get(0).columnsSize();
    }

    public int activeCubesCount() {
        return planes.stream().mapToInt(Plane::activeCubesCount).sum();
    }

    public void completeNCycles(int n) {
        for (int i = 0; i < n; i++) {
            getNextCycle();
        }
    }

    private void getNextCycle() {
        List<Plane> newPlanes = new ArrayList<>();
        for (int planeIndex = -1; planeIndex <= planes.size(); planeIndex++) {
            List<List<Boolean>> cubes = new ArrayList<>();
            for (int rowIndex = -1; rowIndex <= rowsSize(); rowIndex++) {
                cubes.add(new ArrayList<>());
                for (int columnIndex = -1; columnIndex <= columnsSize(); columnIndex++) {
                    int activeNeighborCubes = getActiveNeighborCubesCount(planeIndex, rowIndex, columnIndex);
                    if (getCube(planeIndex, rowIndex, columnIndex)) {
                        cubes.get(rowIndex + 1).add(activeNeighborCubes == 2 || activeNeighborCubes == 3);
                    } else {
                        cubes.get(rowIndex + 1).add(activeNeighborCubes == 3);
                    }
                }
            }
            Plane plane = new Plane(cubes);
            newPlanes.add(plane);
        }
        this.planes = newPlanes;
    }


    private int getActiveNeighborCubesCount(int plane, int row, int column) {
        return (int) getNeighborCubes(plane, row, column).stream().filter(Boolean::booleanValue).count();
    }

    private List<Boolean> getNeighborCubes(int plane, int row, int column) {
        List<Boolean> neighborCubes = new ArrayList<>();
        for (int planeIndex = plane - 1; planeIndex <= plane + 1; planeIndex++) {
            for (int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
                for (int columnIndex = column - 1; columnIndex <= column + 1; columnIndex++) {
                    if (planeIndex == plane && rowIndex == row && columnIndex == column) {
                        continue;
                    }
                    neighborCubes.add(getCube(planeIndex, rowIndex, columnIndex));
                }
            }
        }
        return neighborCubes;
    }

    Boolean getCube(int plane, int row, int column) {
        if (planeIsOffSpace(plane)) {
            return false;
        }
        return planes.get(plane).getCube(row, column);
    }

    private Boolean planeIsOffSpace(int plane) {
        return plane < 0 || plane >= planes.size();
    }
}
