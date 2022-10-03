package com.github.chMatvey.hackerrank;

import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class StringAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next().toLowerCase();
        String b = scanner.next().toLowerCase();
        if (a.length() == b.length()) {
            List<Integer> first = a.chars().boxed().sorted().collect(toList());
            List<Integer> second = b.chars().boxed().sorted().collect(toList());
            if (first.equals(second)) {
                System.out.println("Anagrams");
                return;
            }
        }
        System.out.println("Not Anagrams");
    }
}
