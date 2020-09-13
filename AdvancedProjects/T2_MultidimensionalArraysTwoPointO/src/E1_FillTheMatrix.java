import java.util.Scanner;

public class E1_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(", ");

        int size = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix;
        if (pattern.equals("A")) {
            matrix = fillMatrixTypeA(size);
        } else {
            matrix = fillMatrixTypeB(size);
        }

        printIntegerMatrix(matrix);
    }

    private static void printIntegerMatrix(int[][] matrixOutput) {
        for (int[] innerMatrix : matrixOutput) {
            for (int matrix : innerMatrix) {
                System.out.print(matrix + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixTypeB(int size) {
        int[][] matrix = new int[size][size];
        int startNum = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int r = 0; r < size; r++) {
                    matrix[r][col] = startNum;
                    startNum++;
                }
            }else{
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNum;
                    startNum++;
                }
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixTypeA(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][c] = value;
                value++;
            }
        }
        return matrix;
    }
}
