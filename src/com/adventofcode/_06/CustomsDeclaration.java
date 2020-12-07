package com.adventofcode._06;

import java.util.HashMap;
import java.util.Map;

public class CustomsDeclaration {
    private final Map<Integer, Integer> questionsCountMap = new HashMap<>();
    private int personCount = 0;

    public void addPersonYesQuestions(String yesQuestions) {
        personCount++;
        yesQuestions.chars().forEach(character -> {
            questionsCountMap.put(character, questionsCountMap.getOrDefault(character, 0) + 1);
        });
    }

    public int getYesQuestionsCount() {
        return questionsCountMap.size();
    }

    public int getYesQuestionIntersectionCount() {
        return (int) questionsCountMap.values().stream().filter(count -> count == personCount).count();
    }
}
