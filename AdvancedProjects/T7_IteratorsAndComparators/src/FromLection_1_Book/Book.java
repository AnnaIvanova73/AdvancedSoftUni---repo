package FromLection_1_Book;

import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;


    public Book (String title, int year, String... authors){
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
        //List<String> newAuthors = new ArrayList<>(Arrays.asList(authors)); -----> optionOne
        //Collections.addAll(newAuthors, authors) ----> optionTwo
        //List<String> newAuthors = new ArrayList<>(); -----> optionThree
        //   for (String author : authors) {
        //        boolean add = newAuthors.add(author);
       // }

    }
}
