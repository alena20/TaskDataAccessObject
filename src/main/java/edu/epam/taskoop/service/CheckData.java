package edu.epam.taskoop.service;

import edu.epam.taskoop.dao.BookDao;
import edu.epam.taskoop.entity.Book;
import edu.epam.taskoop.entity.BookShop;

import java.util.ArrayList;

public class CheckData {
    public boolean isBookExist(BookShop bookShop, Book book){
        return bookShop.getBooks().contains(book);
    }

    public boolean isDataCorrect(Book book) {
        return (book.getName() != null
                && book.getAuthors() != null
                && book.getPublisher().getName() != null
                && book.getPublisher().getCountry() != null
                && book.getPublisher().getYear() > 1000
                && book.getPagesCount() > 0
                && book.getPrice() >0
                && book.getBindingType() != null);
    }
}
