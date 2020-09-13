import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.printf("%.2f",2.34);
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println(stack.pop());


        ArrayDeque<String> queue = new ArrayDeque<>(){};
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

     //   System.out.println(queue.pop());
        System.out.println(queue.poll());
    }
}
