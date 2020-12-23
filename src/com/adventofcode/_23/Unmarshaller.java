package com.adventofcode._23;

import java.io.InputStream;
import java.util.Scanner;

public class Unmarshaller {
    static Game getGame(InputStream inputStream) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Scanner scanner = new Scanner(inputStream);
        String line = scanner.nextLine();
        for (char character : line.toCharArray()) {
            Node node = new Node(Integer.parseInt(Character.toString(character)));
            doublyLinkedList.add(node);
        }
        return new Game(doublyLinkedList);
    }

    static Game getExtendedGame(InputStream inputStream) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Scanner scanner = new Scanner(inputStream);
        String line = scanner.nextLine();
        for (char character : line.toCharArray()) {
            Node node = new Node(Integer.parseInt(Character.toString(character)));
            doublyLinkedList.add(node);
        }
        for (int i = 10; i <= 1_000_000; i++) {
            doublyLinkedList.add(new Node(i));
        }
        return new Game(doublyLinkedList);
    }
}
