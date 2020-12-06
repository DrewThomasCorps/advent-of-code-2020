package com.adventofcode._06;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Unmarshaller {

    public static List<CustomsDeclaration> getCustomDeclarations(InputStream inputStream) {
        List<CustomsDeclaration> customsDeclarations = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        CustomsDeclaration customsDeclaration = new CustomsDeclaration();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                customsDeclarations.add(customsDeclaration);
                customsDeclaration = new CustomsDeclaration();
            } else {
                customsDeclaration.addPersonYesQuestions(line);
            }
        }
        customsDeclarations.add(customsDeclaration);
        return customsDeclarations;
    }


}
