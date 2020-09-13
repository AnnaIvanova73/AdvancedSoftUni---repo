import java.util.Scanner;

public class L3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = readCharMatrix(rows, cols, scan);
        char[][] secondMatrix = readCharMatrix(rows, cols, scan);

        char[][] finalMatrix = new char[rows][cols];

        for (int row = 0; row < finalMatrix.length ; row++) {
            char[] firstArr = firstMatrix[row];
            char[] secondArr = secondMatrix[row];
            for (int col = 0; col < finalMatrix[row].length; col++) {
                char symbol = firstArr[col] == secondArr[col] ? firstArr[col] : '*'; //  if/? firstArr[col] else/: '*'
                finalMatrix[row][col] = symbol;
            }
        }

            printCharMatrix (finalMatrix);

    }

    private static void printCharMatrix(char[][] finalMatrix) {
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                System.out.print(symbol + " ");
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
    // private static char[][] readAndPutInMatrix(Scanner scan, int rows, int cols) {
    //        char[][] matrix = new char[rows][];
    //        for (int i = 0; i < matrix.length; i++) {
    //            String input = scan.nextLine().replace(" ", "");
    //            input = input.substring(0, cols);
    //            char[] innerMatrix = input.toCharArray();
    //            matrix[i] = innerMatrix;
    //        }
    //        return matrix;
    //    }
}
