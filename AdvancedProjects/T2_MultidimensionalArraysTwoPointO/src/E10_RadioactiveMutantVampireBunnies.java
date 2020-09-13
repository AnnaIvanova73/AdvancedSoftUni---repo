import java.util.*;
import java.util.stream.Collectors;

public class E10_RadioactiveMutantVampireBunnies {

    private static class Bunnies {
        int row;
        int col;

        public Bunnies(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

    }

    private static int[] playerPosition = new int[2];
    private static final int[] rowMovement = {1, -1, 0, 0};
    private static final int[] colMovement = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        List<List<String>> lair = new LinkedList<>();
        readStringList(scan, rows, cols, lair);


        ArrayDeque<Integer> bunniesIndexes = new ArrayDeque<>();
        List<Bunnies> rememberBunniesMovement = new ArrayList<>();
        bunniesPlaces(lair, bunniesIndexes, rememberBunniesMovement);

        String[] cmdArgs = scan.nextLine().split("");

        for (int i = 0; i < cmdArgs.length; i++) {
            String command = cmdArgs[i];
            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];
            boolean isPlayerInBounds;
            boolean canPlayerMove;
            boolean canMovePlayer;
            switch (command) {
                case "R":
                    playerCol += colMovement[3];
                    isPlayerInBounds = isInLair(lair, playerRow, playerCol);
                    if (!isPlayerInBounds) {
                        break;
                    }
                    canMovePlayer = canPlayerMove(playerRow, playerCol, bunniesIndexes,rememberBunniesMovement);
                    if (!canMovePlayer) {
                        System.out.println("is dead");
                        return;
                    } else {
                        playerPosition[1] = playerCol;
                        moveBunnies(bunniesIndexes,rememberBunniesMovement,lair);
                    }

                    if(!canMovePlayer){
                        System.out.println("is dead");
                        return;
                    }

                    break;
                case "L":
                    playerCol += colMovement[2];
                    isPlayerInBounds = isInLair(lair, playerRow, playerCol);
                    if (!isPlayerInBounds) {
                        break;
                    }
                    canMovePlayer = canPlayerMove(playerRow, playerCol, bunniesIndexes,rememberBunniesMovement);
                    if (!canMovePlayer) {
                        System.out.println("is dead");
                        return;
                    } else {
                        playerPosition[1] = playerCol;
                        moveBunnies(bunniesIndexes,rememberBunniesMovement,lair);
                    }

                    if(!canMovePlayer){
                        System.out.println("is dead");
                        return;
                    }
                    break;
                case "U":
                    playerRow += rowMovement[1];
                    isPlayerInBounds = isInLair(lair, playerRow, playerCol);
                    if (!isPlayerInBounds) {
                        break;
                    }
                    canMovePlayer = canPlayerMove(playerRow, playerCol, bunniesIndexes, rememberBunniesMovement);
                    if (!canMovePlayer) {
                        System.out.println("is dead");
                        return;
                    } else {
                        playerPosition[0] = playerRow;
                        moveBunnies(bunniesIndexes, rememberBunniesMovement, lair);
                    }

                    if (!canMovePlayer) {
                        System.out.println("is dead");
                        return;
                    }
                    break;
                case "D":
                    playerRow += rowMovement[0];
                    isPlayerInBounds = isInLair(lair, playerRow, playerCol);
                    if (!isPlayerInBounds) {
                        break;
                    }
                    canMovePlayer = canPlayerMove(playerRow, playerCol, bunniesIndexes, rememberBunniesMovement);
                    if (!canMovePlayer) {
                        System.out.println("is dead");
                        return;
                    } else {
                        playerPosition[0] = playerRow;
                        moveBunnies(bunniesIndexes, rememberBunniesMovement, lair);
                    }

                    if (!canMovePlayer) {
                        System.out.println("is dead");
                        return;
                    }
                    break;
            }
        }

        System.out.println(playerPosition[0] + " " + playerPosition [1]);
    }

    private static void moveBunnies(ArrayDeque<Integer> bunniesIndexes, List<Bunnies> rememberBunniesMovement, List<List<String>> lair) {

        for (int r = 0; r < bunniesIndexes.size() / 2; r++) {
            int row = bunniesIndexes.poll();
            int col = bunniesIndexes.poll();
            for (int i = 0; i < rowMovement.length; i++) {
                int r1 = row + rowMovement[i];
                int c1 = col + colMovement[i];
                if (isInLair(lair, r1, c1)) {
                    if(lair.get(r1).get(c1).equals("P")){
                        System.out.println(" dead");
                        return;
                    }
                    bunniesIndexes.offer(r1);
                    bunniesIndexes.offer(c1);
                    Bunnies current = new Bunnies(r1, c1);
                    rememberBunniesMovement.add(current);
                }
            }
        }
    }

    private static boolean canPlayerMove(int playerRow, int playerCol, ArrayDeque<Integer> bunniesIndexes, List<Bunnies> rememberBunniesMovement) {

        for (int i = 0; i < bunniesIndexes.size() / 2; i++) {
            int bunniRow = bunniesIndexes.poll();
            int bunniCol = bunniesIndexes.poll();

            if (playerRow == bunniRow && bunniCol == playerCol) {
                return false;
            } else if (isItCloseToBunnyCell(rememberBunniesMovement)) {
                return false;
            }
            bunniesIndexes.offer(bunniRow);
            bunniesIndexes.offer(bunniCol);

        }
        return true;
    }

    private static boolean isItCloseToBunnyCell(List<Bunnies> rememberBunniesMovement) {

        for (int r = 0; r < rowMovement.length; r++) {
            int row = playerPosition[0];
            int col = playerPosition[1];
            for (int i = 0; i < rememberBunniesMovement.size(); i++) {
                Bunnies current = rememberBunniesMovement.get(0);
                int bunnyRow = current.getRow();
                int bunnyCol = current.getCol();
                if (row == bunnyRow && bunnyCol == col) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isInLair(List<List<String>> lair, int r, int c) {
        return r >= 0 && r < lair.size() && c >= 0 && c < lair.get(r).size();
    }

    private static void bunniesPlaces(List<List<String>> lair, ArrayDeque<Integer> bunniesIndexes, List<Bunnies> rememberBunniesMovement) {
        for (int row = 0; row < lair.size(); row++) {
            for (int col = 0; col < lair.get(row).size(); col++) {
                String symbol = lair.get(row).get(col);
                if ("B".equals(symbol)) {
                    bunniesIndexes.offer(row);
                    bunniesIndexes.offer(col);
                    Bunnies current = new Bunnies(row, col);
                    rememberBunniesMovement.add(current);
                }
            }
        }
    }

    private static void readStringList(Scanner scan, int rows, int cols, List<List<String>> lair) {
        for (int row = 0; row < rows; row++) {
            List<String> input = Arrays.stream(scan.nextLine().split("")).collect(Collectors.toList());
            lair.add(new LinkedList<>());
            for (int col = 0; col < cols; col++) {
                String symbol = input.get(col);
                if ("P".equals(symbol)) {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                }
                lair.get(row).add(symbol);
            }
        }
    }
}
