package com.adventofcode._10;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Unmarshaller {
    public static List<Integer> getSortedInput(InputStream inputStream) {
        List<Integer> inputList = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextInt()) {
            inputList.add(scanner.nextInt());
        }
        return inputList.stream().sorted().collect(Collectors.toList());
    }
}
