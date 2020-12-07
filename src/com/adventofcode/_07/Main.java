package com.adventofcode._07;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Bag> bagsMap = Unmarshaller.getBagsMap(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 1: %d%n", getBagsCountWithBagDescendent(bagsMap, bagsMap.get("shiny gold")));
        System.out.printf("Part 2: %d%n", bagsMap.get("shiny gold").getChildrenBagsCount());
    }

    public static long getBagsCountWithBagDescendent(Map<String, Bag> bagsMap, Bag targetChildBag) {
        return bagsMap.values().stream().filter((bag) -> bag.hasBagDescendent(targetChildBag)).count();
    }
}
