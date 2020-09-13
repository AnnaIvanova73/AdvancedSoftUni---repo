import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numPerOffer = scan.nextInt();
        int numPerPoll = scan.nextInt();
        ;
        int searchedNumber = scan.nextInt();
        ;
        scan.nextLine();
        ArrayDeque<Integer> queue =
                Arrays.stream(scan.nextLine().split("\\s+"))
                        .limit(numPerOffer)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayDeque::new));


        for (int i = 0; i < numPerPoll; i++) {
            if (queue.size() != 0) {
                queue.poll();
            }
        }

        int smallestElement = Integer.MAX_VALUE;
        if (queue.size() == 0) {
            smallestElement = 0;
        }

        boolean isNumFind = false;
        for (int i = 0; i < queue.size(); i++) {

            int currentNum = 0;
            if (queue.size() != 0) {
                currentNum = queue.poll();
            }

            if (currentNum == searchedNumber) {
                isNumFind = true;
                break;
            }

            if (currentNum < smallestElement) {
                smallestElement = currentNum;
            }
            i--;
        }

        if (isNumFind) {
            System.out.println("true");
        } else {
            System.out.println(smallestElement);
        }
    }

}
