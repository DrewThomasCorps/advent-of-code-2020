package com.adventofcode._24;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Unmarshaller {
    static Floor getFloor(InputStream inputStream) {
        Map<HexCoordinate, Tile> tileMap = new HashMap<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            HexCoordinate coordinate = getCoordinate(line);
            Tile tile = tileMap.getOrDefault(coordinate, new Tile(coordinate));
            tile.flip();
            tileMap.put(coordinate, tile);
        }
        return new Floor(tileMap);
    }

    private static HexCoordinate getCoordinate(String directions) {
        HexCoordinate coordinate = new HexCoordinate(0, 0);
        for (int i = 0; i < directions.length(); i++) {
            char currentChar = directions.charAt(i);
            switch (currentChar) {
                case 's' -> {
                    char nextChar = directions.charAt(++i);
                    if (nextChar == 'e') {
                        coordinate = coordinate.southEast();
                    } else if (nextChar == 'w') {
                        coordinate = coordinate.southWest();
                    }
                }
                case 'n' -> {
                    char nextChar = directions.charAt(++i);
                    if (nextChar == 'e') {
                        coordinate = coordinate.northEast();
                    } else if (nextChar == 'w') {
                        coordinate = coordinate.northWest();
                    }
                }
                case 'e' -> coordinate = coordinate.east();
                case 'w' -> coordinate = coordinate.west();
            }
        }
        return coordinate;
    }
}