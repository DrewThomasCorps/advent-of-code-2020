package com.adventofcode._09;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Xmas {
    private final int maxQueueSize;
    private final Queue<Long> queue = new ArrayDeque<>();

    public Xmas(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public void addToQueue(Long number) {
        if (queue.size() < maxQueueSize) {
            queue.add(number);
        } else if (acceptsNumber(number)) {
            queue.remove();
            queue.add(number);
        } else {
            throw new IllegalArgumentException(
                    String.format("%d is not the sum of the previous %d numbers", number, maxQueueSize)
            );
        }
    }

    // O(n) space and time
    private boolean acceptsNumber(Long number) {
        Set<Long> neededValues = new HashSet<>();
        for (Long currentInt : queue) {
            if (neededValues.contains(currentInt)) {
                return true;
            }
            neededValues.add(number - currentInt);
        }
        return false;
    }
}
