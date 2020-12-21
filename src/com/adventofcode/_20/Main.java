package com.adventofcode._20;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Assembler assembler = Unmarshaller.getAssembler(
                Main.class.getResourceAsStream("input.txt")
        );
        System.out.printf("Part 1: %d%n", getCornersMultiplied(assembler));
        Ocean ocean = new Ocean(assembler.getAssembledTile());
        System.out.printf("Part 2: %d%n", ocean.getWaterRoughness());
    }

    static long getCornersMultiplied(Assembler assembler) {
        List<Tile> corners = assembler.getCornerTiles();
        return corners.stream().mapToLong(Tile::getId).reduce((acc, value) -> acc *= value).getAsLong();
    }

}
