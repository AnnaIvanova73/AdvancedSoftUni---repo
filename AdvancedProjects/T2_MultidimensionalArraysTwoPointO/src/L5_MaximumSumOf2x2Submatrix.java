import java.util.Arrays;
import java.util.Scanner;

public class L5_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String splitPattern = ", ";

        int[] dimensions = readArray(scan, splitPattern);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] innerArray = readArray(scan, splitPattern);
            matrix[row] = innerArray;
        }

        int[][] matrixOutput = new int[2][2];
        int maxSumElements = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int upLeft = matrix[row][col];
                int upRight = matrix[row][col + 1];
                int downLeft = matrix[row + 1][col];
                int downRight = matrix[row + 1][col + 1];

                int sum = upLeft + upRight + downLeft + downRight;

                if (sum > maxSumElements) {
                    maxSumElements = sum;
                    matrixOutput[0][0] = upLeft;
                    matrixOutput[0][1] = upRight;
                    matrixOutput[1][0] = downLeft;
                    matrixOutput[1][1] = downRight;

                }
            }
        }
        printIntegerMatrix(matrixOutput);
        System.out.println(maxSumElements);
    }

    private static void printIntegerMatrix(int[][] matrixOutput) {
        for (int[] innerMatrix : matrixOutput) {
            for (int matrix : innerMatrix) {
                System.out.print(matrix + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
