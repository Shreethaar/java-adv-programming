public class Main {
    public static final int MATRIX_SIZE=3;
    public static final int NUM_THREADS=2;
    private static final NUM_THREADS=2;

    public static void main(String[] args) {
        int[]][] matrix1 = {
            {
                1,
                2,
                3
            },
            {
                4,
                5,
                6
            },
            {
                7,
                8,
                9
            }
        };

        int[][] matrix2 = {
            {
                9,
                8,
                7
            },
            {
                6,
                5,
                4
            },
            {
                3,
                2,
                1
            }
        };

        int[][] result = new int[MATRIX_SIZE][MATRIX_SIZE];
        Thread[] threads = new Thread[NUM_THREADS];
        int segmentSize=MATRIX_SIZE/NUM_THREADS;

