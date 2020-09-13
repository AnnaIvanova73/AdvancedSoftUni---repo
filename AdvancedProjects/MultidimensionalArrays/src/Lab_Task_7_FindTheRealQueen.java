import java.util.Scanner;

public class Lab_Task_7_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensions = 8;
        char[][] chessBoard = new char[dimensions][dimensions];

        for (int i = 0; i < dimensions; i++) {
            String input = scan.nextLine().replace(" ", "");
            char[] innerArray = input.toCharArray();
            chessBoard[i] = innerArray;
        }

        for (int row = 0; row < dimensions; row++) {
            for (int col = 0; col < dimensions; col++) {
                char symbol = chessBoard[row][col];
                if (symbol == 'q') {
                    if (!validatedRow(row, chessBoard, dimensions)) {
                        break;
                    }
                    if (!valdateCol(col, chessBoard, dimensions)) {
                        break;
                    }
                    if (!validMainUP(row, col, chessBoard)) {
                        break;
                    }
                    if (!validMainDown(row, col, chessBoard, dimensions)) {
                        break;
                    }
                    if (!validSecondUp(row, col, chessBoard, dimensions)) {
                        break;
                    }
                    if (!validSecondDown(row, col, chessBoard, dimensions)) {
                        break;
                    }
                    System.out.println(row + " " + col);
                }
            }
        }
    }

    private static boolean validSecondDown(int row, int col, char[][] chessBoard, int size) {
        row++;
        col--;
        while (row < size && col >= 0) {
            if (chessBoard[row++][col--] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static boolean validSecondUp(int row, int col, char[][] chessBoard, int size) {
        row--;
        col++;
        while ((row >= 0 && col < size)) {
            if (chessBoard[row--][col++] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static boolean validMainDown(int row, int col, char[][] chessBoard, int size) {
        row++;
        col++;
        while (row < size && col < size) {
            if (chessBoard[row++][col++] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static boolean validMainUP(int row, int col, char[][] chessBoard) {
        row--;
        col--;
        while (row >= 0 && col >= 0) {
            if (chessBoard[row--][col--] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static boolean valdateCol(int col, char[][] chessBoard, int size) {
        int countQueens = 0;
        for (int i = 0; i < size; i++) {
            char symbol = chessBoard[i][col];
            if (symbol == 'q') {
                countQueens++;
            }
        }
        return countQueens == 1;
    }

    private static boolean validatedRow(int row, char[][] chessBoard, int size) {
        int countQueens = 0;
        for (int i = 0; i < size; i++) {
            char symbol = chessBoard[row][i];
            if (symbol == 'q') {
                countQueens++;
            }
        }
        return countQueens == 1;
    }
}
