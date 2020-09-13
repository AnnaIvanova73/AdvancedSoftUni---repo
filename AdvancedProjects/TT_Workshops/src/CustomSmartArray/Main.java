package CustomSmartArray;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        SmartArray number = new SmartArray();
            number.add(2,2);

        Random random = new Random ();

        for (int i = 0; i < 10; i++) {
            number.add(random.nextInt());
        }

        int sum = 0;

//        for (int i = 0; i < 10; i++) {
//            sum += number.get(i);
//        }
//
//        System.out.println(sum);
    }
}
