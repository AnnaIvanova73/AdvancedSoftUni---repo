import java.util.Arrays;
import java.util.Scanner;

public class L4_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String pattern = ", ";
        int[] dimension = readArray(scan,pattern);
        int rows = dimension[0];
        int cols = dimension[1];

        StringBuilder output = new StringBuilder();
        output.append(rows).append("\r\n").append(cols).append("\r\n");
        
        
        int[][] matrix = readMatrix(scan,rows,cols,pattern);
        int sumOfElements = 0;

        for (int[] innerArr : matrix) {
            for (int element : innerArr) {
                sumOfElements += element;
            }
        }
        output.append(sumOfElements);

        System.out.println(output.toString());

    }

    private static int[][] readMatrix(Scanner scan, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] array = readArray(scan, pattern);
            matrix[row] = array;
        }

        return matrix;
    }

    private static int[] readArray(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
