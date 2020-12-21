package com.adventofcode._21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    Map<String, Integer> ingredientsCount;
    Map<String, Allergen> allergenMap;

    @BeforeEach
    void setUp() {
        Unmarshaller unmarshaller = new Unmarshaller(this.getClass().getResourceAsStream("testInput.txt"));
        ingredientsCount = unmarshaller.getIngredientsCount();
        allergenMap = unmarshaller.getAllergenHashMap();
    }

    @Test
    void getNonAllergensCount() {
        assertEquals(5, Main.getNonAllergensCount(ingredientsCount, new ArrayList<>(allergenMap.values())));
    }

    @Test
    void getCanonicalDangerousIngredientList() {
        assertEquals("mxmxvkd,sqjhc,fvjkl", Main.getCanonicalDangerousIngredientList(allergenMap));
    }
}