package com.adventofcode._21;

import java.io.InputStream;
import java.util.*;

public class Unmarshaller {

    private final InputStream inputStream;
    private Map<String, Integer> ingredientsCount = new HashMap<>();
    private Map<String, Allergen> allergenHashMap = new HashMap<>();

    public Unmarshaller(InputStream inputStream) {
        this.inputStream = inputStream;
        unmarshall();
    }

    public Map<String, Integer> getIngredientsCount() {
        return ingredientsCount;
    }

    public Map<String, Allergen> getAllergenHashMap() {
        return allergenHashMap;
    }

    void unmarshall() {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String searchDelimiter = " (contains ";
            String[] ingredients = line.substring(0, line.indexOf(searchDelimiter)).split(" ");
            String[] allergens = line.substring(
                    line.indexOf(searchDelimiter) + searchDelimiter.length(), line.length() - 1
            ).split(", ");
            for (String ingredient : ingredients) {
                Integer ingredientCount = ingredientsCount.getOrDefault(ingredient, 0);
                ingredientCount++;
                ingredientsCount.put(ingredient, ingredientCount);
            }
            Set<String> ingredientsSet = new HashSet<>(Arrays.asList(ingredients));
            for (String allergenString : allergens) {
                Allergen allergen = allergenHashMap.getOrDefault(allergenString,
                        new Allergen(allergenString, new HashSet<>(ingredientsSet))
                );
                allergen.intersectNewPossibleIngredients(new HashSet<>(ingredientsSet));
                allergenHashMap.put(allergenString, allergen);
            }
        }
    }

}
