package com.adventofcode._07;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bag {
    private final Map<Bag, Integer> bagRules = new HashMap<>();

    void addBagRule(Bag bag, Integer requiredQuantity) {
        bagRules.put(bag, requiredQuantity);
    }

    // Could be optimized with dynamic programming and storing a set of descendant bags
    boolean hasBagDescendent(Bag bag) {
        for (Bag childBag : bagRules.keySet()) {
            // Infinite loops should not be possible, would not make sense with puzzle input,
            // but can be accounted for by marking bag as visited with an attribute or passing a visited set
            if (childBag.equals(bag) || childBag.hasBagDescendent(bag)) {
                return true;
            }
        }
        return false;
    }

    int getChildrenBagsCount() {
        int childrenBagsCount = 0;
        Set<Bag> childBags = bagRules.keySet();
        for (Bag childBag : childBags) {
            // Quantity * (grandChildren bags + 1 for child bag)
            childrenBagsCount += (bagRules.get(childBag) * (childBag.getChildrenBagsCount() + 1));
        }
        return childrenBagsCount;
    }
}
