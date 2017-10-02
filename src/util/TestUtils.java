package util;

import java.util.Arrays;

public class TestUtils {
    public static int[][] generateMatrix(int size) {
        if (size < 1) {
            System.out.println("generateMatrix(): Wrong matrix size!");
            return null;
        }

        int[][] matrix = new int[size][];

        for (int i = 0; i < size; i++) {
            matrix[i] = new int[size];
            Arrays.fill(matrix[i], 1);
        }

        return matrix;
    }

    public static int[] generateVector(int size) {
        if (size < 1) {
            System.out.println("generateVector(): Wrong vector size!");
            return null;
        }

        int[] vector = new int[size];
        Arrays.fill(vector, 1);

        return vector;
    }
}
