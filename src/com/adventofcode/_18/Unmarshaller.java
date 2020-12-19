package com.adventofcode._18;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Unmarshaller {
    static List<Expression> getExpressions(InputStream inputStream) {
        List<Expression> expressions = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            expressions.add(new Expression(scanner.nextLine()));
        }
        return expressions;
    }
}
