package com.adventofcode._24;

import java.util.*;
import java.util.stream.Collectors;

public class Floor {
    private final Map<HexCoordinate, Tile> tilesMap;

    public Floor(Map<HexCoordinate, Tile> tilesMap) {
        this.tilesMap = tilesMap;
    }

    long getBlackTilesCount() {
        return getBlackTiles().size();
    }

    void simulateDays(int days) {
        for (int i = 0; i < days; i++) {
            nextDay();
        }
    }

    private List<Tile> getBlackTiles() {
        return tilesMap.values().stream().filter(tile -> !tile.isWhite()).collect(Collectors.toList());
    }

    private void nextDay() {
        getTilesToFlip().forEach(Tile::flip);
    }

    private List<Tile> getTilesToFlip() {
        List<Tile> tiles = getAllBlackAndAdjacentTiles();
        return tiles.stream().filter(this::shouldTileFlip).collect(Collectors.toList());
    }

    private List<Tile> getAllBlackAndAdjacentTiles() {
        List<Tile> blackTiles = getBlackTiles();
        Set<Tile> blackAndAdjacentTiles = new HashSet<>(blackTiles);
        for (Tile tile : blackTiles) {
            blackAndAdjacentTiles.addAll(getAdjacentTiles(tile));
        }
        return new ArrayList<>(blackAndAdjacentTiles);
    }

    private boolean shouldTileFlip(Tile tile) {
        short adjacentBlackTileCount = (short) getAdjacentTiles(tile).stream()
                .filter(adjacentTile -> !adjacentTile.isWhite()).count();
        return (tile.isWhite() && adjacentBlackTileCount == 2)
                || (!tile.isWhite() && (adjacentBlackTileCount == 0 || adjacentBlackTileCount > 2));
    }

    private List<Tile> getAdjacentTiles(Tile tile) {
        HexCoordinate hexCoordinate = tile.getCoordinate();
        List<Tile> tiles = new ArrayList<>();
        tiles.add(getTileAtCoordinate(hexCoordinate.east()));
        tiles.add(getTileAtCoordinate(hexCoordinate.southEast()));
        tiles.add(getTileAtCoordinate(hexCoordinate.southWest()));
        tiles.add(getTileAtCoordinate(hexCoordinate.west()));
        tiles.add(getTileAtCoordinate(hexCoordinate.northWest()));
        tiles.add(getTileAtCoordinate(hexCoordinate.northEast()));
        return tiles;
    }

    private Tile getTileAtCoordinate(HexCoordinate hexCoordinate) {
        Tile tile = tilesMap.getOrDefault(hexCoordinate, new Tile(hexCoordinate));
        tilesMap.put(hexCoordinate, tile);
        return tile;
    }
}
