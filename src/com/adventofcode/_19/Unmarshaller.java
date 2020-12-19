package com.adventofcode._19;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Unmarshaller {

    private Map<Integer, Rule> rulesMap = null;
    private List<String> strings = null;
    private final InputStream inputStream;

    public Unmarshaller(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    Map<Integer, Rule> getRulesMap() {
        if (rulesMap == null) {
            parse();
        }
        return rulesMap;
    }

    List<String> getStrings() {
        if (strings == null) {
            parse();
        }
        return strings;
    }

    void parse() {
        rulesMap = new HashMap<>();
        Scanner scanner = new Scanner(inputStream);
        strings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(":")) {
                parseRule(line, rulesMap);
            }
            if (line.equals("")) {
                continue;
            }
            strings.add(line);
        }
    }

    void parseRule(String line, Map<Integer, Rule> rulesMap) {
        Integer ruleNumber = Integer.parseInt(line.substring(0, line.indexOf(':')));
        Rule rule = rulesMap.getOrDefault(ruleNumber, new Rule());
        rulesMap.put(ruleNumber, rule);
        String ruleSequence = line.substring(line.indexOf(':') + 1);
        if (ruleSequence.contains("\"")) {
            int matchingCharacterIndex = ruleSequence.indexOf('"') + 1;
            rule.setMatchingCharacter(ruleSequence.charAt(matchingCharacterIndex));
        } else {
            parseHigherOrderRule(ruleSequence, rule, rulesMap);
        }
    }

    void parseHigherOrderRule(String ruleSequence, Rule rule, Map<Integer, Rule> rulesMap) {
        String[] rulesStrings = ruleSequence.split("\\|");
        List<List<Rule>> subRules = new ArrayList<>();
        for (String numbers : rulesStrings) {
            List<Integer> ruleNumbers = Arrays.stream(numbers.split(" ")).filter(value -> !value.equals("")).mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
            List<Rule> rules = new ArrayList<>();
            ruleNumbers.forEach(number -> {
                Rule subRule = rulesMap.getOrDefault(number, new Rule());
                rulesMap.put(number, subRule);
                rules.add(subRule);
            });
            subRules.add(rules);
        }
        rule.setSubRules(subRules);
    }
}
