import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_ReVolt {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sizeSquare = Integer.parseInt(reader.readLine());

        int commandsCount = Integer.parseInt(reader.readLine());

        int[] playerPosition = new int[2];

        char[][] matrix = new char[sizeSquare][sizeSquare];

        for (int row = 0; row < matrix.length; row++) {
            String lineOfChars = reader.readLine().replaceAll("\\s+", "");
            char[] innerArray = lineOfChars.toCharArray();
            for (int col = 0; col < innerArray.length; col++) {
                matrix[row][col] = innerArray[col];
                if (matrix[row][col] == 'f') {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                }
            }
        }

        matrix[playerPosition[0]][playerPosition[1]] = '-';

        char contents = ' ';
        String command = " ";
        while (commandsCount-- > 0) {

            if (contents != 'B') {
                command = reader.readLine();
            }

            int moveToRow = playerPosition[0];
            int moveToCol = playerPosition[1];


            switch (command) {
                case "up":
                    moveToRow--;
                    if (isNotSafeMove(matrix, moveToRow, moveToCol)) {
                        moveToRow = matrix.length - 1;
                    }

                    break;
                case "down":
                    moveToRow++;
                    if (isNotSafeMove(matrix, moveToRow, moveToCol)) {
                        moveToRow = 0;
                    }

                    break;
                case "left":
                    moveToCol--;
                    if (isNotSafeMove(matrix, moveToRow, moveToCol)) {
                        moveToCol = matrix.length - 1;
                    }
                    break;
                case "right":
                    moveToCol++;
                    if (isNotSafeMove(matrix, moveToRow, moveToCol)) {
                        moveToCol = 0;
                    }
                    break;
            }

            contents = matrix[moveToRow][moveToCol];

            if (matrix[moveToRow][moveToCol] == 'T') {
                continue;
            }

            playerPosition[0] = moveToRow;
            playerPosition[1] = moveToCol;

            if (contents == 'F') {
                matrix[playerPosition[0]][playerPosition[1]] = 'f';
                System.out.println("Player won!");
                printCharMatrix(matrix);
                return;
            }
            if (contents == 'B') {
                commandsCount++;
            }

        }


        matrix[playerPosition[0]][playerPosition[1]] = 'f';
        System.out.println("Player lost!");
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

    private static boolean isNotSafeMove(char[][] matrix, int moveToRow, int moveToCol) {
        return moveToRow < 0 || moveToRow >= matrix.length || moveToCol < 0 || moveToCol >= matrix[moveToRow].length;
    }
}
