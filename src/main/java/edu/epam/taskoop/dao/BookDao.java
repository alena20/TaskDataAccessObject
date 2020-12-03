package edu.epam.taskoop.dao;

import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.entity.BookShop;
import edu.epam.taskoop.service.CheckData;
import edu.epam.taskoop.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao<T> implements IDao<T, Book> {
    private static final Logger logger = LogManager.getLogger(BookDao.class);
    CheckData checkData = new CheckData();

    @Override
    public boolean addBook(BookShop bookShop, Book book) throws DaoException {
        boolean isAdd = false;
        if(checkData.isBookExist(bookShop,book)){
            logger.throwing(new DaoException("Error to add book - book is already exists."));
        } else {
            if (!checkData.isDataCorrect(book)) {
                logger.throwing(new DaoException("Error add book - incorrect data."));
            } else {
                bookShop.add(book);
                logger.info("Add success");
                isAdd = true;
            }
        }
        return isAdd;
    }

    @Override
    public boolean deleteBook(BookShop bookShop, Book book) throws DaoException{
        if (!checkData.isBookExist(bookShop,book)) {
            logger.throwing(new DaoException("No such book to delete"));
            return false;
        }
        bookShop.delete(book);
        logger.info("Delete success");
        return true;
    }

    @Override
    public List<Book> search(T parameter, BookShop bookShop) {
        List<Book> resultList = new ArrayList<Book>();
        for (int i = 0; i < bookShop.getBooks().size(); i++) {
            if(bookShop.getBooks().get(i).getParameretSearch(parameter) == parameter){
                resultList.add(bookShop.getBooks().get(i));
            }
        }
        return resultList;
    }

    @Override
    public Book selectBookById(BookShop bookShop, int id){
        Optional<Book> optionalBook = bookShop.getBooks().stream().filter(book->book.getId() == id).findAny();
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        else
            return null;
    }

    @Override
    public Book updateBookName(Book book, String name) {
        book.setName(name);
        return book;
    }


}
