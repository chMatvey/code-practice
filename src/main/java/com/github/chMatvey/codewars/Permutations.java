package com.github.chMatvey.codewars;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Permutations {
    static List<String> singlePermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str.length() < 2) {
            result.add(str);
            return result;
        }
        char first = str.charAt(0);
        List<String> onLevelLess = singlePermutations(str.substring(1));
        for (String permutation : onLevelLess) {
            for (int i = 0; i <= permutation.length(); i++) {
                result.add(insertCharAtPosition(permutation, first, i));
            }
        }
        return result.stream().distinct().collect(toList());
    }

    public static String insertCharAtPosition(String str, char c, int position) {
        StringBuilder builder = new StringBuilder(str);
        builder.insert(position, c);
        return builder.toString();
    }
}
