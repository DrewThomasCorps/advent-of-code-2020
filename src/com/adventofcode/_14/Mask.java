package com.adventofcode._14;

import java.util.HashMap;
import java.util.Map;

public class Mask {
    private final Map<Integer, Character> placeToBitMap;

    public Mask(Map<Integer, Character> placeToBitMap) {
        this.placeToBitMap = placeToBitMap;
    }

    public Mask(String mask) {
        placeToBitMap = new HashMap<>();
        for (int i = 0; i < mask.length(); i++) {
            int place = mask.length() - 1 - i;
            char value = mask.charAt(place);
            if (value == '1' || value == '0') {
                placeToBitMap.put(place, value);
            }
        }
    }

    Map<Integer, Character> getPlaceToBitMap() {
        return placeToBitMap;
    }
}
