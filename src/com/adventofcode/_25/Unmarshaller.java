package com.adventofcode._25;

import java.io.InputStream;
import java.util.Scanner;

public class Unmarshaller {
    static int[] getPublicKeys(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int[] publicKeys = new int[2];
        publicKeys[0] = Integer.parseInt(scanner.nextLine());
        publicKeys[1] = Integer.parseInt(scanner.nextLine());
        return publicKeys;
    }


}
