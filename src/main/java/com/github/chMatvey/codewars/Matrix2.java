package com.github.chMatvey.codewars;

public class Matrix2 {
    public static int determinant(int[][] matrix) {
        return minor(matrix, 0, new int[matrix.length]);
    }

    private static int minor(int[][] m, int n, int[] excluded) {
        int size = m.length;
        if (n == size) return 1;
        int sum = 0;
        int sign = 1;
        for (int i = 0; i < size; i++)
            if (excluded[i] == 0) {
                excluded[i] = 1;
                sum += sign * m[n][i] * minor(m, n + 1, excluded);
                sign = -sign;
                excluded[i] = 0;
            }
        return sum;
    }
}
