package com.adventofcode._21;

import java.util.Set;

public class Allergen {
    private final Set<String> possibleIngredients;
    private final String name;

    public Allergen(String name, Set<String> possibleIngredients) {
        this.name = name;
        this.possibleIngredients = possibleIngredients;
    }

    public String getName() {
        return name;
    }

    public Set<String> getPossibleIngredients() {
        return possibleIngredients;
    }

    void intersectNewPossibleIngredients(Set<String> possibleIngredients) {
        this.possibleIngredients.retainAll(possibleIngredients);
    }

    String getIngredient() {
        if (possibleIngredients.size() > 1) {
            throw new IllegalStateException("More than 1 possible ingredient");
        }
        return possibleIngredients.iterator().next();
    }

    int getPossibleIngredientsCount() {
        return possibleIngredients.size();
    }

    void removePossibleIngredient(String possibleIngredient) {
        possibleIngredients.remove(possibleIngredient);
    }

}
