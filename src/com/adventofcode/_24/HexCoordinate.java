package com.adventofcode._24;

import java.util.Objects;

public class HexCoordinate {
    private final int northEast;
    private final int east;

    public HexCoordinate(int northEast, int east) {
        this.northEast = northEast;
        this.east = east;
    }

    private int getNorthEast() {
        return northEast;
    }

    private int getEast() {
        return east;
    }

    HexCoordinate east() {
        return new HexCoordinate(northEast, east + 1);
    }

    HexCoordinate southEast() {
        return new HexCoordinate(northEast - 1, east + 1);
    }

    HexCoordinate southWest() {
        return new HexCoordinate(northEast - 1, east);
    }

    HexCoordinate west() {
        return new HexCoordinate(northEast, east - 1);
    }

    HexCoordinate northWest() {
        return new HexCoordinate(northEast + 1, east - 1);
    }

    HexCoordinate northEast() {
        return new HexCoordinate(northEast + 1, east);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HexCoordinate that = (HexCoordinate) o;
        return getNorthEast() == that.getNorthEast() && getEast() == that.getEast();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNorthEast(), getEast());
    }
}
