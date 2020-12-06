package com.adventofcode._06;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CustomsDeclaration> customsDeclarations = Unmarshaller.getCustomDeclarations(
                Main.class.getResourceAsStream("input.txt")
        );
        System.out.printf("Part 1: %d%n", sumOfYesQuestions(customsDeclarations));
        System.out.printf("Part 2: %d%n", sumIntersectionYesQuestions(customsDeclarations));
    }

    public static int sumOfYesQuestions(List<CustomsDeclaration> customsDeclarations) {
        return customsDeclarations.stream().mapToInt(CustomsDeclaration::getYesQuestionsCount).sum();
    }

    public static int sumIntersectionYesQuestions(List<CustomsDeclaration> customsDeclarations) {
        return customsDeclarations.stream().mapToInt(CustomsDeclaration::getYesQuestionIntersectionCount).sum();
    }
}
