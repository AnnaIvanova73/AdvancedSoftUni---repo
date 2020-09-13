import java.util.*;

public class T1_L5_FindAllPathsInALabyrinth {
    private static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().toCharArray();
        }


        fintAndPrintPaths(matrix, 0, 0, " ");
    }

    private static void fintAndPrintPaths(char[][] matrix, int row, int col, String direction) {
        if (!isBounds(row, col, matrix)) {
            return;
        }
        path.add(direction);


        if (matrix[row][col] == 'e') {
            printPath();
        }else if(!isVisited(row,col,matrix) && isItFree(row,col,matrix)){
            markOrUnmark(matrix, row, col, "mark");
            fintAndPrintPaths(matrix, row, col + 1, "R");
            fintAndPrintPaths(matrix, row + 1, col, "D");
            fintAndPrintPaths(matrix, row - 1, col, "U");
            fintAndPrintPaths(matrix, row, col - 1, "L");

            markOrUnmark(matrix, row, col, "unmark");
        }
        path.remove(path.size() - 1);
    }

    private static void printPath() {
        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }
    private static boolean isVisited (int row, int col, char[][] matrix){
        String result = String.valueOf(matrix[row][col]);
        return result.equals("V");
    }
    private static boolean isItFree(int row,int col,char [][] matrix){
      String result = String.valueOf(matrix[row][col]);
      return result.equals("-");
    }
    private static void markOrUnmark(char[][] matrix, int row, int col, String string) {
        if (string.equals("mark")) {
            matrix[row][col] = '*';
        } else {
            matrix[row][col] = '-';
        }
    }
    private static boolean isBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col < matrix[row].length && col >= 0;
    }
}
