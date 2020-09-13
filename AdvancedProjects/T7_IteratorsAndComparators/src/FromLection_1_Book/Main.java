package FromLection_1_Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = List.of("Alice", "Bob", "Charlie");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
