package all_projects.src.designPattern.iteratorDesignPattern;

import java.util.List;

public class LibraryIterartor implements Iterator<Library>{

    List<Book> booksList;
    int currindex=0;
    LibraryIterartor(List<Book> booksList){
        this.booksList=booksList;
    }
    @Override
    public boolean hasNext() {
        return currindex < booksList.size();
    }

    @Override
    public Object next() {
        if (!hasNext()){
            return null;
        }
        Book book = booksList.get(currindex);
        currindex++;
        return book;
    }
}
