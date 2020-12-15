package com.adventofcode._14;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Computer {
    Map<Long, Long> memory = new HashMap<>();

    Computer(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        Mask currentMask = new Mask(new HashMap<>());
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.contains("mask = ")) {
                currentMask = new Mask(line.substring("mask = ".length()));
            } else {
                Pattern memoryPattern = Pattern.compile("mem\\[([\\d]+)] = ([\\d]+)");
                Matcher matcher = memoryPattern.matcher(line);
                if (matcher.matches()) {
                    long location = Long.parseLong(matcher.group(1));
                    long value = Long.parseLong(matcher.group(2));
                    ExtendedInteger extendedInteger = new ExtendedInteger(value);
                    extendedInteger.applyMask(currentMask);
                    memory.put(location, extendedInteger.getValue());
                }
            }
        }
    }

    Double getSumOfMemoryValues() {
        return memory.values().stream().mapToDouble(Long::longValue).sum();
    }
}
