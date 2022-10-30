package com.github.chMatvey.leetcode;

import java.util.Stack;

public class Parentheses {
    public static final int BASIC = 0;
    public static final int FIGURE = 1;
    public static final int SQUARE = 2;

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Integer> openedBrackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> openedBrackets.push(BASIC);
                case ')' -> {
                    if (openedBrackets.empty() || openedBrackets.pop() != BASIC)
                        return false;
                }
                case '{' -> openedBrackets.push(FIGURE);
                case '}' -> {
                    if (openedBrackets.empty() || openedBrackets.pop() != FIGURE)
                        return false;
                }
                case '[' -> openedBrackets.push(SQUARE);
                case ']' -> {
                    if (openedBrackets.empty() || openedBrackets.pop() != SQUARE)
                        return false;
                }
                default -> throw new IllegalArgumentException("Unexpected symbol");
            }
        }
        return openedBrackets.empty();
    }
}
