import java.util.Arrays;
import java.util.Scanner;
//0.98
public class Lab_Task_5_MaximumSumOf2x2Submatrix_03 {
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
        int[][] result = new int[2][2];
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int curr = matrix[r][c];
                int belowCurrent = matrix[r + 1][c];
                int rightCurr = matrix[r][c + 1];
                int belowRight = matrix[r + 1][c + 1];
                int sum = curr + belowCurrent + rightCurr + belowRight;

                if (sum > maxSum) {
                    maxSum = sum;
                    result[0][0] = curr;
                    result[0][1] = rightCurr;
                    result[1][0] = belowCurrent;
                    result[1][1] = belowRight;

                }
            }
        }

        for (int i = 0; i <2; i++) {
            for (int j = 0; j <2; j++) {
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
