import java.util.*;

public class E9_ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        HashMap<Integer, HashSet<Integer>> parkingMatrix = new HashMap<Integer, HashSet<Integer>>();

        for (int row = 0; row < rows; row++) {
            parkingMatrix.put(row, new HashSet<Integer>());
        }

        System.out.println();

        StringBuilder result = new StringBuilder();

        String input = "";
        while (!"stop".equals(input = scan.nextLine())) {
            String[] indexes = input.split("\\s+");

            int entryRow = Integer.parseInt(indexes[0]);
            int rowWanted = Integer.parseInt(indexes[1]);
            int colWanted = Integer.parseInt(indexes[2]);


            int finalPosition = -1;
            int startSteps = 1 + Math.abs(rowWanted - entryRow) + colWanted;
            int countStepsFinal = -1;
            boolean hasParked = false;
            //Съдържаш ли, исканата колона, ако не паркирай се
            if (!parkingMatrix.get(rowWanted).contains(colWanted)) {
                finalPosition = colWanted; // колоната на която паркирам става равна на исканата
                countStepsFinal = startSteps;// стъпките са си началните
                hasParked = true;
            } else {
                // на ляво
                for (int col = colWanted - 1; col >= 1; col--) {
                    if (!parkingMatrix.get(rowWanted).contains(col)) {
                        finalPosition = col;
                        countStepsFinal = startSteps - (colWanted - 1);
                        hasParked = true;
                    }
                }

                if (hasParked) {
                    // проверям дали например искания colIndex  15 е по-голям от подадения ми размер на масива например 4
                    // за да проверя вадя сбора от искания индекс и индекса, който съм запълнинала, в този пример при масив 4 4 той е нула плюс едно
                    int distance = colWanted - (colWanted + finalPosition);
                    // до по - голяма е
                    if (distance >= cols) {
                        cols = distance;
                    }
                    // от искания ред плюс едно до дистанцията, която е едно
                    for (int col = colWanted + 1; col < distance; col++) {
                        if (parkingMatrix.get(rowWanted).contains(col)) {
                            finalPosition = col;
                            countStepsFinal = startSteps + (col - colWanted);
                            break;
                        }
                    }
                } else {
                    // на дясно
                    for (int i = colWanted + 1; i < cols; i++) {
                        if (!parkingMatrix.get(colWanted).contains(i)) {
                            finalPosition = i;
                            countStepsFinal = startSteps + (i - colWanted);
                            hasParked = true;
                            break; //прекъсваме цикъла, когато хеша не съдържа индекса
                        }
                    }
                }

            }

            if (hasParked) {
                parkingMatrix.get(rowWanted).add(finalPosition); // запълвам в мапа стойността на колоната
                result.append(countStepsFinal).append("\r\n");
            } else {
                result.append(String.format("Row %d full", rowWanted)).append("\r\n");
            }

        }
        System.out.print(result);
    }
}

