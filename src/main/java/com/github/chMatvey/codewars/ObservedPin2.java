package com.github.chMatvey.codewars;

import java.util.*;

import static java.util.List.of;
import static java.util.Map.entry;
import static java.util.Map.ofEntries;

public class ObservedPin2 {
    private static final Map<Character, List<Character>> ADJACENT = ofEntries(
            entry('1', of('1', '2', '4')),
            entry('2', of('2', '1', '3', '5')),
            entry('3', of('3', '2', '6')),
            entry('4', of('4', '1', '5', '7')),
            entry('5', of('5', '2', '4', '6', '8')),
            entry('6', of('6', '3', '5', '9')),
            entry('7', of('7', '4', '8')),
            entry('8', of('8', '5', '7', '9', '0')),
            entry('9', of('9', '6', '8')),
            entry('0', of('0', '8'))
    );

    public static List<String> getPINs(String observed) {
        List<String> result = List.of("");

        for (char c : observed.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (char adjacent : ADJACENT.get(c)) {
                for (String s : result) tmp.add(s + adjacent);
            }
            result = tmp;
        }

        return result;
    }
}
