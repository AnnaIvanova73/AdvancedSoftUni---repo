import java.util.Scanner;

public class L7_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = 8;
        int[][] chessboard = new int[dimensions][dimensions];

        for (int row = 0; row < dimensions; row++) {
            String[] innerArr = scan.nextLine().split("\\s+");
            for (int col = 0; col < dimensions; col++) {
                int elements = innerArr[col].charAt(0);
                chessboard[row][col] = elements;
            }
        }

        int queen = 113;

        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                int element = chessboard[row][col];
                if (hasMatch(queen, element)) {
                    boolean isQueenValid = isElementUnique(queen, row, col, chessboard);

                    if (isQueenValid) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isElementUnique(int queen, int row, int col, int[][] chessboard) {
        int foundOtherQueens = 0;

        for (int c = col - 1; c >= 0; c--) {
            foundOtherQueens += getFoundOtherQueens(queen, row, chessboard, foundOtherQueens, c);
        }

        for (int c = col + 1; c < chessboard.length; c++) {
            foundOtherQueens += getFoundOtherQueens(queen, row, chessboard, foundOtherQueens, c);
        }

        for (int r = row + 1; r < chessboard.length; r++) {
            foundOtherQueens += getFoundOtherQueens(queen, r, chessboard, foundOtherQueens, col);
        }

        for (int r = row - 1; r >= 0; r--) {
            foundOtherQueens += getFoundOtherQueens(queen, r, chessboard, foundOtherQueens, col);
        }

        int countRow = row - 1;
        int countCol = col - 1;
        while (countRow >= 0 && countCol >= 0) {
            foundOtherQueens += getFoundOtherQueens(queen, countRow, chessboard, foundOtherQueens, countCol);
            countRow--;
            countCol--;
        }

        countRow = row + 1;
        countCol = col + 1;
        while (countRow < chessboard.length && countCol < chessboard.length) {
            foundOtherQueens += getFoundOtherQueens(queen, countRow, chessboard, foundOtherQueens, countCol);
            countRow++;
            countCol++;
        }

        countRow = row + 1;
        countCol = col - 1;
        while (countRow < chessboard.length && countCol >= 0) {
            foundOtherQueens += getFoundOtherQueens(queen, countRow, chessboard, foundOtherQueens, countCol);
            countRow++;
            countCol--;
        }

        countRow = row - 1;
        countCol = col + 1;
        while (countRow >= 0 && countCol < chessboard.length) {
            foundOtherQueens += getFoundOtherQueens(queen, countRow, chessboard, foundOtherQueens, countCol);
            countRow--;
            countCol++;
        }

        return foundOtherQueens <= 0;
    }

    private static int getFoundOtherQueens(int queen, int row, int[][] chessboard, int foundOtherQueens, int col) {
        if (hasMatch(queen, chessboard[row][col])) {
            foundOtherQueens++;
        }
        return foundOtherQueens;
    }

    private static boolean hasMatch(int queen, int element) {
        return queen == element;
    }
}
