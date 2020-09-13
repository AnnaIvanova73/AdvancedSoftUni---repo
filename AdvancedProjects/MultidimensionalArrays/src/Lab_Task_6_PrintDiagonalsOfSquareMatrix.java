import java.util.Arrays;
import java.util.Scanner;
//0.062s
public class Lab_Task_6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensionsSquare = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[dimensionsSquare][dimensionsSquare];

        for (int i = 0; i <matrix.length; i++) {
            int[] innerArray = Arrays.stream(scan.nextLine().split("\\s+")).limit(dimensionsSquare)
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = innerArray;
        }
        StringBuilder diagonals = new StringBuilder();
        for (int i = 0; i < dimensionsSquare; i++) {
            int current = matrix[i][i];
            diagonals.append(current).append(" ");
        }
        diagonals.append(System.lineSeparator());

        int counter = 0;
        for (int i = dimensionsSquare - 1; i >= 0 ; i--) {
            int current = matrix[i][counter];
            diagonals.append(current).append(" ");
            counter++;
        }

        System.out.println(diagonals.toString());
    }
}
