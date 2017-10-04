package util;

import java.util.Arrays;

/**
 * Class: Matrix.
 * @author alex323glo
 * @version 1.0.0
 *
 * Main purpose: realisation of matrix (High Math) logic.
 *
 * Based on 2-dimension integer array.
 * */
public class Matrix {

    // Properties and fields:

    private int[][] value;  // inner matrix (2-dimension int array)
    private int rows;       // counts length of "value" array
    private int cols;       // counts length of any subarray in "value" array


    // Constructors:

    /**
     * Creates square matrix with default
     * size and content (5 x 5 with all elements == 0).
     * @see Matrix#Matrix(int, int)
     * @see Matrix#Matrix(int, int, int)
     * */
    public Matrix(int size) {
        rows = cols = size;
        value = new int[size][];
        for (int i = 0; i < size; i++) {
            value[i] = new int[size];
            Arrays.fill(value[i], 0);
        }
    }

    /**
     * Creates matrix with inputted size ("rows", "cols") and
     * default content (with all elements == 0).
     * @see Matrix#Matrix(int)
     * @see Matrix#Matrix(int, int, int)
     * */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        value = new int[rows][];
        for (int i = 0; i < rows; i++) {
            value[i] = new int[cols];
            Arrays.fill(value[i], 0);
        }
    }

    /**
     * Creates matrix with inputted size and
     * content ("rows", "cols" and "initialValue").
     * @see Matrix#Matrix(int)
     * @see Matrix#Matrix(int, int)
     * */
    public Matrix(int rows, int cols, int initialValue) {
        this.rows = rows;
        this.cols = cols;
        value = new int[rows][];
        for (int i = 0; i < rows; i++) {
            value[i] = new int[cols];
            Arrays.fill(value[i], initialValue);
        }
    }


    // Getters and setters:

    /**
     * This getter returns a reference on inner int[][] array
     * ("value" property).
     *
     * @return inner 2-dimension array "value", which interprets new inner structure
     * of current matrix (this).
     * @see Matrix#value
     * */
    public int[][] get() {
        return value;
    }

    /**
     * This setter resets matrix content and structure
     * (sets new inner int[][] array and resets "rows" and "cols" properties).
     *
     * @param value - ineger 2-dimension array, which interprets new inner structure
     *              of current matrix (this).
     *
     * @return true, if set operation was successful, or false, if it wasn't.
     * */
    public boolean set(int[][] value) {
        if (!isMatrix(value)) {
            return false;
        }
        this.value = value;
        rows = value.length;
        cols = value[0].length;
        return true;
    }

    /**
     * This getter returns number of rows in matrix
     * (length of "value" array).
     *
     * @return int value - number of rows in matrix.
     * */
    public int rows() {
        return rows;
    }

    /**
     * This getter returns number of columns in matrix
     * (length of any subarray in "value" array).
     *
     * @return int value - number of columns in matrix.
     * */
    public int cols() {
        return cols;
    }


    // Main logic public methods:

    /**
     * This static method returns result of matrix multiplication of two inputed matrices
     * (Matrix class instances).
     *
     * @param matrixA Matrix class instances, that have suitable sizes
     *                (validated in isMatrix() method and firs "if" statement).
     * @param matrixB Matrix class instances, that have suitable sizes
     *                (validated in isMatrix() method and firs "if" statement).
     *
     * @return result matrix (Matrix class instance) if success an
     * null if inputed arguments are wrong.
     *
     * <b>Attention!</b>
     * This method is a simple realisation of Matrix-to-Matrix multiplication algorithm. Search
     * for more information about this algorithm in any High Math educational resources to understand
     * full logic of this method.
     * */
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

    /**
     * This method returns result of matrix multiplication of current (this) matrix
     * and inputed matrix (Matrix class instance).
     *
     * @param matrix Matrix class instances, that has suitable sizes
     *               (validated in isMatrix() method and firs "if" statement).
     *
     * @return result matrix (Matrix class instance) if success an
     * null if inputed argument or current matrix are wrong.
     *
     * <b>Attention!</b>
     * This method is a simple realisation of Matrix-to-Matrix multiplication algorithm. Search
     * for more information about this algorithm in any High Math educational resources to understand
     * full logic of this method.
     *
     * All logic description could be found in documentation of static "multiply(Matrix, Matrix)" method.
     * @see Matrix#multiply(Matrix, Matrix)
     * */
    public Matrix multiply(Matrix matrix) {
        return multiply(this, matrix);
    }

    /**
     * This static method returns result of matrix multiplication of matrix (Matrix class instances)
     * and integer number.
     *
     * @param matrix Matrix class instances, that has suitable sizes
     *               (validated in isMatrix() method and firs "if" statement).
     * @param number integer value, which first argument (Matrix class instance)
     *               will be multiplied by.
     *
     * @return result matrix (Matrix class instance) if success an
     * null if inputed arguments are wrong.
     *
     * <b>Attention!</b>
     * This method is a simple realisation of Matrix-to-Number multiplication algorithm. Search
     * for more information about this algorithm in any High Math educational resources to understand
     * full logic of this method.
     * */
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

    /**
     * This method returns result of matrix multiplication of current (this) matrix
     * and integer number.
     *
     * @param number integer value, which first argument (Matrix class instance)
     *               will be multiplied by.
     *
     * @return result matrix (Matrix class instance) if success an
     * null if inputed argument or current matrix are wrong.
     *
     * <b>Attention!</b>
     * This method is a simple realisation of Matrix-to-Number multiplication algorithm. Search
     * for more information about this algorithm in any High Math educational resources to understand
     * full logic of this method.
     *
     * All logic description could be found in documentation of static "multiply(Matrix, int)" method.
     * @see Matrix#multiply(Matrix, int)
     * */
    public Matrix multiply(int number) {
        return multiply(this, number);
    }

    /**
     * This static method returns reference on formatted matrix argument (Matrix class instance).
     * for_teacher.Main logic is to fill matrix with "digit" value.
     *
     * @param matrix Matrix class instance, that has suitable sizes
     *               (validated in isMatrix() method and firs "if" statement).
     * @param digit integer value, which first argument (Matrix class instance)
     *              will be filled with.
     *
     * @return reference on changed arguement matrix (Matrix class instance) if success and
     * null if inputed arguments are wrong.
     *
     * <b>Attention!<b/>
     * This method doesn't create new instance of Matrix class. It changes inputed value by
     * its reference. So, be careful when use it!
     * */
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

    /**
     * This method returns reference on formatted (refilled) current (this) matrix.
     *
     * @param digit integer value, which first argument (Matrix class instance)
     *              will be filled with.
     *
     * @return reference on changed current matrix (Matrix class instance) if success and
     * null if inputed arguement or currenr matrix are wrong.
     *
     * <b>Attention!<b/>
     * This method doesn't create new instance of Matrix class. It changes inputed value by
     * its reference. So, be careful when use it!
     *
     * All logic description could be found in documentation of static "fill(Matrix, int)" method.
     * @see Matrix#fill(Matrix, int)
     * */
    public Matrix fill(int digit) {
        return fill(this, digit);
    }

    /**
     * This static method returns result of matrix transpose of inputed matrix
     * (Matrix class instances).
     *
     * @param matrix Matrix class instance, that has suitable sizes
     *               (validated in isMatrix() method and firs "if" statement).
     *
     * @return result matrix (Matrix class instance) if success and
     * null if inputed arguments are wrong.
     *
     * Attention!
     * This method is a simple realisation of Matrix transpose algorithm. Search
     * for more information about this algorithm in any High Math educational resources to understand
     * full logic of this method.
     * */
    public static Matrix transpose(Matrix matrix) {
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
                resVal[i][j] = matrixVal[j][i];
            }
        }

        return res;
    }

    /**
     * This method returns result of matrix transpose of current (this) matrix.
     *
     * @return result matrix (Matrix class instance) if success and
     * null if inputed current matrix is wrong.
     *
     * All logic description could be found in documentation of static "transpose(Matrix)" method.
     * @see Matrix#transpose(Matrix)
     * */
    public Matrix transpose() {
        return transpose(this);
    }

    /**
     * This static method returns result of matrix summing of two inputed matrices
     * (Matrix class instances).
     *
     * @param matrixA Matrix class instances, that have suitable sizes
     *                (validated in isMatrix() method and firs "if" statement).
     * @param matrixB Matrix class instances, that have suitable sizes
     *                (validated in isMatrix() method and firs "if" statement).
     *
     * @return result matrix (Matrix class instance) if success and
     * null if inputed arguments are wrong.
     *
     * Attention!
     * This method is a simple realisation of Matrix-toMatrix summing algorithm. Search
     * for more information about this algorithm in any High Math educational resources to understand
     * full logic of this method.
     * */
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

    /**
     * This method returns result of matrix summing of current (this) matrix and inputed matrix
     * (Matrix class instances).
     *
     * @param matrix Matrix class instance, that has suitable sizes
     *               (validated in isMatrix() method and firs "if" statement).
     *
     * @return result matrix (Matrix class instance) if success and
     * null if inputed argument or current matrix are wrong.
     *
     * All logic description could be found in documentation of static "add(Matrix, Matrix)" method.
     * @see Matrix#add(Matrix, Matrix)
     * */
    public Matrix add(Matrix matrix) {
        return add(this, matrix);
    }

    /**
     * This static method returns the biggest element of inputed matrix (Matrix class instance).
     *
     * Main logic is to search for the biggest element in matrix using nested "for()" statements.
     *
     * @param matrix Matrix class instance, that has suitable sizes
     *               (validated in isMatrix() method and firs "if" statement).
     *
     * @return result int value (Integer class instance) if success and
     * null if inputed arguments are wrong.
     * */
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

    /**
     * This method returns the biggest element of current (this) matrix.
     *
     * @return result int value (Integer class instance) if success and
     * null if current matrix is wrong.
     *
     * All logic description could be found in documentation of static "getMaximum(Matrix)" method.
     * @see Matrix#getMaximum(Matrix)
     * */
    public Integer getMaximum() {
        return getMaximum(this);
    }

    /**
     * This static method returns result of sorting of inputed matrix's rows.
     *
     * Main logic is to sort each row of inputed matrix (Matrix class instance)
     * using "sort()" method from Arrays library (java.util.Arrays). Sorted
     * row logically will have such view as {minimum, ..., maximum}.
     * @see Arrays#sort(int[])
     *
     * @param matrix Matrix class instance, that has suitable sizes
     *               (validated in isMatrix() method and firs "if" statement).
     *
     * @return result matrix (Matrix class instance) if success and
     * null if inputed argument is wrong.
     * */
    public static Matrix sortRows(Matrix matrix) {
        if (!isMatrix(matrix.get())) {
            return null;
        }

        Matrix res = new Matrix(matrix.rows(), matrix.cols());
        int[][] resVal = res.get();
        int[][] matrixVal = matrix.get();

        for (int i = 0; i < resVal.length; i++) {
            resVal[i] = Arrays.copyOf(matrixVal[i], resVal[i].length);
            Arrays.sort(resVal[i]);
        }

        return res;
    }

    /**
     * This method returns result of sorting of current (this) matrix's rows.
     *
     * @return result matrix (Matrix class instance) if success and
     * null if current matrix is wrong.
     *
     * All logic description could be found in documentation of static "sortRows(Matrix)" method.
     * @see Matrix#sortRows(Matrix)
     * */
    public Matrix sortRows() {
        return sortRows(this);
    }

    /**
     * This static method returns result of sorting of inputed matrix's columns.
     *
     * Main logic is to transpose inputed matrix (Matrix class instance) using "transpose()" method and
     * than sort each row of transposed matrix (Matrix class instance)
     * using "sort()" method from "Arrays" library (java.util.Arrays).
     * Sorted column logically will have such view as {minimum, ..., maximum}.
     * @see Arrays#sort(int[])
     * @see Matrix#transpose()
     *
     * @param matrix Matrix class instance, that has suitable sizes
     *               (validated in isMatrix() method and firs "if" statement).
     *
     * @return  result matrix (Matrix class instance) if success and
     * null if inputed argument is wrong.
     * */
    public static Matrix sortCols(Matrix matrix) {
        if (!isMatrix(matrix.get())) {
            return null;
        }

        Matrix res = matrix.transpose();
        int[][] resVal = res.get();

        for (int j = 0; j < resVal.length; j++) {
            Arrays.sort(resVal[j]);
        }

        return res.transpose();
    }

    /**
     * This method returns result of sorting of current (this) matrix's columns.
     *
     * @return result matrix (Matrix class instance) if success and
     * null if current matrix is wrong.
     *
     * All logic description could be found in documentation of static "sortCols(Matrix)" method.
     * @see Matrix#sortCols(Matrix)
     * */
    public Matrix sortCols() {
        return sortCols(this);
    }


    // Secondary (utility) logic public static methods:

    /**
     * This static method returns result of matrix-validation check of inputed matrix
     * (2-dimensional int array).
     *
     * for_teacher.Main logic is to check if matrix (int[][] array):
     *  - is null;
     *  - is empty ("matrix" array's length < 1);
     *  - has any row (int[] array), which is null or empty (ist length < 1);
     *  - has any row (int[] array), which length is not equal to length of
     *    the first row ("matrix[0]" array).
     *
     * @param matrix 2-dimensional integer array (int[][]).
     *
     * @return true, if inputed argument (array) fits all requirements
     * (were mentioned above), and false, if it doesn't.
     * */
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

    /**
     * This static method returns result of square-matrix-validation check of inputed matrix
     * (2-dimensional int array).
     *
     * Main logic is to check if matrix (int[][] array):
     *  - is matrix
     *    @see Matrix#isMatrix(int[][]);
     *  - its rows number ("matrix" array length) is equal to its
     *    columns number - length of any row (subarray of "matrix" array).
     *
     * @param matrix 2-dimensional integer array (int[][]).
     *
     * @return true, if inputed argument (array) fits all requirements
     * (were mentioned above), and false, if it doesn't.
     *  */
    public static boolean isSquareMatrix(int[][] matrix) {
        return isMatrix(matrix) &&
                matrix[0].length == matrix.length;
    }
}