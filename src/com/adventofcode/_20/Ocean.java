package com.adventofcode._20;

public class Ocean {
    private Tile sea;

    public Ocean(Tile sea) {
        this.sea = sea;
    }

    int getWaterRoughness() {
        int waters = sea.getPixels().stream().mapToInt(
                (list) -> (int) list.stream()
                        .filter(character -> character == '#')
                        .count()
        ).sum();
        return waters - (getMostSeaMonsterCount() * 15);
    }

    int getMostSeaMonsterCount() {
        int seaMonsters = 0;
        while (seaMonsters == 0) {
            for (int i = 0; i < 4; i++) {
                seaMonsters = seaMonsterCount();
                if (seaMonsters > 0) {
                    return seaMonsters;
                }
                sea.rotate();
            }
            sea.flip();
        }
        return seaMonsters;
    }

    int seaMonsterCount() {
        Character[][] seaMonster = SeaMonster.getShape();
        int seaMonsterCount = 0;
        for (int row = 0; row <= sea.getPixels().size() - seaMonster.length; row++) {
            for (int column = 0; column <= sea.getPixels().size() - seaMonster[0].length; column++) {
                if (seaMonsterIsAtPosition(new Position(row, column))) {
                    seaMonsterCount++;
                }
            }
        }
        return seaMonsterCount;
    }

    boolean seaMonsterIsAtPosition(Position position) {
        Character[][] seaMonster = SeaMonster.getShape();
        for (int row = 0; row < seaMonster.length; row++) {
            for (int column = 0; column < seaMonster[0].length; column++) {
                boolean isMonsterPixel = seaMonster[row][column] == '#';
                if (isMonsterPixel) {
                    Character seaCharacter = sea.getPixel(
                            new Position(position.getRow() + row, position.getColumn() + column)
                    );
                    if (seaCharacter != '#') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
