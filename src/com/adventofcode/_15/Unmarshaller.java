package com.adventofcode._15;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Unmarshaller {
    public static MemoryGame getMemoryGame(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        String line = scanner.nextLine();
        List<Long> startingNumbers = Arrays
                .stream(line.split(","))
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
        return new MemoryGame(startingNumbers);
    }
}
