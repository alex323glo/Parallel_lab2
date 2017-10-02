import org.junit.*;

import util.LabUtils.*;

public class TestLabUtils {

    private static final int DEFAULT_ROWS_NUM = 4;
    private static final int DEFAULT_COLS_NUM = 4;

    private static Matrix matrixA;
    private static Matrix matrixB;

    private static Matrix vectorC;
    private static Matrix vectorD;

    private static Matrix vectorE;
    private static Matrix vectorF;

    @BeforeClass
    public static void prepareClass() {
        matrixA = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM);
        matrixB = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM);

        vectorC = new Matrix(1, DEFAULT_COLS_NUM);
        vectorD = new Matrix(1, DEFAULT_COLS_NUM);

        vectorE = new Matrix(DEFAULT_ROWS_NUM, 1);
        vectorF = new Matrix(DEFAULT_ROWS_NUM, 1);
    }

    @Before
    public void prepare() {
        matrixA.fill(1);
        matrixB.fill(1);
        vectorC.fill(1);
        vectorD.fill(1);
        vectorE.fill(1);
        vectorF.fill(1);
    }

    @Test
    public void multiplyMM() {
        Matrix testMatrix = new Matrix(DEFAULT_ROWS_NUM, DEFAULT_COLS_NUM);
        testMatrix.fill(4);
        Matrix res = matrixA.multiply(matrixB);
        Assert.assertArrayEquals(testMatrix.get(), matrixA.multiply(matrixB).get());
    }

}
