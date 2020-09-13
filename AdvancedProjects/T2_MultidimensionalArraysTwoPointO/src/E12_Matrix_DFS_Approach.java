import java.util.Scanner;
// 100 от 100 DFS
public class E12_Matrix_DFS_Approach {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] lineOfChars = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = lineOfChars[col].charAt(0);
            }
        }

        char replacement = scan.nextLine().charAt(0);

        int startRow = scan.nextInt();
        int startCol = scan.nextInt();

        floodFill(matrix, startRow, startCol, replacement);
        printCharMatrix(matrix);
    }

    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};

    public static boolean isSafe(char[][] matrix, int startRow, int startCol) {
        return startRow >= 0 && startRow < matrix.length && startCol >= 0 && startCol < matrix[startRow].length;
    }

    public static boolean isItTarget(char[][] matrix, int row, int col, char target) {
        char s = matrix[row][col];
        return matrix[row][col] == target;
    }

    // Flood fill using DFS
    public static void floodFill(char[][] matrix, int x, int y, char replacement) {
        char target = matrix[x][y];

        matrix[x][y] = replacement;

        for (int k = 0; k < row.length; k++) {
            int a = x + row[k];
            int b = y + col[k];

            if (isSafe(matrix, x + row[k], y + col[k])) {
                if (isItTarget(matrix, x + row[k], y + col[k], target)) {
                    floodFill(matrix, x + row[k], y + col[k], replacement);
                }
            }
        }
    }

    private static void printCharMatrix(char[][] finalMatrix) {
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
