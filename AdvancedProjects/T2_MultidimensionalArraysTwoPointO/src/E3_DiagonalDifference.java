import java.util.Arrays;
import java.util.Scanner;

public class E3_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        int[][] squareMatrix = readMatrix(scan,size);

        int primaryDiagonal = sumPrimaryDiagonal (squareMatrix);
        int secondaryDiagonal = sumSecondaryDiagonal(squareMatrix);

        int result = Math.abs(primaryDiagonal-secondaryDiagonal);
        System.out.println(result);
    }

    private static int sumSecondaryDiagonal(int[][] squareMatrix) {
        int sum = 0;
        for (int decreasingCounter = squareMatrix.length - 1; decreasingCounter >= 0  ; decreasingCounter--) {
            sum+=squareMatrix[squareMatrix.length - 1 - decreasingCounter][decreasingCounter];
        }
        return sum;
    }

    private static int sumPrimaryDiagonal(int[][] squareMatrix) {
        int sum = 0;
        for (int increasingCounter = 0; increasingCounter < squareMatrix.length; increasingCounter++) {
            sum+= squareMatrix[increasingCounter][increasingCounter];
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scan,int size) {
        int[][] squareMatrix = new int[size][size];
        for (int row = 0; row < squareMatrix.length; row++) {
            int[] innerArray = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer:: parseInt).toArray();
            squareMatrix[row] = innerArray;
        }
        return squareMatrix;
    }
}
