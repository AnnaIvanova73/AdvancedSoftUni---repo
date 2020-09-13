package L2_GenericArrayCreator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strings = ArrayCreator.create(10,"none");
        Integer[] integers = ArrayCreator.create(Integer.class,10,0);

        System.out.println(Arrays.toString(strings));
    }
}
