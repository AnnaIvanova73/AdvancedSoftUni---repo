import java.util.Arrays;
import java.util.Scanner;

public class E4_MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = "\\s+";

        int[] input = readArray(scan, pattern);
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = readMatrix(scan, rows, cols, pattern);

        int[] output = new int[2];
        int maxSum = Integer.MIN_VALUE;
        for (int row = 1; row < matrix.length - 1; row++) {
            for (int col = 1; col < matrix[row].length - 1; col++) {
                int sum = sumElements(row, col, matrix);
                if (maxSum < sum) {
                    maxSum = sum;
                    output[0] = row;
                    output[1] = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        int row = output[0] - 1;
        int col = output[1] - 1;
        printMatrix(matrix, row, col);

    }

    private static void printMatrix(int[][] matrix, int row, int col) {
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col +  3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int sumElements(int row, int col, int[][] matrix) {
        int currentNum = matrix[row][col];
        int up = matrix[row - 1][col];
        int down = matrix[row + 1][col];
        int right = matrix[row][col + 1];
        int left = matrix[row][col - 1];
        int upLeft = matrix[row - 1][col - 1];
        int downLeft = matrix[row + 1][col - 1];
        int rightUp = matrix[row - 1][col + 1];
        int rightDown = matrix[row + 1][col + 1];

        return currentNum + up + down + right + left + upLeft + downLeft + rightUp + rightDown;
    }

    private static int[][] readMatrix(Scanner scan, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] array = readArray(scan, pattern);
            matrix[row] = array;
        }

        return matrix;
    }

    private static int[] readArray(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
