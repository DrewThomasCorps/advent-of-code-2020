package com.adventofcode._14;

import java.util.Map;

public class ExtendedInteger {

    StringBuilder binary;

    public ExtendedInteger(long number) {
        binary = new StringBuilder(Long.toBinaryString(number));
        while (binary.length() != 36) {
            binary.insert(0, '0');
        }
    }

    void applyMask(Mask mask) {
        Map<Integer, Character> placeToBitMap = mask.getPlaceToBitMap();
        for (Integer place: placeToBitMap.keySet()) {
            binary.setCharAt(place, placeToBitMap.get(place));
        }
    }

    long getValue() {
        return Long.valueOf(binary.toString(), 2);
    }
}
