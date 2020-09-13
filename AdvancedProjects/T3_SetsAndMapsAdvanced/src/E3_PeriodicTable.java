import java.util.*;
import java.util.stream.Collectors;

public class E3_PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int compounds = Integer.parseInt(scan.nextLine());

        Set<String> elements = new HashSet<>();

        while(compounds-- > 0){
            Set<String> input = Arrays.stream(scan.nextLine().split(" "))
                    .collect(Collectors.toCollection(HashSet::new));
            elements.addAll(input);
        }

        elements.stream().sorted(String::compareTo).forEach(e -> System.out.print(e + " "));

    }
}
