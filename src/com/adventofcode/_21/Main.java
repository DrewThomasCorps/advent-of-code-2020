package com.adventofcode._21;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Unmarshaller unmarshaller = new Unmarshaller(Main.class.getResourceAsStream("input.txt"));
        Map<String, Integer> ingredientsCount = unmarshaller.getIngredientsCount();
        Map<String, Allergen> allergenMap = unmarshaller.getAllergenHashMap();
        System.out.printf("Part 1: %d%n",
                getNonAllergensCount(ingredientsCount, new ArrayList<>(allergenMap.values()))
        );
        System.out.printf("Part 2: %s%n", getCanonicalDangerousIngredientList(allergenMap));
    }

    static int getNonAllergensCount(Map<String, Integer> ingredientsCount, List<Allergen> allergens) {
        Map<String, Integer> nonAllergensCountMap = new HashMap<>(ingredientsCount);
        for (Allergen allergen : allergens) {
            Set<String> possibleAllergenIngredients = allergen.getPossibleIngredients();
            for (String possibleAllergenIngredient : possibleAllergenIngredients) {
                nonAllergensCountMap.remove(possibleAllergenIngredient);
            }
        }
        return nonAllergensCountMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    static String getCanonicalDangerousIngredientList(Map<String, Allergen> allergenMap) {
        List<Allergen> allergens = getFilteredAllergens(allergenMap);
        allergens.sort((a1, a2) -> Collator.getInstance().compare(a1.getName(), a2.getName()));
        List<String> ingredients = allergens.stream().map(Allergen::getIngredient).collect(Collectors.toList());
        return String.join(",", ingredients);
    }

    static List<Allergen> getFilteredAllergens(Map<String, Allergen> allergenMap) {
        Set<Allergen> unfilteredAllergens = new HashSet<>(allergenMap.values());
        while (maxPossibleIngredients(new ArrayList<>(allergenMap.values())) > 1) {
            Allergen singleIngredientAllergen = getSingleIngredientAllergen(new ArrayList<>(unfilteredAllergens));
            unfilteredAllergens.remove(singleIngredientAllergen);
            String ingredient = singleIngredientAllergen.getIngredient();
            for (Allergen allergen : unfilteredAllergens) {
                allergen.removePossibleIngredient(ingredient);
            }
        }
        return new ArrayList<>(allergenMap.values());

    }

    static int maxPossibleIngredients(List<Allergen> allergens) {
        return allergens.stream().mapToInt(Allergen::getPossibleIngredientsCount).max().getAsInt();
    }

    static Allergen getSingleIngredientAllergen(List<Allergen> allergens) {
        return allergens.stream().min(Comparator.comparingInt(Allergen::getPossibleIngredientsCount)).get();
    }
}
