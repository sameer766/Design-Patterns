package all_projects.src.designPattern.iteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> bookList;
    Library(){
        bookList = new ArrayList<>();
    }

    public void addBooks(Book book){
        bookList.add(book);
    }

}
