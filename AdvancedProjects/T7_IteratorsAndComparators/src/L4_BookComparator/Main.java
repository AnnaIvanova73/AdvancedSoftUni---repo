package L4_BookComparator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("D", 10, "George Orwell");
        Book bookThree = new Book("D", 1);
        Book bookTwo = new Book("A", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.sort(new BookComparator());

        for (Book book1 : books ) {
            System.out.println(book1.toString());
        }

    }
}
