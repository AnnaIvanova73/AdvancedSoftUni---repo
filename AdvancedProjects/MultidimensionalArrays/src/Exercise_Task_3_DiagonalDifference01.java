import java.util.Scanner;

public class Exercise_Task_3_DiagonalDifference01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();

        int[][] squareMatrix = new int[size][size];

        for (int row = 0; row < squareMatrix.length; row++) {
            for (int col = 0; col < squareMatrix[row].length; col++) {
                squareMatrix[row][col] = scan.nextInt();
            }
        }

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int r = 0; r < squareMatrix.length; r++) {
            for (int c = 0; c < squareMatrix[r].length; c++) {
                if(r==c){
                    int primaryNum = squareMatrix[r][c];
                    primaryDiagonalSum += primaryNum;
                }
            }
            int secondaryNum = squareMatrix[r][size-1-r];
            secondaryDiagonalSum += secondaryNum;
        }
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }
}
