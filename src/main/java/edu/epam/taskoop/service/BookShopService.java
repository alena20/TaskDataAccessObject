package edu.epam.taskoop.service;

import edu.epam.taskoop.dao.BookDao;
import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.exception.DaoException;
import edu.epam.taskoop.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BookShopService {
    private static final Logger logger = LogManager.getLogger(BookShopService.class);
    CheckData checkData = new CheckData();
    BookDao bookDao = new BookDao();

    public List<Book> add(Book book) throws ServiceException {
        if (!checkData.isDataCorrect(book)) {
                throw new ServiceException("Error add book - incorrect data.");
            }
        List<Book> resultList = new ArrayList<>();
        try {
            bookDao.addBook(book);
            resultList.add(book);
            return resultList;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Book> delete(Book book) throws ServiceException {
        List<Book> resultList = new ArrayList<>();
        try {
            bookDao.deleteBook(book);
            resultList.add(book);
            return resultList;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void update(String oldName, String newName) throws ServiceException {
        try {
            bookDao.updateBookName(oldName, newName);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Book> selectById(int id)  throws ServiceException {
        List<Book> resultList = new ArrayList<>();
        Book book = bookDao.findBookById(id);
        resultList.add(book);
        return resultList;
    }


    public List<Book> findBookByName(String name) throws ServiceException {
        if (name == "") {
            throw new ServiceException("Invalid name");
        }
        List<Book> resultList = bookDao.findBooksByName(name);
        return resultList;
    }

    public List<Book> findBookByAuthor(String name) throws ServiceException {
        if (name == "") {
            throw new ServiceException("Invalid name");
        }
        List<Book> resultList = bookDao.findBooksByAuthor(name);
        return resultList;
    }

    public List<Book> findBooksByYear(int year) throws ServiceException {
        if (year < 1000) {
            throw new ServiceException("Invalid year");
        }
        List<Book> resultList = bookDao.findBooksByYear(year);
        return resultList;
    }

    public List<Book> findBooksByPagesCount(int pages) throws ServiceException {
        if (pages < 0) {
            throw new ServiceException("Invalid pages count");
        }
        List<Book> resultList = bookDao.findBooksByPagesCount(pages);
        return resultList;
    }

    public List<Book> findBooksByPublisherName(String name) throws ServiceException {
        if (name == "") {
            throw new ServiceException("Invalid publisher name");
        }
        List<Book> resultList = bookDao.findBooksByPublisherName(name);
        return resultList;
    }
}
