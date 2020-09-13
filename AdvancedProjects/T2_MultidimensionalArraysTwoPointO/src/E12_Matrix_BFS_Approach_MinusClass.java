import java.util.ArrayDeque;
import java.util.Scanner;
public class E12_Matrix_BFS_Approach_MinusClass {
    //BFS 100 ot 100
    private static final int[] row = {-1, 0, 0, 1};
    private static final int[] col = {0, -1, 1, 0};

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

    private static void printCharMatrix(char[][] finalMatrix) {
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void floodFill(char[][] matrix, int startRow, int startCol, char replacement) {
        int lengthRow = matrix.length;
        int lengthCol = matrix[startRow].length;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(startRow);
        queue.offer(startCol);

        char target = matrix[startRow][startCol];

        while (!queue.isEmpty()) {
            startRow = queue.poll();
            startCol = queue.poll();

            matrix[startRow][startCol] = replacement;

            for (int k = 0; k < row.length; k++) {
                if (isSafe(matrix, lengthRow, lengthCol, startRow + row[k], startCol + col[k], target)) {
                    queue.offer(startRow + row[k]);
                    queue.offer(startCol + col[k]);
                }
            }
        }
    }
    public static boolean isSafe(char[][] M, int m, int n,
                                 int x, int y, char target) {
        return x >= 0 && x < m && y >= 0 && y < n && M[x][y] == target;
    }
}

