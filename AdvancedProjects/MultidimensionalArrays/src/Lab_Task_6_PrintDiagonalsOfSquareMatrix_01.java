import java.util.Arrays;
import java.util.Scanner;
//0/080s
public class Lab_Task_6_PrintDiagonalsOfSquareMatrix_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimensionsSquare = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[dimensionsSquare][dimensionsSquare];

        for (int i = 0; i < matrix.length; i++) {
            int[] innerArray = Arrays.stream(scan.nextLine().split("\\s+")).limit(dimensionsSquare)
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = innerArray;
        }

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        int row = dimensionsSquare-1;
        int coll = 0;

        while(row >= 0 && coll <= dimensionsSquare){
            int numFirst = matrix[coll][coll];
            first.append(numFirst).append(" ");

            int numSecond = matrix[row][coll];
            second.append(numSecond).append(" ");

            row--;
            coll++;
        }
        System.out.println(first.append(System.lineSeparator()).append(second).toString().trim());
    }
}
