import java.util.Arrays;
import java.util.Scanner;

public class Lab_Task_2_PositionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] parametersOfArrays = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = parametersOfArrays[0];
        int cols = parametersOfArrays[1];

        int[][] matrix = new int[rows][];
        for (int i = 0; i <rows ; i++) {
            int[] innerArray = Arrays.stream(scan.nextLine().split("\\s"))
                    .limit(cols).mapToInt(Integer::parseInt).toArray();
            matrix[i] = innerArray;
        }

        int seekNumber = Integer.parseInt(scan.nextLine());

        StringBuilder result = new StringBuilder();

        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                if(matrix[row][col] == seekNumber){
                    result.append(row).append(" ").append(col).append(System.lineSeparator());
                }
            }
        }

        if(result.length() > 0){
            System.out.println(result);
        }else{
            System.out.println("not found");
        }
    }
}
