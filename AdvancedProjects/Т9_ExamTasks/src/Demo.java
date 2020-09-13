import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) throws IOException {

        List<Integer> asd = new ArrayList<>();
        asd.add(1);
        asd.add(1);
        asd.add(1);
        asd.add(1);
        System.out.println(asd.size());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> materials = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(magicLevel::push);
    }

    //        int salad = this.data.get(0).getTotalCalories();
    //        Salad healthiest = this.data.get(0);
    //        for (Salad datum : data) {
    //           if(salad > datum.getTotalCalories()){
    //               salad = datum.getTotalCalories();
    //               healthiest = datum;
    //           }
    //        }
    //
    //        return healthiest;
}
