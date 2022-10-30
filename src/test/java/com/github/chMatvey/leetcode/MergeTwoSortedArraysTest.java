package com.github.chMatvey.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeTwoSortedArraysTest {
    @Test
    void test1() {
        int[] first = {1, 3, 5, 12, 23}; // 5
        int[] second = {3, 4, 5, 6, 10}; // 5

        assertArrayEquals(
                new int[]{1, 3, 3, 4, 5, 5, 6, 10, 12, 23},
                TwoLists.mergeTwoArrays(second, first)
        );
    }

    @Test
    void test2() {
        int[] first = {1, 3, 5, 12, 23}; // 5
        int[] second = {3, 4, 5, 6, 10, 21}; // 6

        assertArrayEquals(
                new int[]{1, 3, 3, 4, 5, 5, 6, 10, 12, 21, 23},
                TwoLists.mergeTwoArrays(second, first)
        );
    }

    @Test
    void test3() {
        int[] first = {1, 3, 5, 12, 23}; // 5
        int[] second = {3, 4, 5, 6, 10, 21}; // 6

        assertArrayEquals(
                new int[]{1, 3, 3, 4, 5, 5, 6, 10, 12, 21, 23},
                TwoLists.mergeTwoArrays(second, first)
        );
    }
}