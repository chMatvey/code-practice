package com.github.chMatvey.codewars;

import java.util.List;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class Permutations2 {
    public static List<String> singlePermutations(final String s) {
        return permute("", s);
    }

    private static List<String> permute(final String prefix, final String s) {
        return s.isEmpty() ? singletonList(prefix) :
                s.chars()
                .distinct()
                .mapToObj(i -> (char) i)
                .map(c -> permute(prefix + c, takeOut(s, c)))
                .flatMap(List::stream)
                .collect(toList());
    }

    static String takeOut(final String s, final char c) {
        final int i = s.indexOf(c);
        return s.substring(0, i) + s.substring(i + 1);
    }
}
