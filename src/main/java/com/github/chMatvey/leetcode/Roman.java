package com.github.chMatvey.leetcode;

import java.util.Map;

public class Roman {
    private static final Map<Character, Integer> symbols = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static int romanToInt(String s) {
        if (s.isEmpty()) return 0;

        int result = 0;
        int prev = symbols.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int curr = symbols.get(s.charAt(i));
            if (prev < curr) result -= prev;
            else result += prev;
            prev = curr;
        }
        return result + prev;
    }
}
