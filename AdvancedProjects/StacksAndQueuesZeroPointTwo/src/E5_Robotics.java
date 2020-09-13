import java.util.*;

public class E5_Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputRobots = scan.nextLine().split(";");
        int countRobots = inputRobots.length;

        String[] robots = new String[countRobots];
        int[] timePerWork = new int[countRobots];
        int[] progressTime = new int[countRobots];

        for (int i = 0; i < inputRobots.length; i++) {
            String[] tokens = inputRobots[i].split("-");
            String nameOfRobot = tokens[0];
            int workingTime = Integer.parseInt(tokens[1]);
            robots[i] = nameOfRobot;
            timePerWork[i] = workingTime;
            progressTime[i] = 0;
        }


        int[] tokens = Arrays.stream(scan.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int totalSeconds = (tokens[0] * 60) * 60 + (tokens[1] * 60) + (tokens[2]);

        ArrayDeque<String> productQueue = new ArrayDeque<>();
        String products = "";
        while (!"End".equals(products = scan.nextLine())) {
            productQueue.offer(products);
        }

        int tikTakSeconds = 0;
        while (productQueue.size() > 0) {
            tikTakSeconds += 1;

            for (int i = 0; i < countRobots; i++) {
                if (progressTime[i] > 0) {
                    progressTime[i]--;
                }
            }

            boolean isProductTake = false;
            String product = productQueue.poll();

            for (int i = 0; i < countRobots; i++) {
                String currentRobot = robots[i];
                int timeOfTheRobot = progressTime[i];

                if (timeOfTheRobot == 0) {
                    progressTime[i] = timePerWork[i];
                    isProductTake = true;
                    System.out.print(currentRobot + " - " + product + " ");
                    invokeClock(totalSeconds,tikTakSeconds);
                    break;
                }

            }
            if (!isProductTake) {
                productQueue.offer(product);
            }

        }
    }

    private static void invokeClock(int tokens, int tikTakSeconds) {
        int totalSeconds= tokens + tikTakSeconds;
        int currentHour = totalSeconds / 3600 % 24;
        int currentMin = (totalSeconds / 60 % 60);
        int currSec = totalSeconds % 60;

        String result = String.format("[%02d:%02d:%02d]", currentHour, currentMin, currSec);
        System.out.println(result);
    }
}
