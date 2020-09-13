import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int[] numbers = Arrays.stream(kb.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[],int[]> add = a->Arrays.stream(a).map(e->e+1).toArray();
        Function<int[],int[]> multiply = a->Arrays.stream(a).map(e->e*2).toArray();
        Function<int[],int[]> subtract = a->Arrays.stream(a).map(e->e-1).toArray();

        Consumer<int[]> printer = a->Arrays.stream(a).forEach(c -> System.out.println(c + " "));

        String input = kb.nextLine();

        while (!input.equals("End")){
            switch (input){
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }
            input = kb.nextLine();
        }
    }
}