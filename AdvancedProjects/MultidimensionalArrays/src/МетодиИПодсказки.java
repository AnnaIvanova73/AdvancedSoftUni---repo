import java.util.Arrays;
import java.util.Scanner;

public class МетодиИПодсказки {
    private static final int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static final int[] rowMovement = {1, -1, 0, 0};
    private static final int[] colMovement = {0, 0, 1, -1};


    // от текущата позиция
    // upLeft ---> row-1 and col-1;
    // up ---> row -1 and col=0;
    // upRight ---> row-1 and coll+1 ;
    // left --> row 0 col -1 ;
    // right --> row 0 col + 1
    // downLeft ---> row + 1 and col -1
    // down ---> row+1 and col = 0;
    // downRight = row +1 and col +1;


    //  matrixField.get(r).removeAll(new ArrayList<Integer>(){{add(0);}});

    //За вървене по диагонали
    //  for (int k = 0; k < row.length; k++) {
    //                if (isSafe(matrix, lengthRow, lengthCol, startRow + row[k], startCol + col[k], target)) {
    //                    queue.offer(startRow + row[k]);
    //                    queue.offer(startCol + col[k]);
    //                }
    //            }
    //        }
    //    }


    //    public static boolean isSafe(char[][] matrix, m, int n,
    //                                 int x, int y, char target) {
    //        return x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == target;
    //    }


    public static boolean isInBound (int[][]matrix,int row,int col){
        return row >= 0 && row < matrix.length && col >=0 && col<matrix[row].length;
    }

    private static int[][] readIntMatrix(Scanner scan, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] array = readIntArray(scan, pattern);
            matrix[row] = array;
        }

        return matrix;
    }

    private static int[] readIntArray(Scanner scan, String pattern) {
        return Arrays.stream(scan.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }

    private static void printCharMatrix(char[][] finalMatrix) {
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static char[][] readCharMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] lineOfChars = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = lineOfChars[col].charAt(0);
            }
        }
        return matrix;
    }

    private static char[][] readCharMatrixSecond(Scanner scan, int rows, int cols) {
        char[][] matrix = new char[rows][];
        for (int i = 0; i < matrix.length; i++) {
            String input = scan.nextLine().replace(" ", "");
            input = input.substring(0, cols);
            char[] innerMatrix = input.toCharArray();
            matrix[i] = innerMatrix;
        }
        return matrix;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

    }

    private static void printStringMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
