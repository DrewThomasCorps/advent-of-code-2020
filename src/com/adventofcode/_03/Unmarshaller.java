package com.adventofcode._03;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Unmarshaller {
    public static Forest getForest(InputStream input) {
        Scanner scanner = new Scanner(input);
        List<List<Boolean>> treeList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            List<Boolean> treeRow = new ArrayList<>();
            String line = scanner.nextLine();
            for (char character : line.toCharArray()) {
                treeRow.add(character == '#');
            }
            treeList.add(treeRow);
        }
        return new Forest(treeList);
    }
}
