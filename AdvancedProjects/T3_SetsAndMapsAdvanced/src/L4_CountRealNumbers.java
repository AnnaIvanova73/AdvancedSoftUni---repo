import java.util.*;

public class L4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbersCount = new LinkedHashMap<>();

        for (double values : input) {

           if(numbersCount.containsKey(values)){
               int value = numbersCount.get(values);
               numbersCount.put(values,value + 1);
           }else{
               numbersCount.put(values,1);
           }


        }
        numbersCount.forEach((key, value) -> {
            System.out.printf("%.1f -> %d\n",key,value);
        });
    }
}
