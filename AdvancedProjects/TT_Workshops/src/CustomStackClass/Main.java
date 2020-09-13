package CustomStackClass;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {

        ArrayDeque<String> asd = new ArrayDeque<>();
        asd.push("asd");
        asd.push("buradura");
        System.out.println(asd.peek());

        MyStack asds = new MyStack();
        asds.push(3);
        asds.push(4);
        asds.push(10);

        System.out.println(asds.pop());
    }
}
