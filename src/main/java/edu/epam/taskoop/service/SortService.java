package edu.epam.taskoop.service;

import edu.epam.taskoop.dao.BookDao;
import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.entity.BookShop;
import edu.epam.taskoop.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class SortService {
    private BookDao bookDao = new BookDao();
    private BookShop bookShop = BookShop.getInstance();
    private CheckData checkData = new CheckData();

    public List<Book> sortBookById() throws ServiceException{
        List<Book> resultList = new ArrayList<>();
        if(!checkData.isEmpty(bookShop)){
            resultList = bookDao.sortBooksById();
        }else
            throw new ServiceException("book list is empty");
        return resultList;
    }

    public List<Book> sortByAuthors() throws ServiceException{
        List<Book> resultList = new ArrayList<>();
        if(!checkData.isEmpty(bookShop)){
            resultList = bookDao.sortBooksByAuthors();
        }else
            throw new ServiceException("book list is empty");
        return resultList;
    }

    public List<Book> sortByName() throws ServiceException {
        List<Book> resultList = new ArrayList<>();
        if(!checkData.isEmpty(bookShop)){
            resultList = bookDao.sortBooksByName();
        }else
            throw new ServiceException("book list is empty");
        return resultList;
    }

    public List<Book> sortByPagesCount()  throws ServiceException {
        List<Book> resultList = new ArrayList<>();
        if(!checkData.isEmpty(bookShop)){
            resultList = bookDao.sortBooksByPages();
        }else
            throw new ServiceException("book list is empty");
        return resultList;
    }

    public List<Book> sortBooksByYear()  throws ServiceException {
        List<Book> resultList = new ArrayList<>();
        if(!checkData.isEmpty(bookShop)){
            resultList = bookDao.sortBooksByYear();
        }else
            throw new ServiceException("book list is empty");
        return resultList;
    }

    public List<Book> sortBooksByPublisherName()  throws ServiceException {
        List<Book> resultList = new ArrayList<>();
        if(!checkData.isEmpty(bookShop)){
            resultList = bookDao.sortBooksByPublisherName();
        }else
            throw new ServiceException("book list is empty");
        return resultList;
    }
}
