import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_BookWorm2 {
    private static final int[] rowMovement = {-1, 1, 0, 0};
    private static final int[] colMovement = {0, 0, -1, 1};
    private static StringBuilder print;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        print = new StringBuilder();
        print.append(reader.readLine());

        int sizeOfMatrix = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        int[] playerCurrentPosition = new int[2];


        for (int row = 0; row < matrix.length; row++) {
            char[] innerArray = reader.readLine().toCharArray();
            for (int col = 0; col < innerArray.length; col++) {
                matrix[row][col] = innerArray[col];
                if (innerArray[col] == 'P') {
                    playerCurrentPosition[0] = row;
                    playerCurrentPosition[1] = col;
                }
            }
        }

        String line;
        int moveToRow;
        int moveToCol;
        while (!(line = reader.readLine()).equals("end")) {
            String command = line;

            switch (command) {

                case "up":
                    moveToRow = playerCurrentPosition[0] + rowMovement[0];
                    moveToCol = playerCurrentPosition[1] + colMovement[0];
                    movePlayer(playerCurrentPosition, matrix,moveToRow,moveToCol);
                    break;
                case "down":
                    moveToRow = playerCurrentPosition[0] + rowMovement[1];
                    moveToCol = playerCurrentPosition[1] + colMovement[1];
                    movePlayer(playerCurrentPosition, matrix,moveToRow,moveToCol);
                    break;
                case "left":
                    moveToRow = playerCurrentPosition[0] + rowMovement[2];
                    moveToCol = playerCurrentPosition[1] + colMovement[2];
                    movePlayer(playerCurrentPosition, matrix,moveToRow,moveToCol);
                    break;
                case "right":
                    moveToRow = playerCurrentPosition[0] + rowMovement[3];
                    moveToCol = playerCurrentPosition[1] + colMovement[3];
                    movePlayer(playerCurrentPosition, matrix,moveToRow,moveToCol);
                    break;


            }
        }

        System.out.println(print.toString());

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

    private static void movePlayer(int[] playerCurrentPosition, char[][] matrix, int moveToRow, int moveToCol) {
        boolean hasToDoSomething = canMoveOrPutRestriction (moveToRow,moveToCol,matrix);

        if(!hasToDoSomething){
            return;
        }

        matrix[playerCurrentPosition[0]][playerCurrentPosition[1]] = '-';
        if(matrix[moveToRow][moveToCol] != '-'){
            print.append(matrix[moveToRow][moveToCol]);
        }

        matrix[moveToRow][moveToCol] = 'P';
        playerCurrentPosition[0] = moveToRow;
        playerCurrentPosition[1] = moveToCol;
    }

    private static boolean canMoveOrPutRestriction(int moveToRow, int moveToCol, char[][] matrix) {
        if(moveToRow >= 0 && moveToRow < matrix.length && moveToCol >= 0 && moveToCol < matrix[moveToRow].length){
            return true;
        }else{
            if(print.length() > 0){
                print.deleteCharAt(print.length() -1);
            }
            return false;
        }
    }
}
