package com.adventofcode._04;

import java.util.HashMap;

public class Passport {
    private final HashMap<String, String> fieldsMap = new HashMap<>();

    public void addField(String key, String value) {
        fieldsMap.put(key, value);
    }

    public boolean hasField(String key) {
        return fieldsMap.containsKey(key);
    }

    public String getField(String key) {
        return fieldsMap.get(key);
    }
}
