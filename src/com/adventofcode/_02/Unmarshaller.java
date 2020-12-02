package com.adventofcode._02;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unmarshaller {
    public static List<PasswordPolicy> unmarshall(InputStream inputStream) {
        List<PasswordPolicy> passwordPolicies = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        Pattern pattern = Pattern.compile("(\\d+)-(\\d+) (\\w): (\\w+)");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                Policy policy = new Policy(
                        Integer.parseInt(matcher.group(1)),
                        Integer.parseInt(matcher.group(2)),
                        matcher.group(3).charAt(0));
                PasswordPolicy passwordPolicy = new PasswordPolicy(policy, matcher.group(4));
                passwordPolicies.add(passwordPolicy);
            }
        }
        return passwordPolicies;
    }


}
