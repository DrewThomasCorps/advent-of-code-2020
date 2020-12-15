package com.adventofcode._14;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModernComputer {
    Map<Long, Long> memory = new HashMap<>();

    ModernComputer(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        ModernMask currentMask = new ModernMask();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.contains("mask = ")) {
                currentMask = new ModernMask(line.substring("mask = ".length()));
            } else {
                Pattern memoryPattern = Pattern.compile("mem\\[([\\d]+)] = ([\\d]+)");
                Matcher matcher = memoryPattern.matcher(line);
                if (matcher.matches()) {
                    ExtendedInteger location = new ExtendedInteger(Long.parseLong(matcher.group(1)));
                    long value = Long.parseLong(matcher.group(2));
                    location.applyMask(new Mask(currentMask.getPlaceToBitMap()));
                    for (Mask possibleMask: currentMask.getAllPossibleMasks()) {
                        ExtendedInteger nextLocation = new ExtendedInteger(location.getValue());
                        nextLocation.applyMask(possibleMask);
                        addValueToMemory(nextLocation.getValue(), value);
                    }

                }
            }
        }
    }

    void addValueToMemory(long address, long value) {
        memory.remove(address);
        memory.put(address, value);
    }

    Double getSumOfMemoryValues() {
        return memory.values().stream().mapToDouble(Long::longValue).sum();
    }
}
