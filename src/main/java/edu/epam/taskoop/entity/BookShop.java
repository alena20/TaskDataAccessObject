package edu.epam.taskoop.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BookShop {
    private static BookShop BookShopInstance;
    private static final Logger logger = LogManager.getLogger(BookShop.class);
    private ArrayList<Book> books = new ArrayList<Book>();


    private BookShop() {
    }
    public static BookShop getInstance() {
        if (BookShopInstance == null) {
            BookShopInstance = new BookShop();
        }
        return BookShopInstance;
    }

    public BookShop(ArrayList<Book> books) {
        this.books = books;
    }


    public void add(Book book) {
        books.add(book);
    }

    public void delete(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        List<Book> bookList = new ArrayList<>(books);
        return bookList;
    }

    @Override
    public int hashCode() {
        int result = books.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookWarehouse{");
        for (Book book : books) {
            sb.append("\n").append(book);
        }
        sb.append("\n").append('}');
        return sb.toString();
    }
}
