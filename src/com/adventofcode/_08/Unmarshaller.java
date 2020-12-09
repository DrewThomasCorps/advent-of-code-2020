package com.adventofcode._08;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unmarshaller {
    static BootCode getBootCode(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        BootCode bootCode = new BootCode();
        List<Instruction> instructions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Pattern pattern = Pattern.compile("(nop|acc|jmp) ([+-]\\d+)");
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                OPERATION operation = OPERATION.getInstruction(matcher.group(1));
                Integer argument = Integer.parseInt(matcher.group(2));
                Instruction instruction = new Instruction(operation, argument, bootCode);
                instructions.add(instruction);
            }
        }
        bootCode.setInstructions(instructions);
        return bootCode;
    }
}
