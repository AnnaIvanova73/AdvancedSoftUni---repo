import java.util.Arrays;
import java.util.Scanner;

public class E11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimension = readArray(scan);
        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = readArray(scan);
            matrix[row] = arr;
        }

        System.out.println();
        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0) {

            int r = row;
            int c = col;

            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] +  " ");
            }
            System.out.println();
            col--;

            if (col == -1) {
                col = 0;
                row--;
            }

        }
    }
    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
