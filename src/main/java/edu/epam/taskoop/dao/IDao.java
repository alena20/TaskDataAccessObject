package edu.epam.taskoop.dao;

import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.entity.BookShop;
import edu.epam.taskoop.exception.DaoException;

import java.util.ArrayList;
import java.util.List;

public interface IDao<T, Book> {

    boolean addBook(BookShop bookShop, Book book) throws DaoException;
    boolean deleteBook(BookShop bookShop, Book book) throws DaoException;
    Book selectBookById(BookShop bookShop, int id);
    Book updateBookName(Book book, String name);
    List<Book> search(T parameter, BookShop bookShop);

    //T select(long id) throws DaoException;

    //List<T> selectAll() throws DaoException;

    //void update(T o, String[]params);
}
