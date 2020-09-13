import java.util.Scanner;

public class Exercise_Task_5_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt();
        int col = scan.nextInt();
        scan.nextLine();

        String[][] matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            String[] data = scan.nextLine().split("\\s+");
            matrix[i] = data;
        }

        String input = "";
        while (!"END".equals(input = scan.nextLine())) {
            String invalidOutput = "Invalid input!";
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (!"swap".equals(command) || tokens.length != 5) {
                System.out.println(invalidOutput);
                continue;
            }
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);


            if (!isValidIndex(row1, col1, matrix) || !isValidIndex(row2, col2, matrix)) {
                System.out.println(invalidOutput);

            } else {
                String swap = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = swap;
                printMatrix(matrix);
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col < matrix[row].length && col >= 0;

    }

}
