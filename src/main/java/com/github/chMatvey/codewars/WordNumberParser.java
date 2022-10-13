package com.github.chMatvey.codewars;

import java.util.*;

import static java.util.Optional.ofNullable;

public class WordNumberParser {
    static final Map<String, Integer> DICTIONARY = Map.ofEntries(
            Map.entry("zero", 0),
            Map.entry("one", 1),
            Map.entry("two", 2),
            Map.entry("three", 3),
            Map.entry("four", 4),
            Map.entry("five", 5),
            Map.entry("six", 6),
            Map.entry("seven", 7),
            Map.entry("eight", 8),
            Map.entry("nine", 9),
            Map.entry("ten", 10),
            Map.entry("eleven", 11),
            Map.entry("twelve", 12),
            Map.entry("thirteen", 13),
            Map.entry("fourteen", 14),
            Map.entry("fifteen", 15),
            Map.entry("sixteen", 16),
            Map.entry("seventeen", 17),
            Map.entry("eighteen", 18),
            Map.entry("nineteen", 19),
            Map.entry("twenty", 20),
            Map.entry("thirty", 30),
            Map.entry("forty", 40),
            Map.entry("fifty", 50),
            Map.entry("sixty", 60),
            Map.entry("seventy", 70),
            Map.entry("eighty", 80),
            Map.entry("ninety", 90),
            Map.entry("hundred", 100),
            Map.entry("thousand", 1000),
            Map.entry("million", 1_000_000)
    );

    static final String AND = "and";

    static final String HUNDRED = "hundred";
    static final String THOUSAND = "thousand";
    static final String MILLION = "million";

    static final Set<String> MULTIPLIED_NUMBERS = Set.of(
            HUNDRED,
            THOUSAND,
            MILLION
    );

    public static int parseInt(String numStr) {
        if (numStr == null || numStr.isEmpty()) return -1;
        List<String> strings = Arrays.stream(numStr.split("[ ,-]"))
                .map(String::toLowerCase)
                .toList();
        if (strings.isEmpty()) return -1;

        int interimResult = 0;
        int hundredCount = 0;
        int thousandCount = 0;
        int millionCount = 0;

        for (String string : strings) {
            if (string.equals(AND)) continue;

            int number = ofNullable(DICTIONARY.get(string))
                    .orElseThrow(() -> new IllegalArgumentException("Incorrect number"));

            if (MULTIPLIED_NUMBERS.contains(string)) {
                switch (string) {
                    case HUNDRED -> {
                        hundredCount = interimResult * number;
                    }
                    case THOUSAND -> {
                        thousandCount = (hundredCount + interimResult) * number;
                        hundredCount = 0;
                    }
                    case MILLION -> {
                        millionCount = (thousandCount + hundredCount + interimResult) * number;
                        thousandCount = 0;
                        hundredCount = 0;
                    }
                }
                interimResult = 0;
            } else {
                interimResult += number;
            }
        }

        return millionCount + thousandCount + hundredCount + interimResult;
    }
}
