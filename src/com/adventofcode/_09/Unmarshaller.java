package com.adventofcode._09;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Unmarshaller {
    public static List<Long> getInput(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<Long> input = new ArrayList<>();
        while (scanner.hasNextLong()) {
            input.add(scanner.nextLong());
        }
        return input;
    }
}
