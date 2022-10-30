package com.github.chMatvey.codewars;

import java.util.stream.IntStream;

public class Matrix {
    public static int determinant(int[][] matrix) {
        if (matrix.length < 1 || !isSquare(matrix))
            throw new IllegalArgumentException("Incorrect matrix");

        return switch (matrix.length) {
            case 1 -> matrix[0][0];
            case 2 -> matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            default -> IntStream
                    .range(0, matrix[0].length)
                    .map(i -> (i % 2 == 0 ? 1 : -1) * matrix[0][i] * determinant(subMatrix(matrix, i)))
                    .sum();
        };
    }

    private static int[][] subMatrix(int[][] matrix, int skippedColumn) {
        int[][] subMatrix = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 1; i < matrix.length; i++) {
            int column = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (j == skippedColumn)
                    continue;
                subMatrix[i - 1][column] = matrix[i][j];
                column++;
            }
        }
        return subMatrix;
    }

    private static boolean isSquare(int[][] matrix) {
        int height = matrix.length;
        for (int[] row : matrix) if (row.length != height) return false;
        return true;
    }
}
