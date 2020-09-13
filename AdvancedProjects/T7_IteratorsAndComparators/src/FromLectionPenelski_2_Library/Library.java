package FromLectionPenelski_2_Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) { // var arg, е масив отдолу, за това не се чупи, както ако използвам масив
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator(books);  
    }

    public static class LibIterator implements Iterator<Book> {

        private Book[] books;
        private int nextIndex;

        LibIterator(Book [] books) {
            this.nextIndex = 0; // мястото в паметта, където държим през какво сме минали  for (i = 0;
            this.books = books;
        }


        @Override
        public boolean hasNext() {
            return nextIndex < books.length; // i < books.length;
        }

        @Override
        public Book next() {
            Book book  = books[nextIndex];
            nextIndex = nextIndex + 1; // i ++ )
            return book;
        }
    }
}
