package com.adventofcode._19;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Unmarshaller unmarshaller = new Unmarshaller(Main.class.getResourceAsStream("input.txt"));
        Map<Integer, Rule> rules = unmarshaller.getRulesMap();
        List<String> strings = unmarshaller.getStrings();
        System.out.printf("Part 1: %d%n", getValidCount(rules.get(0), strings));
        UnmarshallerReplacer unmarshallerReplacer = new UnmarshallerReplacer(Main.class.getResourceAsStream("input.txt"));
        rules = unmarshallerReplacer.getRulesMap();
        strings = unmarshallerReplacer.getStrings();
        System.out.printf("Part 1: %d%n", getValidCount(rules.get(0), strings));

    }

    static Integer getValidCount(Rule rule, List<String> strings) {
        return (int) strings.stream().filter(rule::stringMatches).count();
    }
}
