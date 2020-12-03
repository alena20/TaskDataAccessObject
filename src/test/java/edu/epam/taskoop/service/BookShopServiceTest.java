package edu.epam.taskoop.service;

import edu.epam.taskoop.entity.*;
import edu.epam.taskoop.exception.DaoException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookShopServiceTest {
    BookShopService bookShopService = new BookShopService();
    BookShop bookShop = BookShop.getInstance();

    @Test
    public void isAdd() throws DaoException {
        Book book = customBookInfo("someName", "someAuthors", "somePublisher", "GB",
                2010, 570, 150, "HARD");
        boolean result = bookShopService.add(bookShop,book);
        assertTrue(result);
    }

    @Test
    public void isDelete() throws DaoException{
        Book book = customBookInfo("someName", "someAuthors", "somePublisher", "GB",
                2010, 570, 150, "HARD");
        bookShopService.add(bookShop,book);
        boolean result = bookShopService.delete(bookShop,book);
        assertTrue(result);
    }

    public Book customBookInfo(String name, String authors, String publisherName, String country, int year, int pages, int price, String bind){
        Book book = new Book();
        Publisher publisher = new Publisher();
        book.setName(name);
        book.setAuthors(authors);
        publisher.setName(publisherName);
        publisher.setCountry(PublishCountry.valueOf(country));
        publisher.setYear(year);
        book.setPublisher(publisher);
        book.setPagesCount(pages);
        book.setPrice(price);
        book.setBindingType(BindingType.valueOf(bind));
        return book;
    }
}