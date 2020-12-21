package com.adventofcode._20;

import java.util.List;
import java.util.function.Predicate;

public class Tile {
    private final int id;
    private final List<List<Character>> pixels;

    private Tile top = null;
    private Tile right = null;
    private Tile bottom = null;
    private Tile left = null;

    private boolean isFlipped = false;
    private int rotatedCount = 0;

    public Tile(int id, List<List<Character>> pixels) {
        this.id = id;
        this.pixels = pixels;
    }

    int getId() {
        return id;
    }

    public Tile getTop() {
        return top;
    }

    public Tile getRight() {
        return right;
    }

    public Tile getBottom() {
        return bottom;
    }

    public Tile getLeft() {
        return left;
    }

    public List<List<Character>> getPixels() {
        return pixels;
    }

    int getAssociatedCount() {
        int associatedCount = 0;
        if (top != null) {
            associatedCount++;
        }
        if (right != null) {
            associatedCount++;
        }
        if (bottom != null) {
            associatedCount++;
        }
        if (left != null) {
            associatedCount++;
        }
        return associatedCount;
    }

    boolean positionCheckFits(Tile tile, Predicate<Tile> positionCheck) {
        if (positionCheck.test(tile)) {
            return true;
        }
        if (rotationFits(tile, positionCheck)) {
            return true;
        }
        tile.flip();
        return rotationFits(tile, positionCheck);
    }

    private boolean rotationFits(Tile tile, Predicate<Tile> positionCheck) {
        for (int i = 0; i < 4; i++) {
            tile.rotate();
            if (positionCheck.test(tile)) {
                return true;
            }
        }
        return false;
    }

    void rotate() {
        rotatedCount = (rotatedCount + 1) % 4;
    }

    void flip() {
        isFlipped = !isFlipped;
    }

    // Compare this tile's top row against incoming tile's bottom row
    Predicate<Tile> tileGoesOnTop(Tile tile) {
        return (currentTile) -> {
            if (this.top != null) {
                return false;
            }
            int topRow = 0;
            int bottomRow = pixels.size() - 1;

            for (int column = 0; column < pixels.size(); column++) {
                Position top = new Position(topRow, column);
                Position bottom = new Position(bottomRow, column);
                if (this.getPixel(top) != tile.getPixel(bottom)) {
                    return false;
                }
            }
            tile.bottom = this;
            this.top = tile;
            return true;
        };
    }

    // Compare this tile's bottom row against incoming tile's top row
    Predicate<Tile> tileGoesOnBottom(Tile tile) {
        return (currentTile) -> {
            if (this.bottom != null) {
                return false;
            }
            int topRow = 0;
            int bottomRow = pixels.size() - 1;

            for (int column = 0; column < pixels.size(); column++) {
                Position top = new Position(topRow, column);
                Position bottom = new Position(bottomRow, column);
                if (this.getPixel(bottom) != tile.getPixel(top)) {
                    return false;
                }
            }
            tile.top = this;
            this.bottom = tile;
            return true;
        };
    }

    // Compare this tile's right row against incoming tile's left row
    Predicate<Tile> tileGoesOnRight(Tile tile) {
        return (currentTile) -> {
            if (this.right != null) {
                return false;
            }
            int rightColumn = pixels.size() - 1;
            int leftColumn = 0;

            for (int row = 0; row < pixels.size(); row++) {
                Position right = new Position(row, rightColumn);
                Position left = new Position(row, leftColumn);
                if (this.getPixel(right) != tile.getPixel(left)) {
                    return false;
                }
            }
            tile.left = this;
            this.right = tile;
            return true;
        };
    }

    // Compare this tile's left row against incoming tile's right row
    Predicate<Tile> tileGoesOnLeft(Tile tile) {
        return (currentTile) -> {
            if (this.right != null) {
                return false;
            }
            int rightColumn = pixels.size() - 1;
            int leftColumn = 0;

            for (int row = 0; row < pixels.size(); row++) {
                Position right = new Position(row, rightColumn);
                Position left = new Position(row, leftColumn);
                if (this.getPixel(left) != tile.getPixel(right)) {
                    return false;
                }
            }
            tile.right = this;
            this.left = tile;
            return true;
        };
    }

    Character getPixel(Position position) {
        if (isFlipped) {
            position = getFlippedPosition(position);
        }
        for (int i = 0; i < rotatedCount; i++) {
            position = getRotatedPosition(position);
        }
        return pixels.get(position.getRow()).get(position.getColumn());
    }

    private Position getFlippedPosition(Position position) {
        return new Position((pixels.size() - 1) - position.getRow(), position.getColumn());
    }

    private Position getRotatedPosition(Position position) {
        // Does not need to be pixels.get(0).size() because tiles are squares
        return new Position(position.getColumn(), pixels.size() - 1 - position.getRow());
    }


}
