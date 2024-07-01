package designPattern;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
  public static void main(String[] args) throws CloneNotSupportedException {
    BookShop bookShop = new BookShop();
    bookShop.setShopName("abc");
    bookShop.loadData();
    BookShop bookShop1 = bookShop.clone();
    bookShop.getBookList().remove(0);
    System.out.println(bookShop);

    bookShop1.setShopName("bcd");
    System.out.println(bookShop1);
  }

}

class Book {
  private int bid;

  public int getBid() {
    return bid;
  }

  public void setBid(int bid) {
    this.bid = bid;
  }

  public String getBname() {
    return bname;
  }

  public void setBname(String bname) {
    this.bname = bname;
  }

  private String bname;

  @Override
  public String toString() {
    return "Book{" +
        "bid=" + bid +
        ", bname='" + bname + '\'' +
        '}';
  }
}


class BookShop implements Cloneable {
  private String shopName;
  List<Book> bookList = new ArrayList<>();

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public List<Book> getBookList() {
    return bookList;
  }

  public void setBookList(List<Book> bookList) {
    this.bookList = bookList;
  }

  public void loadData() {
    for (int i = 0; i < 9; i++) {
      Book b = new Book();
      b.setBid(i);
      b.setBname("book " + i);
      getBookList().add(b);
    }
  }

  @Override
  public String toString() {
    return "BookShop{" +
        "shopName='" + shopName + '\'' +
        ", bookList=" + bookList +
        '}';
  }

  @Override
  protected BookShop clone() throws CloneNotSupportedException {
    BookShop bookShop = new BookShop();
    for (Book book : this.getBookList()){
      bookShop.getBookList().add(book);
    }
    return bookShop;
  }
}


