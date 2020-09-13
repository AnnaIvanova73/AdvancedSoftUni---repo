import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class B1_DatingApp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .forEach(maleStack::push);


        ArrayDeque<Integer> femaleQueue = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));


        int matches = 0;
        while (femaleQueue.size() != 0 && maleStack.size() != 0) {
            int male = maleStack.peek();
            int fam = femaleQueue.peek();

            if (male <= 0 || fam <= 0) {
                if (male <= 0) {
                    maleStack.pop();
                }
                if (fam <= 0) {
                    femaleQueue.poll();
                }
                continue;
            }

            if ((male % 25 == 0 || fam % 25 == 0)) {

                if (male % 25 == 0) {
                    maleStack.pop();
                    maleStack.pop();
                }
                if (fam % 25 == 0) {
                    femaleQueue.poll();
                    femaleQueue.poll();
                }
                continue;
            }

            if (male == fam) {
                maleStack.pop();
                femaleQueue.poll();
                matches++;
            } else {
                femaleQueue.poll();
                int decreaseValue = maleStack.pop() - 2;
                maleStack.push(decreaseValue);
            }

        }

        System.out.println("Matches: " + (matches == 0 ? "0" : matches));
        System.out.print("Males left: ");

        if (maleStack.isEmpty()) {
            System.out.println("none");
        } else {
            String collect = Arrays.stream(maleStack.toArray())
                    .map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(collect);
        }

        System.out.print("Females left: ");
        if (femaleQueue.isEmpty()) {
            System.out.print("none");
        } else {
            String collect = Arrays.stream(femaleQueue.toArray())
                    .map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(collect);
        }
    }
}
