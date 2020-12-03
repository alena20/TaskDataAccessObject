package edu.epam.taskoop.entity;

import edu.epam.taskoop.dao.BookDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BookShop {
    private static final BookShop INSTANCE = new BookShop();
    private static final Logger logger = LogManager.getLogger(BookShop.class);
    private ArrayList<Book> books = new ArrayList<Book>();

    private BookShop() {
    }

    public BookShop(ArrayList<Book> books) {
        this.books = books;
    }

    public static BookShop getInstance() {
        return INSTANCE;
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

}
