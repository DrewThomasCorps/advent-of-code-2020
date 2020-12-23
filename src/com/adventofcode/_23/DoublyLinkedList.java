package com.adventofcode._23;

import java.util.HashMap;
import java.util.Map;

public class DoublyLinkedList {
    private Node head = null;
    private final Map<Integer, Node> nodeMap = new HashMap<>();
    private Integer highestValue = null;

    void add(Node node) {
        if (head == null) {
            head = node;
            node.setNext(node);
            node.setPrevious(node);
            highestValue = node.getValue();
        } else {
            node.setPrevious(head.getPrevious());
            node.setNext(head);
            head.getPrevious().setNext(node);
            head.setPrevious(node);
            if (node.getValue() > highestValue) {
                highestValue = node.getValue();
            }
        }
        nodeMap.put(node.getValue(), node);
    }

    Node getHead() {
        return head;
    }

    Node pickUp(Node node, int extraCount) {
        Node lastNode = node;
        nodeMap.remove(lastNode.getValue());
        for (int i = 0; i < extraCount; i++) {
            lastNode = lastNode.getNext();
            nodeMap.remove(lastNode.getValue());
        }
        node.getPrevious().setNext(lastNode.getNext());
        lastNode.getNext().setPrevious(node.getPrevious());
        node.setPrevious(lastNode);
        lastNode.setNext(node);
        return node;
    }

    void insertAfter(Node destinationNode, Node insertNode) {
        Node searchNode = insertNode;
        do {
            nodeMap.put(searchNode.getValue(), searchNode);
            searchNode = searchNode.getNext();
        } while (insertNode != searchNode);
        destinationNode.getNext().setPrevious(insertNode.getPrevious());
        insertNode.getPrevious().setNext(destinationNode.getNext());
        destinationNode.setNext(insertNode);
        insertNode.setPrevious(destinationNode);
    }

    Node findNodeWithValue(Integer value) {
        return nodeMap.get(value);
    }

    public Node findNodeWithHighestValue() {
        int searchValue = highestValue;
        Node highestValueNode;
        do {
            highestValueNode = nodeMap.get(searchValue--);
        } while (highestValueNode == null);
        return highestValueNode;
    }
}
