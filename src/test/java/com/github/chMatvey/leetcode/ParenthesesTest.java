package com.github.chMatvey.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesTest {
    @Test
    void isValid() {
        assertFalse(Parentheses.isValid("([)]"));
    }
}