package com.github.chMatvey.codewars;

import java.util.*;

import static java.util.List.of;
import static java.util.Map.entry;
import static java.util.Map.ofEntries;

public class ObservedPin {
    private static final Map<Character, List<Character>> numberPerNeighbors = ofEntries(
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

    private static String takeOut(String str, int index) {
        return str.substring(0, index) + str.substring(index + 1);
    }

    public static List<String> getPINs(String observed) {
        Set<String> result = new HashSet<>();
        result.add(observed);

        for (int i = 0; i < observed.length(); i++) {
            char c = observed.charAt(i);
            String substr = takeOut(observed, i);
            List<String> subPins = getPINs(substr);
            for (String subPin : subPins) {
                for (Character variant : numberPerNeighbors.get(c)) {
                    result.add(
                            subPin.substring(0, i) + variant + subPin.substring(i)
                    );
                }
            }
        }

        return new ArrayList<>(result);
    }
}
