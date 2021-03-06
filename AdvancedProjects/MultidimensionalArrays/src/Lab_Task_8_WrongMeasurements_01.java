import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab_Task_8_WrongMeasurements_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimension = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[dimension][];
        for (int i = 0; i < dimension; i++) {
            int[] inArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = inArr;
        }

        int row = scan.nextInt();
        int col = scan.nextInt();
        int wrongNumber = matrix[row][col];

        List<Integer> values = new ArrayList<>();
        List<int[]> indexes = new ArrayList<>();


        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNum = matrix[r][c];
                if (currentNum == wrongNumber) {
                    int checkValue = checkValueAndReturnNew(r, c, matrix, wrongNumber);
                    values.add(checkValue);
                    indexes.add(new int[]{r,c});

                }
            }
        }
        for (int i = 0; i < values.size() ; i++) {
            matrix[indexes.get(i)[0]][indexes.get(i)[1]] = values.get(i);
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int checkValueAndReturnNew(int r, int c, int[][] matrix, int searchNum) {
        int newSum = 0;
        int size = matrix[r].length;
        if (isNumberValid(r - 1, c, matrix, searchNum, size)) {
            newSum += matrix[r - 1][c];
        }
        if (isNumberValid(r + 1, c, matrix, searchNum, size)) {
            newSum += matrix[r + 1][c];
        }
        if (isNumberValid(r, c - 1, matrix, searchNum, size)) {
            newSum += matrix[r][c - 1];
        }
        if (isNumberValid(r, c + 1, matrix, searchNum, size)) {
            newSum += matrix[r][c + 1];
        }

        return newSum;
    }

    private static boolean isNumberValid(int row, int col, int[][] matrix, int searchNum, int size) {

        if (row >= 0 && col >= 0 && col < size && row < matrix.length) {
            int num = matrix[row][col];
            return matrix[row][col] != searchNum;
        } else {
            return false;
        }
    }
}
