package for_teacher;

import util.Matrix;

/**
 * Class: MainFunctions (static methods' container).
 * @author alex323glo
 * @version 1.0.0
 *
 * Main purpose: lab work task realisation.
 *
 * Based on Matrix class.
 * @see Matrix
 * */
public class MainFunctions {

    // Main logic public methods:

    /**
     * f1: c = MAX(MA * MB) * (A * B),
     * where c - number; MA, MB - matrices; A, B - vectors.
     *
     * @param size int vale, which stands for number of rows and columns for
     *             all matrices and vectors in f1() function realisation.
     *
     * @return result of f1() function.
     *
     * @see Matrix
     * @see Matrix#get()
     * @see Matrix#multiply(Matrix)
     * @see Matrix#getMaximum()
     * */
    public static int f1(int size) {
        Matrix matrixA = new Matrix(size, size, 1),
                matrixB = new Matrix(size, size, 1),
                vectorA = new Matrix(1, size, 1),
                vectorB = new Matrix(size, 1, 1);

        return (matrixA.multiply(matrixB).getMaximum()) *
                (vectorA.multiply(vectorB).get()[0][0]);
    }

    /**
     * f2: MF = MAX(MG) * (MH * MK),
     * where MF, MG, MH, MK - matrices.
     *
     * @param size int vale, which stands for number of rows and columns for
     *             all matrices and vectors in f2() function realisation.
     *
     * @return result of f2() function.
     *
     * @see Matrix
     * @see Matrix#get()
     * @see Matrix#multiply(Matrix)
     * @see Matrix#getMaximum()
     */
    public static int[][] f2(int size) {
        Matrix matrixG = new Matrix(size, size, 1),
                matrixH = new Matrix(size, size, 1),
                matrixK = new Matrix(size, size, 1);

        return matrixH.multiply(matrixK)
                .multiply(matrixG.getMaximum())
                .get();
    }

     /**
      * f3: T = SORT(O + P) * TRANS(MR * MS),
      * where MR, MS - matrices; T, O, P - vectors.
      *
      * @param size int vale, which stands for number of rows and columns for
      *             all matrices and vectors in f3() function realisation.
      *
      * @return result of f3() function.
      *
      * @see Matrix
      * @see Matrix#get()
      * @see Matrix#multiply(Matrix)
      * @see Matrix#add(Matrix)
      * @see Matrix#transpose()
      * @see Matrix#sortRows()
      * */
    public static int[] f3(int size) {
        Matrix matrixR = new Matrix(size, size, 1),
                matrixS = new Matrix(size, size, 1),
                vectorO = new Matrix(1, size, 1),
                vectorP = new Matrix(1, size, 1);

        return vectorO.add(vectorP).sortRows()
                .multiply(matrixR.multiply(matrixS).transpose())
                .get()[0];
    }
}
