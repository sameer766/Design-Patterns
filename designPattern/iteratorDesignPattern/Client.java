package all_projects.src.designPattern.iteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Client {


    public static void main(String[] args) {

        List<Book> bookList=new ArrayList<>();
        bookList.add(new Book("bbcbd", 22));
        bookList.add(new Book("cbdfhbch", 55));
        bookList.add(new Book("tytyyt", 10));
        Iterator iterator = new LibraryIterartor(bookList);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
