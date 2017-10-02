package util;

import java.util.Arrays;

public class LabUtils {

    public static int maxMatrix(int[][] matrix) {
        int maxElement = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (maxElement < matrix[i][j]) {
                    maxElement = matrix[i][j];
                }
            }
        }
        return maxElement;
    }

    public static int[] sortVector(int[] vector) {
        int[] tempVector = Arrays.copyOf(vector, vector.length);
        Arrays.sort(tempVector);
        return tempVector;
    }

    public static int[][] transponate(int[][] matrix) {
        int swapVar = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    continue;
                }
                swapVar = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swapVar;
            }
        }
        return matrix;
    }

    public static int[] sum(int[] vectorA, int[] vectorB) {
        int[] resVector = new int[vectorA.length];
        for (int i = 0; i < resVector.length; i++) {
            resVector[i] = vectorA[i] + vectorB[i];
        }
        return resVector;
    }

    public static class Matrix {

        private int[][] value;
        private int rows;
        private int cols;

        public Matrix(int size) {
            rows = cols = size;
            value = new int[size][];
            for (int i = 0; i < size; i++) {
                value[i] = new int[size];
                Arrays.fill(value[i], 0);
            }
        }

        public Matrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            value = new int[rows][];
            for (int i = 0; i < rows; i++) {
                value[i] = new int[cols];
                Arrays.fill(value[i], 0);
            }
        }

        public int[][] get() {
            return value;
        }

        public void set(int[][] value) {
            this.value = value;
            rows = value.length;
            cols = value[0].length;
        }

        public int rows() {
            return rows;
        }

        public int cols() {
            return cols;
        }


        public static Matrix multiply(Matrix matrixA, Matrix matrixB) {
            if (!isMatrix(matrixA.get()) || !isMatrix(matrixB.get()) ||
                matrixA.cols() != matrixB.rows()) {
                return null;
            }

            int[][] valueA = matrixA.get();
            int[][] valueB = matrixB.get();
            Matrix resMatrix = new Matrix(matrixA.rows(), matrixB.cols());
            int[][] res = resMatrix.get();

            for (int i = 0; i < matrixA.rows(); i++) {
                for (int j = 0; j < matrixB.cols(); j++) {

                    for (int r = 0; r < matrixA.cols(); r++) {
                        res[i][j] += valueA[i][r] * valueB[r][j];
                    }

                }
            }

            return resMatrix;
        }


        public Matrix multiply(Matrix matrix) {
            return multiply(this, matrix);
        }

        public static Matrix multiply(Matrix matrix, int number) {
            if (!isMatrix(matrix.get())) {
                return null;
            }

            Matrix res = new Matrix(matrix.rows(), matrix.cols());

            int[][] resVal = res.get();
            int[][] matrixVal = matrix.get();

            for (int i = 0; i < matrix.rows(); i++) {
                for (int j = 0; j < matrix.cols(); j++) {
                    resVal[i][j] = matrixVal[i][j] * number;
                }
            }

            return res;
        }

        public Matrix multiply(int number) {
            return multiply(this, number);
        }

        public static Matrix fill(Matrix matrix, int digit) {
            if (!isMatrix(matrix.get())) {
                return null;
            }

            int[][] matrixVal = matrix.get();

            for (int[] mRow: matrixVal) {
                Arrays.fill(mRow, digit);
            }

            return matrix;
        }

        public Matrix fill(int digit) {
            return fill(this, digit);
        }

        public static Matrix transpanate(Matrix matrix) {
            if (!isMatrix(matrix.get())) {
                return null;
            }

            int swapVar = 0;
            Matrix res = new Matrix(matrix.cols(), matrix.rows());
            int[][] resVal = res.get();
            int[][] matrixVal = matrix.get();

            for (int i = 0; i < matrix.cols(); i++) {
                resVal[i] = new int[matrix.rows()];
                for (int j = 0; j < matrix.rows(); j++) {
                    if (i == j) {
                        continue;
                    }
                    resVal[i][j] = matrixVal[j][i];
                }
            }

            return res;
        }

        public Matrix transponate() {
            return transpanate(this);
        }

        public static Matrix add(Matrix matrixA, Matrix matrixB) {
            if (!isMatrix(matrixA.get()) || !isMatrix(matrixB.get()) ||
                    matrixA.rows() != matrixB.rows() || matrixA.cols() != matrixB.cols()) {
                return null;
            }

            Matrix res = new Matrix(matrixA.rows(), matrixA.cols());
            int[][] resVal = res.get();
            int[][] aVal = matrixA.get();
            int[][] bVal = matrixB.get();

            for (int i = 0; i < res.rows(); i++) {
                for (int j = 0; j < res.cols(); j++) {
                    resVal[i][j] = aVal[i][j] + bVal[i][j];
                }
            }

            return res;
        }

        public Matrix add(Matrix matrix) {
            return add(this, matrix);
        }

        public static Integer getMaximum(Matrix matrix) {
            if (!isMatrix(matrix.get())) {
                return null;
            }
            int[][] matrixVal = matrix.get();
            int maximum = matrixVal[0][0];

            for (int[] mRow: matrixVal) {
                for (int element: mRow) {
                    if (element > maximum) {
                        maximum = element;
                    }
                }
            }

            return maximum;
        }

        public Integer getMaximum() {
            return getMaximum(this);
        }

        public static Matrix sortRows(Matrix matrix) {
            if (!isMatrix(matrix.get())) {
                return null;
            }

            Matrix res = new Matrix(matrix.rows(), matrix.cols());
            int[][] resVal = res.get();
            int[][] matrixVal = matrix.get();

            for (int i = 0; i < resVal.length; i++) {
                resVal[i] = Arrays.copyOf(matrixVal[i], resVal.length);
                Arrays.sort(resVal[i]);
            }

            return res;
        }

        public Matrix sortRows() {
            return sortRows(this);
        }

        public static Matrix sortCols(Matrix matrix) {
            if (!isMatrix(matrix.get())) {
                return null;
            }

            Matrix temp = matrix.transponate();
            Matrix res = new Matrix(matrix.cols(), matrix.rows());
            int[][] resVal = res.get();
            int[][] tempVal = temp.get();

            for (int j = 0; j < resVal.length; j++) {
                resVal[j] = Arrays.copyOf(tempVal[j], resVal.length);
                Arrays.sort(resVal[j]);
            }

            return res;
        }

        public static boolean isMatrix(int[][] matrix) {
            if (matrix == null || matrix.length < 1) {
                return false;
            }
            if (matrix[0] == null) {
                return false;
            }

            int rowLength = matrix[0].length;

            for (int[] mRow: matrix) {
                if (mRow == null || mRow.length != rowLength) {
                    return false;
                }
            }

            return true;
        }

        public static boolean isQuadro(int[][] matrix) {
            return isMatrix(matrix) &&
                    matrix[0].length == matrix.length;
        }
    }
}
