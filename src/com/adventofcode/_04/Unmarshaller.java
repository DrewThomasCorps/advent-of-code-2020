package com.adventofcode._04;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Unmarshaller {
    public static List<Passport> getPassports(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        List<Passport> passports = new ArrayList<>();
        Passport passport = new Passport();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                passports.add(passport);
                passport = new Passport();
                continue;
            }
            Passport finalPassport = passport;
            Arrays.stream(line.split(" ")).forEach((String string) -> {
                String[] keyValue = string.split(":");
                finalPassport.addField(keyValue[0], keyValue[1]);
            });
        }
        passports.add(passport);
        return passports;
    }
}
