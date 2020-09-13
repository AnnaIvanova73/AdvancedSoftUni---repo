package L2_Library;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library (Book... books) {
        this.books = books;
    }
    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book>{
        private Book[] books;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.books != null;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }
}


