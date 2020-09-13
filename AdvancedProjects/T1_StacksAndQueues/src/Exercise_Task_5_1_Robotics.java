import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Exercise_Task_5_1_Robotics {
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        //optimisation for input with bufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //readRobots
        String[] robotsWithTime = reader.readLine().split(";");
        // store them in Array with they working time
        String[] robots = new String[robotsWithTime.length];
        int[] times = new int[robotsWithTime.length];

        int[] processTime = new int[robotsWithTime.length];
        int index = 0;
        for (String robot : robotsWithTime) {
            String[] data = robot.split("-");
            robots[index] = data[0];
            times[index] = Integer.parseInt(data[1]);
            index++;
        }
        // read time, turn time in seconds, calculate total sec
        String[] timeData = reader.readLine().split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int beginSeconds = hours * 3600 + minutes * 60 + seconds;

        //readProducts and store them in queue
        ArrayDeque<String> queue = new ArrayDeque<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            queue.offer(line);
            line = reader.readLine();
        }


        StringBuilder stringBuilder = new StringBuilder();

        // time start, product in the line
        while (!queue.isEmpty()) {
            beginSeconds++;
            String product = queue.poll();

                // calculate processTime
            for (int i = 0; i < processTime.length; i++) {
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }

            boolean isTaken = false;
            // if processTime to robots is zero, begin all over
            for (int j = 0; j <robots.length; j++) {
                if(processTime[j] == 0){
                    processTime[j] = times[j];
                    stringBuilder.append(print(robots[j],product,beginSeconds));
                    isTaken = true;
                    break;
                }
            }
            //if product isnt taken put it in back of the queue
            if(!isTaken){
            queue.offer(product);
            }

        }

        System.out.println(stringBuilder.toString());
    }


    private static String print (String robots, String product, long beginSeconds){
        long s = beginSeconds % 60;
        long min = (beginSeconds / 60) % 60;
        long hours  = (beginSeconds /(60*60)) % 24;
        return
                String.format("%s - %s [%02d:%02d:%02d]%n", robots,product,hours,min,s);

    }
}
