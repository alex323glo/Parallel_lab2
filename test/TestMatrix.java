import org.junit.*;

import util.Matrix;

import java.util.Arrays;

/**
 * Class: TestMatrix (tests).
 * @author alex323glo
 * @version 1.0.0
 *
 * Main purpose: TDD realisation.
 *
 * Tested class: Matrix class
 * @see Matrix
 * */
public class TestMatrix {

    // Properties and fields:

    //  Default matrices' size:
    private static final int DEFAULT_ROWS_NUM = 4;
    private static final int DEFAULT_COLS_NUM = 4;

    //  Test matrices (and vectors):
    private static Matrix matrixA;
    private static Matrix matrixB;

    private static Matrix vectorC;
    private static Matrix vectorD;

    private static Matrix vectorE;
    private static Matrix vectorF;

    // Testing methods:

    //  Tests' preparation:
    @Before
    public void prepare() {
        matrixA = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM, 1);
        matrixB = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM, 1);

        vectorC = new Matrix(1, DEFAULT_COLS_NUM, 1);
        vectorD = new Matrix(1, DEFAULT_COLS_NUM, 1);

        vectorE = new Matrix(DEFAULT_ROWS_NUM, 1, 1);
        vectorF = new Matrix(DEFAULT_ROWS_NUM, 1, 1);
    }

    /**
     * Tested method: get()
     *
     * @see Matrix#get()
     * */
    @Test
    public void get() {
        int[][] expected = new int[DEFAULT_ROWS_NUM][];
        for (int i = 0; i < DEFAULT_ROWS_NUM; i++) {
            expected[i] = new int[DEFAULT_COLS_NUM];
            Arrays.fill(expected[i], 1);
        }
        int[][] res = matrixA.get();

        Assert.assertArrayEquals(expected, res);
    }

    /**
     * Tested method: set(int[][])
     *
     * @see Matrix#set(int[][])
     * */
    @Test
    public void set() {
        int[][] correct = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2,}
        };
        int[][] wrong1 = {};
        int[][] wrong2 = null;

        Assert.assertTrue(matrixA.set(correct));

        Assert.assertArrayEquals(matrixA.get(), Arrays.copyOf(correct, correct.length));

        Assert.assertFalse(matrixA.set(wrong1));

        Assert.assertFalse(matrixA.set(wrong2));
    }

    /**
     * Tested method: rows()
     *
     * @see Matrix#rows()
     * */
    @Test
    public void rows() {
        Assert.assertEquals(matrixA.rows(), DEFAULT_ROWS_NUM);

        Assert.assertEquals(vectorC.rows(), 1);

        Assert.assertEquals(vectorE.rows(), DEFAULT_ROWS_NUM);

        int testRowsNum = 3;
        Matrix matrix = new Matrix(testRowsNum, 5, 11);

        Assert.assertEquals(matrix.rows(), testRowsNum);
    }

    /**
     * Tested method: cols()
     *
     * @see Matrix#cols()
     * */
    @Test
    public void cols() {
        Assert.assertEquals(matrixA.cols(), DEFAULT_COLS_NUM);

        Assert.assertEquals(vectorC.cols(), DEFAULT_COLS_NUM);

        Assert.assertEquals(vectorE.cols(), 1);

        int testColsNum = 5;
        Matrix matrix = new Matrix(3, testColsNum, 11);

        Assert.assertEquals(matrix.cols(), testColsNum);
    }

    /**
     * Tested method: multiply(Matrix, Matrix) (static)
     *
     * @see Matrix#multiply(Matrix, Matrix)
     * */
    @Test
    public void multiplyMatrixToMatrixStatic() {
        Matrix expected = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM, 4);
        Matrix res = Matrix.multiply(matrixA, matrixB);

        Assert.assertArrayEquals(expected.get(), res.get());
    }

    /**
     * Tested method: multiply(Matrix)
     *
     * @see Matrix#multiply(Matrix)
     * */
    @Test
    public void multiplyMatrixToMatrix() {
        Matrix expected = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM, 4);
        Matrix res = matrixA.multiply(matrixB);

        Assert.assertArrayEquals(expected.get(), res.get());
    }

    /**
     * Tested method: multiply(Matrix, int) (static)
     *
     * @see Matrix#multiply(Matrix, int)
     * */
    @Test
    public void multiplyMatrixToNumberStatic() {
        Matrix expected = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM, 4);
        Matrix res = Matrix.multiply(matrixA, 4);

        Assert.assertArrayEquals(expected.get(), res.get());
    }

    /**
     * Tested method: multiply(int)
     *
     * @see Matrix#multiply(int)
     * */
    @Test
    public void multiplyMatrixToNumber() {
        Matrix expected = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM, 4);
        Matrix res = matrixA.multiply(4);

        Assert.assertArrayEquals(expected.get(), res.get());
    }

    /**
     * Tested method: fill(Matrix, int) (static)
     *
     * @see Matrix#fill(Matrix, int)
     * */
    @Test
    public void fillStatic() {
        int testValue = -20;
        int[][] expected = new int[DEFAULT_ROWS_NUM][];
        for (int i = 0; i < DEFAULT_ROWS_NUM; i++) {
            expected[i] = new int[DEFAULT_COLS_NUM];
            Arrays.fill(expected[i], testValue);
        }

        Assert.assertArrayEquals(Matrix.fill(matrixA, testValue).get(), expected);
    }

    /**
     * Tested method: fill(int)
     *
     * @see Matrix#fill(int)
     * */
    @Test
    public void fill() {
        int testValue = 200;
        int[][] expected = new int[DEFAULT_ROWS_NUM][];
        for (int i = 0; i < DEFAULT_ROWS_NUM; i++) {
            expected[i] = new int[DEFAULT_COLS_NUM];
            Arrays.fill(expected[i], testValue);
        }

        Assert.assertArrayEquals(matrixA.fill(testValue).get(), expected);
    }

    /**
     * Tested method: transpose(Matrix) (static)
     *
     * @see Matrix#transpose(Matrix)
     * */
    @Test
    public void transposeStatic() {
        int[][] testValue = {
                {1, 1},
                {0, 0}};
        int[][] expected =  {
                {1, 0},
                {1, 0}};
        matrixA.set(testValue);

        Assert.assertArrayEquals(Matrix.transpose(matrixA).get(), expected);
    }

    /**
     * Tested method: transpose()
     *
     * @see Matrix#transpose()
     * */
    @Test
    public void transpose() {
        int[][] testValue = {
                {1, 1},
                {0, 0}};
        int[][] expected =  {
                {1, 0},
                {1, 0}};
        matrixA.set(testValue);

        Assert.assertArrayEquals(matrixA.transpose().get(), expected);
    }

    /**
     * Tested method: add(Matrix, Matrix) (static)
     *
     * @see Matrix#add(Matrix, Matrix)
     * */
    @Test
    public void addStatic() {
        Matrix expected = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM, 2);
        Matrix result = Matrix.add(matrixA, matrixB);

        Assert.assertArrayEquals(result.get(), expected.get());
    }

    /**
     * Tested method: add(Matrix)
     *
     * @see Matrix#add(Matrix)
     * */
    @Test
    public void add() {
        Matrix expected = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM, 2);
        Matrix result = matrixA.add(matrixB);

        Assert.assertArrayEquals(result.get(), expected.get());
    }

    /**
     * Tested method: getMaximum(Matrix) (static)
     *
     * @see Matrix#getMaximum(Matrix)
     * */
    @Test
    public void getMaximumStatic() {
        int[][] testValue = {
                {1, 3},
                {2, -4}};
        Integer expected = 3;
        matrixA.set(testValue);

        Assert.assertEquals(Matrix.getMaximum(matrixA), expected);

        Assert.assertEquals(Matrix.getMaximum(matrixB).intValue(), 1);
    }

    /**
     * Tested method: getMaximum()
     *
     * @see Matrix#getMaximum()
     * */
    @Test
    public void getMaximum() {
        int[][] testValue = {
                {10, -30},
                {20, 4}};
        Integer expected = 20;
        matrixA.set(testValue);

        Assert.assertEquals(matrixA.getMaximum(), expected);

        Assert.assertEquals(matrixB.getMaximum().intValue(), 1);
    }

    /**
     * Tested function: sortRows(Matrix) (static)
     *
     * @see Matrix#sortRows(Matrix)
     * */
    @Test
    public void sortRowsStatic() {
        int[][] testValue = {
                {4, 11, -5},
                {12, 10, 11},
                {-8, 15, 0}};
        int[][] expected =  {
                {-5, 4, 11},
                {10, 11, 12},
                {-8, 0, 15}};
        matrixA.set(testValue);

        Assert.assertArrayEquals(Matrix.sortRows(matrixA).get(), expected);
    }

    /**
     * Tested function: sortRows()
     *
     * @see Matrix#sortRows()
     * */
    @Test
    public void sortRows() {
        int[][] testValue = {
                {4, 11, -5},
                {12, 10, 11},
                {-8, 15, 0}};
        int[][] expected =  {
                {-5, 4, 11},
                {10, 11, 12},
                {-8, 0, 15}};
        matrixA.set(testValue);

        Assert.assertArrayEquals(matrixA.sortRows().get(), expected);
    }

    /**
     * Tested function: sortCols(Matrix) (static)
     *
     * @see Matrix#sortCols(Matrix)
     * */
    @Test
    public void sortColsStatic() {
        int[][] testValue = {
                {4, 11, -5},
                {12, 10, 11},
                {-8, 15, 0}};
        int[][] expected = {
                {-8, 10, -5},
                {4, 11, 0},
                {12, 15, 11}};
        matrixA.set(testValue);

        Assert.assertArrayEquals(Matrix.sortCols(matrixA).get(), expected);
    }

    /**
     * Tested function: sortCols()
     *
     * @see Matrix#sortCols()
     * */
    @Test
    public void sortCols() {
        int[][] testValue = {
                {4, 11, -5},
                {12, 10, 11},
                {-8, 15, 0}};
        int[][] expected = {
                {-8, 10, -5},
                {4, 11, 0},
                {12, 15, 11}};
        matrixA.set(testValue);

        Assert.assertArrayEquals(matrixA.sortCols().get(), expected);
    }

    /**
     * Tested method: isMatrix(int[][]) (static)
     *
     * @see Matrix#isMatrix(int[][])
     * */
    @Test
    public void isMatrix() {
        Assert.assertTrue(Matrix.isMatrix(matrixA.get()));

        Assert.assertTrue(Matrix.isMatrix(matrixB.get()));

        Assert.assertTrue(Matrix.isMatrix(vectorC.get()));

        Assert.assertTrue(Matrix.isMatrix(vectorD.get()));

        Assert.assertTrue(Matrix.isMatrix(vectorE.get()));

        Assert.assertTrue(Matrix.isMatrix(vectorF.get()));

        int[][] wrong1 = null;
        int[][] wrong2 = {};
        int[][] wrong3 = {
                {1, 2, 3},
                {},
                {4, 5, 6}
        };
        int[][] wrong4 = {
                {1, 2, 3},
                null,
                {4, 5, 6}
        };
        int[][] wrong5 = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8}
        };

        Assert.assertFalse(Matrix.isMatrix(wrong1));

        Assert.assertFalse(Matrix.isMatrix(wrong2));

        Assert.assertFalse(Matrix.isMatrix(wrong3));

        Assert.assertFalse(Matrix.isMatrix(wrong4));

        Assert.assertFalse(Matrix.isMatrix(wrong5));
    }

    /**
     * Tested method: isSquareMatrix(int[][]) (static)
     *
     * @see Matrix#isSquareMatrix(int[][])
     * */
    @Test
    public void isSquareMatrix() {
        Assert.assertTrue(Matrix.isSquareMatrix(matrixA.get()));

        Assert.assertTrue(Matrix.isSquareMatrix(matrixB.get()));

        Assert.assertFalse(Matrix.isSquareMatrix(vectorC.get()));

        Assert.assertFalse(Matrix.isSquareMatrix(vectorD.get()));

        Assert.assertFalse(Matrix.isSquareMatrix(vectorE.get()));

        Assert.assertFalse(Matrix.isSquareMatrix(vectorF.get()));

        int[][] correct = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] wrong1 = null;
        int[][] wrong2 = {};
        int[][] wrong3 = {
                {1, 2, 3},
                {},
                {4, 5, 6}
        };
        int[][] wrong4 = {
                {1, 2, 3},
                null,
                {4, 5, 6}
        };
        int[][] wrong5 = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8}
        };

        Assert.assertTrue(Matrix.isSquareMatrix(correct));

        Assert.assertFalse(Matrix.isSquareMatrix(wrong1));

        Assert.assertFalse(Matrix.isSquareMatrix(wrong2));

        Assert.assertFalse(Matrix.isSquareMatrix(wrong3));

        Assert.assertFalse(Matrix.isSquareMatrix(wrong4));

        Assert.assertFalse(Matrix.isSquareMatrix(wrong5));
    }

}
