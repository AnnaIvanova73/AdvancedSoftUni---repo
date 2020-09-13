import java.util.Arrays;
import java.util.Scanner;

public class Exercise_Task_4_MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int columns = scan.nextInt();
        int[][] matrix = new int[rows][columns];
        fillMatrix(scan, matrix);

        int maxSum = -1;
        int rowIndex = 0;
        int colIndex = 0;
        for (int row = 1; row < matrix.length-1; row++) {
            for (int col = 1; col < matrix[row].length-1; col++) {
                int sumInnerMatrix = calculateSumElementsInnerSquareMatrix(matrix,row,col);

                if(sumInnerMatrix >maxSum){
                    maxSum = sumInnerMatrix;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }

        if(maxSum != -1){
            System.out.println("Sum = " + maxSum);
            printInnerMatrix(rowIndex,colIndex,matrix);
        }


    }

    private static void printInnerMatrix(int rowIndex, int colIndex, int[][] matrix) {
        rowIndex--;
        colIndex--;
        for (int row =rowIndex ; row < rowIndex + 3 ; row++) {
            for (int col = colIndex; col < colIndex + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateSumElementsInnerSquareMatrix(int[][] matrix, int r, int c) {
        int sum = 0;

        int middleNum = matrix[r][c];

        int upNum = matrix[r-1][c];
        int belowNum = matrix[r+1][c];

        int rightNum = matrix[r][c-1];
        int leftNum = matrix[r][c+1];

        int primaryUpLeft = matrix[r-1][c- 1];
        int primaryBottomRight = matrix[r+1][c+1];

        int secondaryUpRight = matrix[r-1][c+1];
        int secondaryBottomLeft = matrix[r+1][c-1];

        sum+= middleNum + upNum + belowNum + rightNum + leftNum +
                primaryUpLeft + primaryBottomRight + secondaryUpRight + secondaryBottomLeft;
        return sum;
    }

    private static void fillMatrix(Scanner scan, int[][] matrix) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int colInd = 0; colInd < matrix[rowIndex].length; colInd++) {
                matrix[rowIndex][colInd] = scan.nextInt();
            }
        }
    }
}
