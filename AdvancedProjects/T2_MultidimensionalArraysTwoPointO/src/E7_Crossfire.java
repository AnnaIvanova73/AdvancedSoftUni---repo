import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E7_Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        List<List<Integer>> matrixField = generateMatrix(rows, cols);
        String input = "";
        while (!"Nuke it from orbit".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s+");

            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            destructElementsFromMatrix(matrixField,row,col,radius);

            for (int r = 0; r < matrixField.size(); r++) {
                matrixField.get(r).removeAll(new ArrayList<Integer>(){{add(0);}});

                if(matrixField.get(r).size() == 0){
                    matrixField.remove(r);
                    r--;
                }
            }
        }

        printMatrix(matrixField);
    }
    private static void printMatrix(List<List<Integer>> matrix) {
        StringBuilder result = new StringBuilder();
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                result.append(integer).append(" ");
            }
            String trim = result.toString().trim();
            result.setLength(0);
            result.append(trim).append(System.lineSeparator());
        }
        System.out.println(result);
    }
    private static void destructElementsFromMatrix(List<List<Integer>> matrixField, int row, int col, int radius) {
        int begin = row -radius;
        int end = row + radius;
        for (int r = begin; r <= end; r++) {
            if(checkIsInBounds(matrixField, r, col)){
                matrixField.get(r).set(col,0);
            }
        }
        begin = col-radius;
        end = col + radius;
        for (int c = begin; c <= end ; c++) {
            if(checkIsInBounds(matrixField,row,c)){
                matrixField.get(row).set(c,0);
            }
        }
    }

    private static boolean checkIsInBounds(List<List<Integer>> matrixField, int row, int col) {
        return row >= 0 && row < matrixField.size() && col >= 0 && col < matrixField.get(row).size();
    }

    private static List<List<Integer>> generateMatrix(int rows, int cols) {
        int startNumMatrix = 0;
        List<List<Integer>> matrix = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            matrix.add(rowIndex, new ArrayList<>());
            for (int columns = 0; columns < cols; columns++) {
                ++startNumMatrix;
                matrix.get(rowIndex).add(startNumMatrix);
            }
        }
        return matrix;
    }
}

