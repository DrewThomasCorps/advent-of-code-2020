package com.adventofcode._17;

import java.util.List;

public class Plane {
    List<List<Boolean>> cubes;

    public Plane(List<List<Boolean>> cubes) {
        this.cubes = cubes;
    }

    Integer rowsSize() {
        return cubes.size();
    }

    Integer columnsSize() {
        return cubes.get(0).size();
    }

    Integer activeCubesCount() {
        return cubes.stream().mapToInt(columns -> (int) columns.stream().filter(Boolean::booleanValue).count()).sum();
    }

    Boolean getCube(Integer row, Integer column) {
        if (pointIsOffPlane(row, column)) {
            return false;
        }
        return cubes.get(row).get(column);
    }

    private Boolean pointIsOffPlane(Integer row, Integer column) {
        return row < 0 || row >= rowsSize() || column < 0 || column >= columnsSize();
    }
}
