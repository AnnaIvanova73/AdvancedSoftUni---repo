import java.util.Scanner;

public class Exercise_Task_2_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String[][] matrix = new String[rows][cols];
        char rowsLetter = 97;

        for (int r = 0; r < matrix.length; r++) {
            char incCols = rowsLetter;

            for (int c = 0; c < cols; c++) {
                StringBuilder result = new StringBuilder(3);
                result.append(rowsLetter).append(incCols);
                incCols += 1;
                result.append(rowsLetter);
                matrix[r][c] = result.toString();
            }
            rowsLetter++;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
