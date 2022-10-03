package com.github.chMatvey.codewars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {
    @Test
    public void example1() {
        assertEquals(new ArrayList<>(List.of("a")),
                Permutations.singlePermutations("a").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example2() {
        assertEquals(new ArrayList<>(Arrays.asList("ab", "ba")),
                Permutations.singlePermutations("ab").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example3() {
        assertEquals(new ArrayList<>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                Permutations.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example4() {
        assertEquals(new ArrayList<>(Arrays.asList("abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                        "bacd", "badc", "bcad", "bcda", "bdac", "bdca", "cabd", "cadb", "cbad",
                        "cbda", "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab", "dcba")),
                Permutations.singlePermutations("abcd").stream().sorted().collect(Collectors.toList()));
    }
}