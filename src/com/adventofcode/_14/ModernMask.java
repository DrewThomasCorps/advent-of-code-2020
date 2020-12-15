package com.adventofcode._14;

import java.util.*;
import java.util.stream.Collectors;

public class ModernMask {
    private final Map<Integer, Character> placeToBitMap = new HashMap<>();
    private final Set<Integer> floatingPlaces = new HashSet<>();

    ModernMask() {

    }

    public ModernMask(String mask) {
        for (int i = 0; i < mask.length(); i++) {
            int place = mask.length() - 1 - i;
            char value = mask.charAt(place);
            if (value == '1') {
                placeToBitMap.put(place, value);
            }
            if (value == 'X') {
                floatingPlaces.add(place);
            }
        }
    }

    Map<Integer, Character> getPlaceToBitMap() {
        return placeToBitMap;
    }

    Set<Integer> getFloatingPlaces() {
        return floatingPlaces;
    }

    List<Mask> getAllPossibleMasks() {
        return getPossibleHashMaps(this.floatingPlaces).stream().map(Mask::new).collect(Collectors.toList());
    }

    List<HashMap<Integer, Character>> getPossibleHashMaps(
            Set<Integer> floatingPlaces
    ) {
        List<HashMap<Integer, Character>> hashMapList = new ArrayList<>();
        HashMap<Integer, Character> startingHashMap = new HashMap<>();
        for (Integer place : floatingPlaces) {
            startingHashMap.put(place, '0');
        }
        for (Integer place : floatingPlaces) {
            List<HashMap<Integer, Character>> newMapList = new ArrayList<>();
            if (hashMapList.size() == 0) {
                HashMap<Integer, Character> zeroMap = new HashMap<>(startingHashMap);
                HashMap<Integer, Character> oneMap = new HashMap<>(startingHashMap);
                oneMap.put(place, '1');
                zeroMap.put(place, '0');
                hashMapList.add(oneMap);
                hashMapList.add(zeroMap);
            } else {
                for (HashMap<Integer, Character> hashMap : hashMapList) {
                    HashMap<Integer, Character> oneMap = new HashMap<>(hashMap);
                    oneMap.put(place, '1');
                    newMapList.add(oneMap);
                }
                hashMapList.addAll(newMapList);
            }
        }
        return hashMapList;
    }


}
