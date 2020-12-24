package com.adventofcode._24;

import java.util.Objects;

public class Tile {
    private boolean isWhite = true;

    private final HexCoordinate coordinate;

    public Tile(HexCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    void flip() {
        isWhite = !isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public HexCoordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return isWhite() == tile.isWhite() && getCoordinate().equals(tile.getCoordinate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWhite(), getCoordinate());
    }
}
