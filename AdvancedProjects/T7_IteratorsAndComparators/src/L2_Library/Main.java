package L2_Library;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 200);
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");


        Library<Book> library = new Library<>(bookThree, bookTwo, bookOne);

        for (Book book : library) {
            System.out.println(book);
        }

    }

}
