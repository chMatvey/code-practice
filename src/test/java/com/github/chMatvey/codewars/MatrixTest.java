package com.github.chMatvey.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    private static final int[][][] matrix = {
            {{1}},
            {{1, 3}, {2, 5}},
            {{2, 5, 3}, {1, -2, -1}, {1, 3, 4}}
    };

    private static final int[] expected = {1, -1, -20};

    @Test
    public void sampleTests() {
        for (int n = 0; n < expected.length; n++)
            assertEquals(expected[n], Matrix.determinant(matrix[n]));
    }
}