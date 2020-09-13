package L2_Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... string){
        this.title = title;
        this.year = year;
        this.setAuthors(string);
    }

    public String getTitle (){
        return this.title;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public int getYear (){
        return this.year;
    }

    public void setYear (int year){
        this.year = year;
    }

    public List<String> getAuthors (){
        return this.authors;
    }

    public void setAuthors(String... authors){
        List<String> newAuthors = new ArrayList<>();
        Collections.addAll(newAuthors,authors);
        this.authors = newAuthors;
    }
}
