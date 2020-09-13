import java.util.Scanner;

public class E5_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] dimensions = readArray(input);
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = readStringMatrix(rows, cols, scan);

        System.out.println(matrix.length);
        String swaps = "";
        String output = "Invalid input!";
        while (!"END".equals(swaps = scan.nextLine())) {
            String[] tokens = readArray(swaps);

            if (tokens.length != 5 || !"swap".equals(tokens[0])) {
                System.out.println(output);
                continue;
            }

            if (checkAndSwap(tokens[1], tokens[2], tokens[3], tokens[4], matrix)) {
                printChangedMatrix(matrix);
            } else {
                System.out.println(output);
            }
        }
    }

    private static void printChangedMatrix(String[][] matrix) {
        for (String[] innerArray : matrix) {
            for (String element : innerArray) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkAndSwap(String token, String token1, String token2, String token3, String[][] matrix) {
        int firstRow = Integer.parseInt(token);
        int firstCol = Integer.parseInt(token1);
        int secondRow = Integer.parseInt(token2);
        int secondCol = Integer.parseInt(token3);
        if (checkIndexBoundaries(firstRow, firstCol, matrix) && checkIndexBoundaries(secondRow, secondCol, matrix)) {
            String swap = matrix[firstRow][firstCol];
            matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
            matrix[secondRow][secondCol] = swap;
            return true;
        } else {
            return false;
        }
    }

    private static String[][] readStringMatrix(int rows, int cols, Scanner scan) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String input = scan.nextLine();
            String[] innerArray = readArray(input);
            matrix[row] = innerArray;
        }
        return matrix;
    }

    private static boolean checkIndexBoundaries(int firstRow, int firstCol, String[][] matrix) {
        return firstRow >= 0 && firstRow < matrix.length && firstCol >= 0 && firstCol < matrix[firstRow].length;
    }

    private static String[] readArray(String string) {
        return (string.split("\\s+"));
    }
}
