package com.adventofcode._14;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 1: %1$.0f%n", computer.getSumOfMemoryValues());
        ModernComputer modernComputer = new ModernComputer(Main.class.getResourceAsStream("input.txt"));
        System.out.printf("Part 2: %1$.0f%n", modernComputer.getSumOfMemoryValues());
    }
}
