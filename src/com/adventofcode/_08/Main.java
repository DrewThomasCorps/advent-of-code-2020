package com.adventofcode._08;

public class Main {
    public static void main(String[] args) {
        BootCode bootCode = Unmarshaller.getBootCode(Main.class.getResourceAsStream("input.txt"));
        BootCode bootCodeCopy = Unmarshaller.getBootCode(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 1: %d%n", bootCode.runSafe());
        System.out.printf("Part 2: %d%n", bootCode.runCleaner());

    }
}
