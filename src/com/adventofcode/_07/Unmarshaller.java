package com.adventofcode._07;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unmarshaller {
    static Map<String, Bag> bagsMap;

    static Map<String, Bag> getBagsMap(InputStream inputStream) {
        bagsMap = new HashMap<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String bagName = line.substring(0, line.indexOf(" bags contain"));
            Bag bag = getBag(bagName);
            addRulesToBag(line, bag);
            bagsMap.put(bagName, bag);
        }
        return bagsMap;
    }

    private static Bag getBag(String name) {
        return bagsMap.getOrDefault(name, new Bag());
    }

    private static void addRulesToBag(String rulesString, Bag parentBag) {
        Pattern bagRulePattern = Pattern.compile("([\\d]+) ([\\w\\s]+) bags?[,.]");
        Matcher matcher = bagRulePattern.matcher(rulesString);
        while (matcher.find()) {
            String childBagName = matcher.group(2);
            Integer quantityRequired = Integer.parseInt(matcher.group(1));
            Bag childBag = getBag(childBagName);
            bagsMap.put(childBagName, childBag);
            parentBag.addBagRule(childBag, quantityRequired);
        }
    }


}
