package edu.epam.taskoop.service;

import edu.epam.taskoop.dao.BookDao;
import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.entity.BookShop;
import edu.epam.taskoop.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BookShopService {
    private static final Logger logger = LogManager.getLogger(BookShopService.class);
    BookDao bookDao = new BookDao();

    public boolean add(BookShop bookShop, Book book) throws DaoException {
        return bookDao.addBook(bookShop,book);
    }

    public boolean delete(BookShop bookShop, Book book) throws DaoException {
        return bookDao.deleteBook(bookShop,book);
    }

    public Book update(Book book, String name){
        return bookDao.updateBookName(book,name);
    }

    public Book selectById(BookShop bookShop, int id) {
        return bookDao.selectBookById(bookShop,id);
    }

    public List<Book> selectAll(BookShop bookShop){
        return bookShop.getBooks();
    }
}
