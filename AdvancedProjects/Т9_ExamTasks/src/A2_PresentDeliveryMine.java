import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2_PresentDeliveryMine {
    private static final int[] rowMovement = {1, -1, 0, 0};
    private static final int[] colMovement = {0, 0, 1, -1};
    private static int[] santaIsReal = new int[2];
    private static int presentsInAction = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfPresents = Integer.parseInt(reader.readLine());
        int matrixSize = Integer.parseInt(reader.readLine());

        char[][] neighbourhood = new char[matrixSize][matrixSize];
        int totalGoodKids = 0;

        for (int row = 0; row < neighbourhood.length; row++) {
            String lineOfChars = reader.readLine().replaceAll("\\s+", "");
            char[] innerArray = lineOfChars.toCharArray();
            for (int col = 0; col < innerArray.length; col++) {

                neighbourhood[row][col] = innerArray[col];

                if (neighbourhood[row][col] == 'V') {
                    totalGoodKids++;
                }
                if (neighbourhood[row][col] == 'S') {
                    santaIsReal[0] = row;
                    santaIsReal[1] = col;
                }
            }
        }
        //presentsInAction-- > 0

        presentsInAction = countOfPresents;

        boolean isSantaDone = false;
        String line;
        while (!(line = reader.readLine()).equals("Christmas morning")) {

            int row;
            int col;
            switch (line) {
                case "up": {
                    row = rowMovement[1];
                    col = colMovement[1];
                    isSantaDone = isSantaIn(neighbourhood, row + +santaIsReal[0], col + +santaIsReal[1]);
                    if (!isSantaDone) {
                        continue;
                    }
                    moveSantaUp(neighbourhood, row, col);
                    break;
                }
                case "down": {
                    row = rowMovement[0];
                    col = colMovement[0];
                    isSantaDone = isSantaIn(neighbourhood, row + +santaIsReal[0], col + +santaIsReal[1]);
                    if (!isSantaDone) {
                        continue;
                    }
                    moveSantaUp(neighbourhood, row, col);
                    break;
                }
                case "left":
                    //-1 4
                    row = rowMovement[3];
                    col = colMovement[3];
                    isSantaDone = isSantaIn(neighbourhood, row + +santaIsReal[0], col + +santaIsReal[1]);
                    if (!isSantaDone) {
                        continue;
                    }
                    moveSantaUp(neighbourhood, row, col);
                    break;
                case "right":
                    row = rowMovement[2];
                    col = colMovement[2];
                    isSantaDone = isSantaIn(neighbourhood, row + +santaIsReal[0], col + +santaIsReal[1]);
                    if (!isSantaDone) {
                        continue;
                    }
                    moveSantaUp(neighbourhood, row, col);
                    break;
            }
            if (presentsInAction == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }

        }


        int kids = printCharMatrixAndReturnKids(neighbourhood);

        if (kids == 0) {
            System.out.println("Good job, Santa! " + totalGoodKids + " happy nice kid/s.");
        }else{
            System.out.println(String.format("No presents for %d nice kid/s.",kids));
        }
    }

    private static void moveSantaUp(char[][] neighbourhood, int row, int col) {
        row = row + santaIsReal[0];
        col = col + santaIsReal[1];
        String goesToHouse = String.valueOf(neighbourhood[row][col]);
        switch (goesToHouse) {
            case "V":

                presentsInAction--;
                neighbourhood[santaIsReal[0]][santaIsReal[1]] = '-';
                neighbourhood[row][col] = 'S';
                santaIsReal[0] = row;
                santaIsReal[1] = col;
                break;
            case "X":

                neighbourhood[santaIsReal[0]][santaIsReal[1]] = '-';
                neighbourhood[row][col] = 'S';
                santaIsReal[0] = row;
                santaIsReal[1] = col;

                break;
            case "C":
                neighbourhood[santaIsReal[0]][santaIsReal[1]] = '-';
                neighbourhood[row][col] = 'S';
                santaIsReal[0] = row;
                santaIsReal[1] = col;

                char up = neighbourhood[santaIsReal[0] + rowMovement[1]][santaIsReal[1] + colMovement[1]];
                if (up == 'X' || up == 'V') {
                    presentsInAction--;
                    neighbourhood[santaIsReal[0] + rowMovement[1]][santaIsReal[1] + colMovement[1]] = '-';
                    if (presentsInAction == 0) {
                        return;
                    }
                }
                char down = neighbourhood[santaIsReal[0] + rowMovement[0]][santaIsReal[1] + colMovement[0]];
                if (down == 'X' || down == 'V') {
                    presentsInAction--;
                    neighbourhood[santaIsReal[0] + rowMovement[0]][santaIsReal[1] + colMovement[0]] = '-';
                    if (presentsInAction == 0) {
                        return;
                    }
                }
                char left = neighbourhood[santaIsReal[0] + rowMovement[3]][santaIsReal[1] + colMovement[3]];
                if (left == 'X' || left == 'V') {
                    presentsInAction--;
                    neighbourhood[santaIsReal[0] + rowMovement[3]][santaIsReal[1] + colMovement[3]] = '-';
                    if (presentsInAction == 0) {
                        return;
                    }
                }

                char right = neighbourhood[santaIsReal[0] + rowMovement[2]][santaIsReal[1] + colMovement[2]];
                if (right == 'X' || left == 'V') {
                    presentsInAction--;
                    neighbourhood[santaIsReal[0] + rowMovement[2]][santaIsReal[1] + colMovement[2]] = '-';
                    if (presentsInAction == 0) {
                        return;
                    }
                }
                break;
            default:
                neighbourhood[santaIsReal[0]][santaIsReal[1]] = '-';
                neighbourhood[row][col] = 'S';
                santaIsReal[0] = row;
                santaIsReal[1] = col;
                break;
        }

    }

    private static boolean isSantaIn(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int printCharMatrixAndReturnKids(char[][] finalMatrix) {
        int temp = 0;
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                if (symbol == 'V') {
                    temp++;
                }
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        return temp;
    }

}
