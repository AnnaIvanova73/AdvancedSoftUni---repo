import java.util.Arrays;
import java.util.Scanner;

public class demo {
    private static class Person implements Comparable<Person>{
        //ако искаме един клас да бъде сравним, му казваме да се имплементира от себе си и override методите, заложени в Interface
        public int rating;
        @Override
        public int compareTo(Person other) { // сравнява текущата инстанция с друга
            return Integer.compare(this.rating, other.rating);
        }

        //могат да се сравнят по rating
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = new int[]{1, 2, 3, 4, 5, 6,};

        //първоначлно взима масива и копира всичко след нежелания индекс, подаваме нов масив, които е копие и му казваме да
        // копира първия масив със нежалания индекс, после се подава  дължината, която трябва да се презапише в новия масив, след копирането, в този случай три,
        // така стария масив пази  4,5,6 новия е запазил 1,2,3, и при дължината три стъпва на втори индекс и записва 4,5,6;

        array[array.length - 1] = 0;
        Arrays.stream(array).forEach(System.out::println);
    }

    ////        for (int i = 0; i < this.size; i++) {
    ////            E el = this.getAt(i);
    ////            if (el.compareTo(element) == 0) {
    ////                return true;
    ////            }
    ////        }
}
