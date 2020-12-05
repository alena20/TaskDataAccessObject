package edu.epam.taskoop.dao;

import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.exception.DaoException;
import java.util.List;

public interface IDao {

    void addBook(Book book) throws DaoException;

    void deleteBook(Book book) throws DaoException;

    Book findBookById(int id);

    void updateBookName(String oldName, String newName) throws DaoException;

    List<Book> findBooksByName(String name);

    List<Book> findBooksByAuthor(String author);

    List<Book> findBooksByYear(int year);

    List<Book> findBooksByPagesCount(int pages);

    List<Book> findBooksByPublisherName(String name);

    List<Book> sortBooksById();

    List<Book> sortBooksByName();

    List<Book> sortBooksByAuthors();

    List<Book> sortBooksByYear();

    List<Book> sortBooksByPages();

    List<Book> sortBooksByPublisherName();
}
