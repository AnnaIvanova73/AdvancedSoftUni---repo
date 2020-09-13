import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//runtime
public class Exercise_Task_5_January_Marto_Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputRobots = scan.nextLine().split(";");

        Map<String, Integer> robots = splitsRobotsDataIntoLinkedHashMap(inputRobots);
        int[] processTimes = new int[robots.size()];


        String[] time = scan.nextLine().split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        long totalSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();

        String line = scan.nextLine();

        while (!"End".equals(line)) {
            products.offer(line);
            line = scan.nextLine();
        }


        while (!products.isEmpty()) {
            totalSeconds++;

            String current = products.poll();
            decreaseProcessTime(processTimes);

            if (!assignJob(robots, processTimes,current, totalSeconds)) {
                products.offer(current);
            }
        }

    }

    private static void decreaseProcessTime(int[] processTime) {
        for (int i = 0; i < processTime.length; i++) {
            if (processTime[i] > 0) {
                --processTime[i];
            }
        }
    }

    private static boolean assignJob(Map<String, Integer> robots, int[] processTimes, String current, long totalSeconds) {
        for (int i = 0; i < processTimes.length; i++) {
            if (processTimes[i] == 0) {
                String robotName = "";
                int count = 0;
                for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                    if (count == i) {
                        processTimes[i] = entry.getValue();
                        logJobAssigned(entry.getKey(), current, totalSeconds);
                        return true;
                    }
                    count++;
                }
            }
        }
        return false;
    }

    private static void logJobAssigned(String key, String string, long totalSeconds) {
        long s = totalSeconds % 60;
        long min = (totalSeconds / 60) % 60;
        long hours  = (totalSeconds /(60*60)) % 24;
        System.out.println(String.format("%s - %s [%02d:%02d:%02d]", key, string, hours, min, s));
    }

    private static Map<String, Integer> splitsRobotsDataIntoLinkedHashMap(String[] inputRobots) {
        Map<String, Integer> robots = new LinkedHashMap<>();

        for (String line : inputRobots) {
            int index = line.indexOf("-");
            String name = line.substring(0, index);
            int time = Integer.parseInt(line.substring(index + 1));
            robots.put(name, time);
        }

        return robots;
    }
}
