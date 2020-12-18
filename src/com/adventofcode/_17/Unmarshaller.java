package com.adventofcode._17;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Unmarshaller {
    static Space getStartingSpace(InputStream inputStream) {
        List<List<Boolean>> cubes = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<Boolean> row = line.chars().mapToObj(character -> character == '#').collect(Collectors.toList());
            cubes.add(row);
        }
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane(cubes));
        return new Space(planes);
    }

    static Time getStartingTime(InputStream inputStream) {
        Space space = getStartingSpace(inputStream);
        List<Space> spaces = new ArrayList<>();
        spaces.add(space);
        return new Time(spaces);
    }
}
