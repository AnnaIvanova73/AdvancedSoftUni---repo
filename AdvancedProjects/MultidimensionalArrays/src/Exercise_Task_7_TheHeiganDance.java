import java.util.Scanner;
public class Exercise_Task_7_TheHeiganDance {
    private static int[] playerPosition = new int[2];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double damageMakeByPlayer = Double.parseDouble(scan.nextLine());

        double heiganLife = 3000000;
        double playerLife = 18500;
        double cloudDamage = 3500;
        double eruptionDamage = 6000;
        playerPosition[0] = 7;
        playerPosition[1] = 7;

        String spell = "";
        String causeOfDeath = "";
        boolean isHeiganMakeHit = false;
        double heiganPoints = heiganLife;

        while (playerLife > 0 && heiganLife > 0) {
            heiganPoints -= damageMakeByPlayer;
            heiganLife = Math.ceil(heiganLife-damageMakeByPlayer);

            if ("Cloud".equals(spell) && isHeiganMakeHit) {
                playerLife -= cloudDamage;
                causeOfDeath = "Plague Cloud";
            }

            boolean isBossDead = heiganLife < 1;
            boolean isPlayerDead = playerLife < 1;

            if (isBossDead || isPlayerDead) {
                break;
            }

            String[] tokens = scan.nextLine().split("\\s+");
            spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            boolean isHit = isPlayerHit(playerRow, playerCol, row, col);

            if (!isHit && !isPlayerOnTarget(playerRow, playerCol, row, col)) {
                isHeiganMakeHit = false;
                continue;
            }

            if (!isHit && canPlayerEscape(playerPosition, row, col)) {
                isHeiganMakeHit = false;
                continue;
            }

            isHeiganMakeHit = true;
            switch (tokens[0]) {
                case "Cloud":
                    playerLife -= cloudDamage;
                    causeOfDeath = "Plague Cloud";
                    break;
                case "Eruption":
                    playerLife -= eruptionDamage;
                    causeOfDeath = spell;
                    break;
            }
        }

        if (heiganLife < 1) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }

        String player = "Player: ";
        if (playerLife < 1) {
            System.out.println(player + "Killed by " + causeOfDeath);
        } else {
            System.out.printf("%s%.0f%n", player, playerLife);
        }

        System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
    }

    private static boolean canPlayerEscape(int[] playerPosition, int row, int col) {
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        if (isInBound(playerRow - 1, playerCol) &&
                !isPlayerOnTarget(playerRow - 1, playerCol, row, col)) {
            playerPosition[0] = playerRow - 1;
            return true;
        }
        if (isInBound(playerRow, playerCol + 1) &&
                !isPlayerOnTarget(playerRow, playerCol + 1, row, col)) {
            playerPosition[1] = playerCol + 1;
            return true;
        }

        if (isInBound(playerRow + 1, playerCol) &&
                !isPlayerOnTarget(playerRow + 1, playerCol, row, col)) {
            playerPosition[0] = playerRow + 1;
            return true;
        }
        if (isInBound(playerRow, playerCol - 1) &&
                !isPlayerOnTarget(playerRow, playerCol - 1, row, col)) {
            playerPosition[1] = playerCol - 1;
            return true;
        }
        return false;
    }

    private static boolean isPlayerOnTarget(int playerRow, int playerCol, int row, int col) {
        return playerRow >= row - 1 && playerRow <= row + 1 && playerCol >= col - 1 && playerCol <= col + 1;
    }

    private static boolean isInBound(int row, int col) {
        return row >= 0 && row < 15 && col >= 0 && col < 15;
    }

    private static boolean isPlayerHit(int playerRow, int playercol, int row, int col) {
        return playerRow == row && playercol == col;
    }
}
