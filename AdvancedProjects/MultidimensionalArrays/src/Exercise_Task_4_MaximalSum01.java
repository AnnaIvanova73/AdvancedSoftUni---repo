import java.util.Arrays;
import java.util.Scanner;

public class Exercise_Task_4_MaximalSum01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = -1;
        int rowIndex = 0;
        int colIndex = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int widthLimit = row + 2;
                int lengthLimit = col + 2;

                if (!(isInBounds(widthLimit, rows - 1)) || !isInBounds(lengthLimit, columns - 1)) {
                    break;
                }

                int sumInnerMatrix = calculateSumElements(row, col, matrix);
                if (maxSum < sumInnerMatrix) {
                    maxSum = sumInnerMatrix;
                    rowIndex = row;
                    colIndex = col;
                }

            }
        }

        if(maxSum != -1){
            System.out.println("Sum = " + maxSum);
            printMatrix ( rowIndex,colIndex,matrix);
        }
    }

    private static void printMatrix(int row, int col, int[][] matrix) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateSumElements(int row, int col, int[][] matrix) {
        int sum = 0;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static boolean isInBounds(int limit, int size) {
        return size >= limit;
    }
}
