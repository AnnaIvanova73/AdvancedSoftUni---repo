import java.util.*;

public class E2_SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lengthFirst = scan.nextInt();
        int lengthSecond = scan.nextInt();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while(lengthFirst-- >0){
            firstSet.add(scan.nextInt());
        }

        while(lengthSecond-- >0){
            secondSet.add(scan.nextInt());
        }
        firstSet.retainAll(secondSet);


        for (Integer integer : firstSet) {
            System.out.print(integer + " ");
        }
    }
}
