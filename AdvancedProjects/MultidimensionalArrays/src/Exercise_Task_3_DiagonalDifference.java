import java.util.Arrays;
import java.util.Scanner;

public class Exercise_Task_3_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int primaryDiagonalSum = calculateSumPrimaryDiagonal(matrix);
        int secondaryDiagonalSum = calculateSumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static int calculateSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        int rowIndex = 0;
        int colIndex = 0;

        while (rowIndex < matrix.length && colIndex < matrix.length){
            int currentNum = matrix[rowIndex][colIndex];
            sum+=currentNum;
            rowIndex++;
            colIndex++;
        }
        return sum;
    }

    private static int calculateSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int rowIndex = matrix.length-1;
        int colIndex = 0;

        while(rowIndex >=0 && colIndex < matrix.length){
            int currentNum = matrix[rowIndex][colIndex];
            sum+=currentNum;
            rowIndex--;
            colIndex++;
        }
        return sum;
    }
}
