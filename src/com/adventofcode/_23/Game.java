package com.adventofcode._23;

public class Game {
    private final DoublyLinkedList cups;
    private Node currentCup;

    public Game(DoublyLinkedList cups) {
        this.cups = cups;
        currentCup = cups.getHead();
    }

    void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            move();
        }
    }

    String getOrder() {
        Node start = cups.findNodeWithValue(1);
        Node target = start.getNext();
        StringBuilder stringBuilder = new StringBuilder();
        while (target != start) {
            stringBuilder.append(target.getValue());
            target = target.getNext();
        }
        return stringBuilder.toString();
    }

    long getTwoCupsAfterOneMultiplied() {
        Node one = cups.findNodeWithValue(1);
        return (long) one.getNext().getNext().getValue() * one.getNext().getValue();
    }

    private void move() {
        Node pickedUp = cups.pickUp(currentCup.getNext(), 2);
        Integer currentValue = currentCup.getValue();
        Node destination;
        do {
            if (currentValue == 1) {
                destination = cups.findNodeWithHighestValue();
            } else {
                destination = cups.findNodeWithValue(--currentValue);
            }
        } while (destination == null);
        cups.insertAfter(destination, pickedUp);
        currentCup = currentCup.getNext();
    }


}
