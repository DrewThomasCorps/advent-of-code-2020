package com.adventofcode._20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Assembler {
    private final List<Tile> tiles;

    public Assembler(List<Tile> tiles) {
        this.tiles = tiles;
        assemble();
    }

    List<Tile> getCornerTiles() {
        return tiles.stream().filter(tile -> tile.getAssociatedCount() == 2).collect(Collectors.toList());
    }

    Tile getAssembledTile() {
        Tile topLeft = tiles.stream().filter(tile -> tile.getLeft() == null && tile.getTop() == null).findFirst().get();
        Tile rowTile = topLeft;
        Tile columnTile = topLeft;
        int tileSize = topLeft.getPixels().size();
        List<List<Character>> pixels = new ArrayList<>();
        while (rowTile != null) {
            for (int row = 1; row < tileSize - 1; row++) {
                List<Character> rowCharacters = new ArrayList<>();
                while (columnTile != null) {
                    for (int column = 1; column < tileSize - 1; column++) {
                        rowCharacters.add(columnTile.getPixel(new Position(row, column)));
                    }
                    columnTile = columnTile.getRight();
                }
                pixels.add(rowCharacters);
                columnTile = rowTile;
            }
            rowTile = rowTile.getBottom();
            columnTile = rowTile;
        }
        return new Tile(1, pixels);
    }

    private void assemble() {
        Set<Tile> nonFixedTiles = new HashSet<>(tiles);
        Set<Tile> fixedTiles = new HashSet<>();
        fixedTiles.add(tiles.get(0));
        nonFixedTiles.removeAll(fixedTiles);
        while (nonFixedTiles.size() != 0) {
            List<Tile> nextFixedTiles = new ArrayList<>();
            for (Tile fixedTile : fixedTiles) {
                for (Tile nonFixedTile : nonFixedTiles) {
                    if (fixedTile.positionCheckFits(nonFixedTile, fixedTile.tileGoesOnTop(nonFixedTile))) {
                        nextFixedTiles.add(nonFixedTile);
                        continue;
                    }
                    if (fixedTile.positionCheckFits(nonFixedTile, fixedTile.tileGoesOnRight(nonFixedTile))) {
                        nextFixedTiles.add(nonFixedTile);
                        continue;
                    }
                    if (fixedTile.positionCheckFits(nonFixedTile, fixedTile.tileGoesOnBottom(nonFixedTile))) {
                        nextFixedTiles.add(nonFixedTile);
                        continue;
                    }
                    if (fixedTile.positionCheckFits(nonFixedTile, fixedTile.tileGoesOnLeft(nonFixedTile))) {
                        nextFixedTiles.add(nonFixedTile);
                    }
                }
                nonFixedTiles.removeAll(nextFixedTiles);
            }
            fixedTiles.addAll(nextFixedTiles);
        }
        associateFixedTiles();
    }

    private void associateFixedTiles() {
        for (Tile t1 : tiles) {
            for (Tile t2 : tiles) {
                t1.tileGoesOnBottom(t2).test(t2);
                t1.tileGoesOnTop(t2).test(t2);
                t1.tileGoesOnLeft(t2).test(t2);
                t1.tileGoesOnRight(t2).test(t2);
            }
        }
    }
}
