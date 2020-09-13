import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int[] arr = readIntArray(input);

        int rows = arr[0];
        int cols = arr[1];

        List<List<Integer>> matrix = new ArrayList<>();
        readIntListArray(matrix, rows, cols);
        printIntListMatrix(matrix);
        String line;
        while (!(line = reader.readLine()).equals("Nuke it from orbit")) {
            int[] tokens = readIntArray(line);
            int currentRow = tokens[0];
            int currentCol = tokens[1];
            int radius = tokens[3];


        }


    }

    private static void readIntListArray(List<List<Integer>> matrix, int rows, int cols) {
        int counter = 0 ;
        for (int row = 0; row < rows; row++) {
            matrix.add(row, new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                counter++;
                matrix.get(row).add(counter);
            }
        }
    }

    private static int[] readIntArray(String input) throws IOException {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }


    private static void printIntListMatrix (List<List<Integer>> matrix){
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateIntMatrix(BufferedReader reader, int rows, int cols) {
        int[][] temp = new int[rows][cols];
        int counter = 0;
        for (int row = 0; row < temp.length; row++) {
            for (int col = 0; col < temp[row].length; col++) {
                counter++;
                temp[row][col] = counter;
            }
        }
        return temp;
    }

    private static void printIntMatrix(int[][] matrix) {
        StringBuilder perPrint = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                perPrint.append(matrix[row][col]).append(" ");
            }
            String trim = perPrint.toString().trim();
            perPrint.setLength(0);
            perPrint.append(trim).append(System.lineSeparator());
        }
        System.out.println(perPrint.toString());

    }
}
