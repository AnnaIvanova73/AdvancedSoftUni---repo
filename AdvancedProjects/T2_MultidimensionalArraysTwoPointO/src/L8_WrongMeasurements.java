import java.util.Arrays;
import java.util.Scanner;

public class L8_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[rows][];
        //int[][] outputMatrix = new int[rows][]; двете матрици се променят заедно, като се опитам да сменя стойността на едната
        for (int row = 0; row < matrix.length; row++) {
            int[] innerArr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = innerArr;
            // outputMatrix[row] = innerArr;
        }

        int wrongNum = matrix[scan.nextInt()][scan.nextInt()];


        StringBuilder output = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int number = matrix[row][col];
                if (!isWrongNum(number, wrongNum)) {
                    int replacement = replaceNum(row, col, matrix, wrongNum); //без проверка, ако е различно от нула,
                    // защото ако е обградено с четворки се занулява
                    output.append(replacement).append(" ");
                } else {
                    output.append(number).append(" ");
                }
            }
            output.append("\r\n");
        }
            System.out.println(output.toString());
    }

    private static int replaceNum(int row, int col, int[][] matrix, int wrongNum) {
        int number = 0;

        int tempNum = row - 1;
        if (tempNum >= 0 && isWrongNum(matrix[tempNum][col], wrongNum)) {
            number += matrix[row - 1][col];
        }
        tempNum = row + 1;
        if (tempNum < matrix.length && isWrongNum(matrix[tempNum][col], wrongNum)) {
            number += matrix[row + 1][col];
        }

        tempNum = col + 1;
        if (tempNum < matrix[row].length && isWrongNum(matrix[row][tempNum], wrongNum)) {
            number += matrix[row][col + 1];
        }
        tempNum = col - 1;
        if (tempNum >= 0 && isWrongNum(matrix[row][tempNum], wrongNum)) {
            number += matrix[row][col - 1];
        }

        return number;
    }

    private static boolean isWrongNum(int number, int wrongNum) {
        return number != wrongNum;
    }

}
