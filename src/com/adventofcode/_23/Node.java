package com.adventofcode._23;

public class Node {
    private Node previous = null;
    private Node next = null;
    private final Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }
}
