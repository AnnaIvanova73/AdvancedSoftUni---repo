import java.util.Arrays;
import java.util.Scanner;

public class Exercise_Task_9_ParkingSystem {
    public static int countDistance;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        boolean[][] parking = new boolean[rows][cols];
        fillParking(parking, rows, cols);
        String input = "";
        while (!"stop".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s+");
            int colEntrance = Integer.parseInt(tokens[0]);
            int rowDesire = Integer.parseInt(tokens[1]);
            int colDesire = Integer.parseInt(tokens[2]);
            countDistance = Math.abs(rowDesire - colEntrance);// винаги брои до предходния ред
            countDistance += colDesire;

            if (hasFreeSpot(parking, rowDesire)) {
                park(parking, colEntrance, rowDesire, colDesire);
                System.out.println(countDistance);
            } else {
                System.out.println("Row " + rowDesire + " full");
            }
        }
    }

    private static void fillParking(boolean[][] parking, int rows, int cols) {

        for (int row = 0; row < rows; row++) {
            parking[row][0] = true;
        }
    }

    private static void park(boolean[][] parking, int colEntrance, int rowDesire, int colDesire) {


        if (!parking[rowDesire][colDesire]) {
            parking[rowDesire][colDesire] = true;
            countDistance += 1;
        } else {

            for (int col = colDesire + 1 ; col < parking[rowDesire].length ; col++) {
                if(!parking[rowDesire][col]){
                    parking[rowDesire][col] = true;
                    return;
                }
                countDistance+=1;
            }

            for (int col = 1; col < colDesire; col++) {
                countDistance+=1;
                if(!parking[rowDesire][col]){
                    parking[rowDesire][col] = true;
                    return;
                }
            }

        }
    }


    private static boolean hasFreeSpot(boolean[][] parking, int rowDesire) {
        boolean hasSpot = false;

        if (rowDesire < 0 || rowDesire >= parking.length) {
            return hasSpot;
        }

        for (int col = 0; col < parking[rowDesire].length; col++) {
            boolean currPlace = parking[rowDesire][col];
            if (!currPlace) {
                hasSpot = true;
                return hasSpot;
            }
        }
        return hasSpot;
    }
}
