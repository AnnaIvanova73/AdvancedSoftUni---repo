import java.util.Scanner;
// 0,58 най - бързо
public class L6_PrintDiagonalsOfSquareMatrix_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner, n);

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int num = n - 1 - i;
            System.out.print(matrix[n - 1 - i][i] + " "); // за положителен цикъл
            //squareMatrix[squareMatrix.length - 1 - decreasingCounter][decreasingCounter] // същото е
        }
    }

    private static int[][] readMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];
        String[] split;
        for (int i = 0; i < n; i++) {
            split = scanner.nextLine().split("\\s+");
            for (int j = 0; j < split.length; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
        return matrix;
    }
}

