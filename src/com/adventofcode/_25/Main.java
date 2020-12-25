package com.adventofcode._25;

public class Main {
    public static void main(String[] args) {
        int[] publicKeys = Unmarshaller.getPublicKeys(Main.class.getResourceAsStream("input.txt"));
        int doorLoopSize = getLoopSize(publicKeys[0]);
        long encryptionKey = 1;
        for (int i = 0; i < doorLoopSize; i++) {
            encryptionKey = applyLoop(encryptionKey, publicKeys[1]);
        }
        System.out.printf("Part 1: %d%n", encryptionKey);
    }

    public static int getLoopSize(int publicKey) {
        int loopCounter = 0;
        long value = 1;
        while (value != publicKey) {
            loopCounter++;
            value = applyLoop(value, 7);
        }
        return loopCounter;
    }

    public static long applyLoop(long value, long subjectKey) {
        value *= subjectKey;
        return value % 20201227;
    }
}
