package com.adventofcode._13;

import java.util.List;

public class Util {
    static double getLeastCommonMultiple(List<Double> numbers) {
        double previousLeastCommonMultiple = 1;
        for (Double number : numbers) {
            previousLeastCommonMultiple = getLeastCommonMultiple(previousLeastCommonMultiple, number);
        }
        return previousLeastCommonMultiple;
    }

    static double getLeastCommonMultiple(double n1, double n2) {
        double n1Multiple = n1;
        double n2Multiple = n2;
        double leastCommonMultiple = Math.max(n1, n2);
        while (leastCommonMultiple != n1 || leastCommonMultiple != n2) {
            n1 = Math.ceil(leastCommonMultiple / n1Multiple) * n1Multiple;
            n2 = Math.ceil(leastCommonMultiple / n2Multiple) * n2Multiple;
            leastCommonMultiple = Math.max(n1, n2);
        }
        return leastCommonMultiple;
    }
}
