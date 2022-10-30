package com.github.chMatvey.leetcode;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        String str = Integer.toString(x);
        String reverse = new StringBuilder(str).reverse().toString();

        return str.equals(reverse);
    }
}
