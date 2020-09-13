import java.util.Arrays;
import java.util.Scanner;
//0.93s
public class Lab_Task_5_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] innerArray = Arrays.stream(scan.nextLine().split(", "))
                    .limit(columns).mapToInt(Integer::parseInt).toArray();
            matrix[i] = innerArray;
        }

        int maxSum = Integer.MIN_VALUE;
        int row = -1;
        int col = -1;
        for (int r = 0; r <matrix.length -1 ; r++) {
            for (int c = 0; c <matrix[r].length -1 ; c++) {
                int curr = matrix[r][c];
                int belowCurrent = matrix[r+1][c];
                int leftCurr = matrix[r][c+1];
                int belowLeft = matrix[r+1][c+1];
                int sum = curr + belowCurrent + leftCurr + belowLeft;

                if(sum > maxSum){
                    maxSum = sum;
                    row = r;
                    col = c;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 ; j++) {
                System.out.print(matrix[row + i][col + j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
