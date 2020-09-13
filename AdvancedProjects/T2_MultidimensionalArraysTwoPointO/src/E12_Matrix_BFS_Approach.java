import java.util.ArrayDeque;
import java.util.Scanner;

public class E12_Matrix_BFS_Approach {
    //BFS
    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(startRow, startCol));

        char target = matrix[startRow][startCol];

        while (!queue.isEmpty()) {

            Pair node = queue.poll();

            startRow = node.x;
            startCol = node.y;

            matrix[startRow][startCol] = replacement;

            for (int k = 0; k < row.length; k++) {
                if (isSafe(matrix, lengthRow, lengthCol, startRow + row[k], startCol + col[k], target)) {

                    queue.add(new Pair(startRow + row[k], startCol + col[k]));
                }
            }
        }
    }
    public static boolean isSafe(char[][] M, int m, int n,
                                 int x, int y, char target) {
        return x >= 0 && x < m && y >= 0 && y < n && M[x][y] == target;
    }
}

