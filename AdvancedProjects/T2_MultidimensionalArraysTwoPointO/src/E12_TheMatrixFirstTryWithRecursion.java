import java.util.Arrays;
import java.util.Scanner;
//66 от 100
public class E12_TheMatrixFirstTryWithRecursion {
    //Flood fill Algorithm
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        String[][] theMatrix = new String[rows][cols];

        for (int row = 0; row < theMatrix.length; row++) {
            String[] innerArray = scan.nextLine().split("\\s+");
            theMatrix[row] = innerArray;
        }

        String fillChar = scan.nextLine();

        int startRow = scan.nextInt();
        int endRow = scan.nextInt();
        scan.nextLine();

        floodFill(theMatrix, startRow, endRow, fillChar);
        printMatrix(theMatrix);
    }

    private static void printMatrix(String[][] theMatrix) {
        for (String[] matrix : theMatrix) {
            for (String s : matrix) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    private static void foolFillAndCheckBoud(String[][] theMatrix, int startRow, int endRow, String fillChar, String oldColor) {
        if (startRow < 0 || startRow >= theMatrix.length || endRow < 0 || endRow >= theMatrix[startRow].length) {
            return;
        }
        if (!theMatrix[startRow][endRow].equals(oldColor)) {
            return;
        }

        theMatrix[startRow][endRow] = fillChar;
        foolFillAndCheckBoud(theMatrix, startRow + 1, endRow, fillChar, oldColor);
        foolFillAndCheckBoud(theMatrix, startRow - 1, endRow, fillChar, oldColor);
        foolFillAndCheckBoud(theMatrix, startRow, endRow + 1, fillChar, oldColor);
        foolFillAndCheckBoud(theMatrix, startRow, endRow + 1, fillChar, oldColor);

    }

    private static void floodFill(String[][] theMatrix, int startRow, int endRow, String fillChar) {
        String oldColor = theMatrix[startRow][endRow];
        foolFillAndCheckBoud(theMatrix, startRow, endRow, fillChar, oldColor);
    }


}
