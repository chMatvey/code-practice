package com.github.chMatvey.codewars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Permutations2Test {
    @Test
    public void example1() {
        assertEquals(new ArrayList<>(List.of("a")),
                Permutations2.singlePermutations("a").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example2() {
        assertEquals(new ArrayList<>(Arrays.asList("ab", "ba")),
                Permutations2.singlePermutations("ab").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example3() {
        assertEquals(new ArrayList<>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                Permutations2.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example4() {
        assertEquals(new ArrayList<>(Arrays.asList("abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                        "bacd", "badc", "bcad", "bcda", "bdac", "bdca", "cabd", "cadb", "cbad",
                        "cbda", "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab", "dcba")),
                Permutations2.singlePermutations("abcd").stream().sorted().collect(Collectors.toList()));
    }
}