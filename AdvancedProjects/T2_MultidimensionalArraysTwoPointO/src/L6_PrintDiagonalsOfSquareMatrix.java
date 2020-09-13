import java.util.Arrays;
import java.util.Scanner;

public class L6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = Integer.parseInt(scan.nextLine());

        int[][] squareMatrix  = new int[dimensions][dimensions];

        for (int row = 0; row < squareMatrix.length; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                squareMatrix[row] = arr;
        }

        for (int row = 0; row < squareMatrix.length; row++) {
                System.out.print(squareMatrix[row][row] + " ");
        }

        System.out.println();
        int col = 0;
        int row = squareMatrix.length-1;

        while (col < squareMatrix.length  && row >= 0){// col < dimensions
            System.out.print(squareMatrix[row--][col++] + " ");
        }

    }
}
