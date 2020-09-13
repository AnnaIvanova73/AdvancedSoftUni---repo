import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C2_TheGarden {

    private static int harmed = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countRows = Integer.parseInt(reader.readLine());

        char[][] garden = new char[countRows][];

        for (int row = 0; row < garden.length; row++) {
            String line = reader.readLine().replaceAll("\\s+", "");
            garden[row] = line.toCharArray();
        }

        Map<Character, Integer> vegetable = new HashMap<>();
        vegetable.put('L', 0);
        vegetable.put('P', 0);
        vegetable.put('C', 0);

        String line;
        while (!(line = reader.readLine()).equals("End of Harvest")) {
            String[] tokens = line.split("\\s+");

            int rowToMove = Integer.parseInt(tokens[1]);
            int colToMove = Integer.parseInt(tokens[2]);

            if (tokens[0].equals("Harvest")) {
                if (isSafe(rowToMove, colToMove, garden) && garden[rowToMove][colToMove] != ' ') {

                    int count = vegetable.get(garden[rowToMove][colToMove]);
                    count += 1;

                    vegetable.put(garden[rowToMove][colToMove], count);
                    garden[rowToMove][colToMove] = ' ';
                }
            } else {

                if (isSafe(rowToMove, colToMove, garden)) {
                    moleInAction(rowToMove, colToMove, tokens[3], garden);
                }

            }
        }

        printCharMatrix(garden);

        System.out.print("Carrots: ");
        vegetable.entrySet().stream().filter(v -> v.getKey() == 'C').forEach(c -> System.out.println(c.getValue()));


        System.out.print("Potatoes: ");
        vegetable.entrySet().stream().filter(v -> v.getKey() == 'P').forEach(c -> System.out.println(c.getValue()));


        System.out.print("Lettuce: ");
        vegetable.entrySet().stream().filter(v -> v.getKey() == 'L').forEach(c -> System.out.println(c.getValue()));


        System.out.println("Harmed vegetables: " + harmed);

    }

    private static void moleInAction(int rowToMove, int colToMove, String direction, char[][] garden) {

        int count;
        switch (direction) {

            case "up":

                count = 0;
                while (rowToMove >= 0) {

                    moleHasLunch(rowToMove, colToMove, garden, count);

                    count++;
                    rowToMove--;
                }
                break;
            case "down":
                count = 0;
                while (rowToMove < garden.length) {

                    moleHasLunch(rowToMove, colToMove, garden, count);

                    count++;
                    rowToMove++;
                }
                break;
            case "left":
                count = 0;
                while (colToMove >= 0) {

                    moleHasLunch(rowToMove, colToMove, garden, count);

                    count++;
                    colToMove--;
                }

                break;
            case "right":
                count = 0;
                while (colToMove < garden[rowToMove].length) {

                    moleHasLunch(rowToMove, colToMove, garden, count);

                    count++;
                    colToMove++;
                }

                break;
        }
    }

    private static void moleHasLunch(int rowToMove, int colToMove, char[][] garden, int count) {
        if (count % 2 == 0 && garden[rowToMove][colToMove] != ' ') {
            garden[rowToMove][colToMove] = ' ';
            harmed += 1;
        }
    }

    private static boolean isSafe(int rowToMove, int colToMove, char[][] matrix) {
        return rowToMove >= 0 && rowToMove < matrix.length && colToMove >= 0 && colToMove < matrix[rowToMove].length;
    }

    private static void printCharMatrix(char[][] finalMatrix) {
        StringBuilder print = new StringBuilder();
        for (char[] matrix : finalMatrix) {
            for (char symbol : matrix) {
                print.append(symbol).append(" ");
            }
            String trim = print.toString().trim();
            print.setLength(0);
            print.append(trim).append(System.lineSeparator());
        }

        System.out.print(print.toString());
    }
}
