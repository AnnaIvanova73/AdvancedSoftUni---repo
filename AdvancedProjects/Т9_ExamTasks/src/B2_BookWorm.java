import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_BookWorm {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder msg = new StringBuilder();
        msg.append(reader.readLine());

        int sizeOfMatrix = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        int rowP = 0;
        int colP = 0;


        for (int row = 0; row < matrix.length; row++) {
            String inner =  reader.readLine();
            for (int col = 0; col < inner.length(); col++) {
                matrix[row][col] = inner.charAt(col);
                if (inner.charAt(col) == 'P') {
                    rowP = row;
                    colP = col;
                }
            }
        }

        String line;
        while (!(line = reader.readLine()).equals("end")) {
            int moveToRow = rowP;
            int moveToCol = colP;
            switch (line) {
                case "up":
                    moveToRow--;
                    break;
                case "down":
                    moveToRow++;
                    break;
                case "left":
                    moveToCol--;
                    break;
                case "right":
                    moveToCol++;
                    break;


            }

            if (moveToRow >= 0 && moveToRow < matrix.length && moveToCol >= 0 && moveToCol < matrix[rowP].length) {
                 matrix[rowP][colP] = '-';
                if (matrix[moveToRow][moveToCol] != '-') {
                    msg.append(matrix[moveToRow][moveToCol]);
                }

                matrix[moveToRow][moveToCol] = 'P';
                rowP = moveToRow;
                colP = moveToCol;

            } else {
                if (msg.length() > 0) {
                    msg.deleteCharAt(msg.length() - 1);
                }
            }
        }

        System.out.println(msg.toString());
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
}
