package com.adventofcode._12;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Unmarshaller {
    public static List<Instruction> getInstructions(InputStream inputStream) {
        List<Instruction> instructions = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Instruction.ACTION action = switch (line.charAt(0)) {
                case 'N' -> Instruction.ACTION.NORTH;
                case 'S' -> Instruction.ACTION.SOUTH;
                case 'E' -> Instruction.ACTION.EAST;
                case 'W' -> Instruction.ACTION.WEST;
                case 'L' -> Instruction.ACTION.LEFT;
                case 'R' -> Instruction.ACTION.RIGHT;
                case 'F' -> Instruction.ACTION.FORWARD;
                default -> throw new IllegalStateException("Unexpected value: " + line.charAt(0));
            };
            int amount = Integer.parseInt(line.substring(1));
            Instruction instruction = new Instruction(action, amount);
            instructions.add(instruction);
        }
        return instructions;
    }
}
