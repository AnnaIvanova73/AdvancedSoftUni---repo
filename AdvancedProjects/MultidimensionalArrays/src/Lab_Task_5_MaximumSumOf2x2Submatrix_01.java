import java.util.Arrays;
import java.util.Scanner;
//0.96s
public class Lab_Task_5_MaximumSumOf2x2Submatrix_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] innerArray = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = innerArray;
        }

        int maxSum = Integer.MIN_VALUE;
        String result = "";
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int curr = matrix[r][c];
                int belowCurrent = matrix[r + 1][c];
                int leftCurr = matrix[r][c + 1];
                int belowLeft = matrix[r + 1][c + 1];
                int sum = curr + belowCurrent + leftCurr + belowLeft;

                if (sum > maxSum) {
                    maxSum = sum;
                    result = curr + " " + leftCurr + " " + System.lineSeparator() + belowCurrent + " " + belowLeft;
                }
            }
        }

        System.out.println(result);
        System.out.println(maxSum);
    }
}
