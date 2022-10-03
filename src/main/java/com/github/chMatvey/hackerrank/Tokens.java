package com.github.chMatvey.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Tokens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tokens = tokenize(scanner.nextLine());
        System.out.println(tokens.size());
        for (String token : tokens) {
            System.out.println(token);
        }
    }

    public static List<String> tokenize(String expression) {
        return Arrays.stream(expression.split("[^a-zA-Z]+"))
                .filter(token -> !token.isEmpty())
                .collect(Collectors.toList());
    }
}
