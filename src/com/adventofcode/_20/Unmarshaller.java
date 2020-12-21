package com.adventofcode._20;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Unmarshaller {
    static Assembler getAssembler(InputStream inputStream) {
        List<Tile> tiles = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        int id = 0;
        List<List<Character>> pixels = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Tile")) {
                id = Integer.parseInt(line.substring(
                        line.indexOf(' ') + 1,
                        line.indexOf(':')
                ));
                continue;
            }
            if (line.equals("")) {
                tiles.add(new Tile(id, pixels));
                pixels = new ArrayList<>();
                continue;
            }
            pixels.add(line.chars().mapToObj(value -> (char) value).collect(Collectors.toList()));
        }
        tiles.add(new Tile(id, pixels));
        return new Assembler(tiles);
    }
}
